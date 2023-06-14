package cl.com.mapper;

import cl.com.dto.UserDTO;
import cl.com.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO convertUserToUserDTO(User user){
        UserDTO userDto = new UserDTO();
        userDto.setCreated(user.getCreated());
        userDto.setId(user.getId());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setLastLogin(user.getLastLogin());
        userDto.setIsActive(user.getIsActive());
        userDto.setToken(user.getToken());
        userDto.setPhones(user.getPhones());
        userDto.setName(user.getName());

        return userDto;
    }

    public User convertUserDTOToUser(UserDTO userDTO){
        User user = new User();
        user.setCreated(userDTO.getCreated());
        user.setId(userDTO.getId());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setLastLogin(userDTO.getLastLogin());
        user.setIsActive(userDTO.getIsActive());
        user.setToken(userDTO.getToken());
        user.setPhones(userDTO.getPhones());
        user.setName(userDTO.getName());

        return user;
    }

}
