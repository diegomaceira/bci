package cl.bci.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import cl.bci.dto.ErrorDTO;
import cl.bci.dto.ErrorDetailDTO;
import cl.bci.dto.UserDTO;
import cl.bci.exception.InvalidDataException;
import cl.bci.mapper.UserMapper;
import cl.bci.repository.UserRepository;
import cl.bci.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
  
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserMapper userMapper;

	public UserService(UserRepository userRepository,JwtTokenUtil jwtTokenUtil,UserMapper userMapper) {
		this.userRepository=userRepository;
		this.jwtTokenUtil=jwtTokenUtil;
		this.userMapper=userMapper;
	}

	public List<UserDTO> getAllUser() {
		return userRepository.findAll().stream().map(
				user-> userMapper.convertUserToUserDTO(user)
		).collect(Collectors.toList());
	}
  
	public UserDTO getUserById(int id) {
		return userMapper.convertUserToUserDTO(userRepository.findById(id));
	}

	public UserDTO save(UserDTO userDto) {

		ErrorDTO error = new ErrorDTO();
		String formatedDate = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a").format(new Date());

		validateIfUserExist(error.getErrorDetail(), userDto.getEmail(),formatedDate);

		validateEmail( error.getErrorDetail(), userDto.getEmail(), formatedDate);

		validatePassword(error.getErrorDetail(), userDto.getPassword(), formatedDate);

		if(error.getErrorDetail().size()>0){
			throw new InvalidDataException(error.toString());
		}

		userDto.setCreated(formatedDate);
		userDto.setLastLogin(formatedDate);
		userDto.setIsActive(true);
		userDto.setToken(jwtTokenUtil.generateToken(userDto.getName()));
		userDto.setPassword(generateEncondedPassword(userDto.getPassword()));
		
		userRepository.save(userMapper.convertUserDTOToUser(userDto));
		
		return new UserDTO(userDto.getId(),userDto.getCreated(),userDto.getLastLogin(),userDto.getToken(),userDto.getIsActive());
	}

	public void validateIfUserExist(List<ErrorDetailDTO> errorDetail, String email, String formatedDate){
		if(userRepository.findByEmail(email)!=null)errorDetail.add(new ErrorDetailDTO(formatedDate, 400, "Ya existe un usuario con ese email"));
	}
	public void validatePassword(List<ErrorDetailDTO> errorDetail, String password, String formatedDate){
		if(!Pattern.compile("(?=^(?:\\D*\\d\\D*){2}$)(?=^(?:[a-z0-9]*[A-Z][a-z0-9]*)$)^\\w{8,12}$").matcher(password).matches()) errorDetail.add(new ErrorDetailDTO(formatedDate, 400, "Formato de password invalido"));
	}
	public void validateEmail(List<ErrorDetailDTO> errorDetail, String email, String formatedDate){
		if(!Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$").matcher(email).matches()) errorDetail.add(new ErrorDetailDTO(formatedDate, 400, "Formato de email invalido"));
	}
	public String generateEncondedPassword(String password){
		return new BCryptPasswordEncoder().encode(password);
	}

}
