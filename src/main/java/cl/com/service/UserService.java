package cl.com.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import cl.com.dto.UserDTO;
import cl.com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.com.model.ErrorDetail;
import cl.com.model.User;
import cl.com.repository.UserRepository;
import cl.com.security.JwtTokenUtil;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
  
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserMapper userMapper;

	public UserService() {
	}

	public List<UserDTO> getAllUser() {
		return userRepository.findAll().stream().map(
				user-> userMapper.convertUserToUserDTO(user)
		).collect(Collectors.toList());
	}
  
	public UserDTO getUserById(int id) {
		User user = userRepository.findById(id);
		return userMapper.convertUserToUserDTO(user);
	}

	public UserDTO save(UserDTO user) {
				
		List<ErrorDetail> errorDetail = new ArrayList<ErrorDetail>();
		String formatedDate = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a").format(new Date());

		validateUser(errorDetail, user.getEmail(),formatedDate);

		validateEmail( errorDetail, user.getEmail(), formatedDate);

		validatePassword(errorDetail, user.getPassword(), formatedDate);

		if(errorDetail.size()>0){
			//return ResponseEntity.badRequest().body(new cl.com.model.Error(errorDetail));
			throw new RuntimeException(errorDetail.toString());
		}
			          	
		user.setCreated(formatedDate);
		user.setLastLogin(formatedDate);
		user.setIsActive(true);
		user.setToken(jwtTokenUtil.generateToken(user.getName()));

		String encoded = new BCryptPasswordEncoder().encode(user.getPassword());
		
		user.setPassword(encoded);
		
		userRepository.save(userMapper.convertUserDTOToUser(user));
		
		return new UserDTO(user.getId(),user.getCreated(),user.getLastLogin(),user.getToken(),user.getIsActive());
	}

	public void validateUser(List<ErrorDetail> errorDetail,String email,String formatedDate){
		if(userRepository.findByEmail(email)!=null)errorDetail.add(new ErrorDetail(formatedDate, 400, "Ya existe un usuario con ese email"));
	}
	public void validatePassword(List<ErrorDetail> errorDetail,String password,String formatedDate){
		if(!Pattern.compile("(?=^(?:\\D*\\d\\D*){2}$)(?=^(?:[a-z0-9]*[A-Z][a-z0-9]*)$)^\\w{8,12}$").matcher(password).matches()) errorDetail.add(new ErrorDetail(formatedDate, 400, "Formato de password invalido"));
	}

	public void validateEmail(List<ErrorDetail> errorDetail,String email,String formatedDate){
		if(!Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$").matcher(email).matches()) errorDetail.add(new ErrorDetail(formatedDate, 400, "Formato de email invalido"));
	}
	
}
