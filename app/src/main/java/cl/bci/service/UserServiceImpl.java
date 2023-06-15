package cl.bci.service;

import cl.bci.dto.ErrorDTO;
import cl.bci.dto.ErrorDetailDTO;
import cl.bci.dto.UserDTO;
import cl.bci.exception.InvalidDataException;
import cl.bci.mapper.UserMapper;
import cl.bci.model.User;
import cl.bci.repository.UserRepository;
import cl.bci.security.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, JwtTokenUtil jwtTokenUtil, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUser() {
        log.info("buscar todos los usuarios");
        return userRepository.findAll().stream().map(
                user -> userMapper.convertUserToUserDTO(user)
        ).collect(Collectors.toList());
    }

    public UserDTO getUserById(int id) {
        log.info("buscar usuario por id: " + id);
        return userMapper.convertUserToUserDTO(userRepository.findById(id));
    }

    public UserDTO save(UserDTO userDto) {

        log.info("alta usuario: " + userDto);

        ErrorDTO error = new ErrorDTO();
        String formatedDate = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a").format(new Date());

        validateIfUserExist(error.getErrorDetail(), userDto.getEmail(), formatedDate);

        validateEmail(error.getErrorDetail(), userDto.getEmail(), formatedDate);

        validatePassword(error.getErrorDetail(), userDto.getPassword(), formatedDate);

        if (error.getErrorDetail().size() > 0) {
            throw new InvalidDataException(error.toString());
        }

        userDto.setCreated(formatedDate);
        userDto.setLastLogin(formatedDate);
        userDto.setIsActive(true);
        userDto.setToken(jwtTokenUtil.generateToken(userDto.getName()));
        userDto.setPassword(generateEncondedPassword(userDto.getPassword()));

        User userModel = userRepository.save(userMapper.convertUserDTOToUser(userDto));

        log.info("usuario almacenado: " + userModel);

        return UserDTO.builder().id(userModel.getId()).created(userModel.getCreated()).lastLogin(userModel.getLastLogin()).token(userModel.getToken()).isActive(userModel.getIsActive()).build();
    }

    public void validateIfUserExist(List<ErrorDetailDTO> errorDetail, String email, String formatedDate) {
        log.info("validacion usuario en db");
        if (userRepository.findByEmail(email) != null)
            errorDetail.add(new ErrorDetailDTO(formatedDate, 400, "Ya existe un usuario con ese email"));
    }

    public void validatePassword(List<ErrorDetailDTO> errorDetail, String password, String formatedDate) {
        log.info("validacion password con formato correcto");
        if (!Pattern.compile("(?=^(?:\\D*\\d\\D*){2}$)(?=^(?:[a-z0-9]*[A-Z][a-z0-9]*)$)^\\w{8,12}$").matcher(password).matches())
            errorDetail.add(new ErrorDetailDTO(formatedDate, 400, "Formato de password invalido"));
    }

    public void validateEmail(List<ErrorDetailDTO> errorDetail, String email, String formatedDate) {
        log.info("validacion email con formato correcto");
        if (!Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$").matcher(email).matches())
            errorDetail.add(new ErrorDetailDTO(formatedDate, 400, "Formato de email invalido"));
    }

    public String generateEncondedPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
