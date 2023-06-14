package cl.bci.mapper;

import cl.bci.dto.TelephoneDTO;
import cl.bci.dto.UserDTO;
import cl.bci.model.Telephone;
import cl.bci.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
        userDto.setName(user.getName());

        Set<TelephoneDTO> telephones = new HashSet<>();
        for (Telephone telephone:user.getPhones()) {
            TelephoneDTO teleDto = new TelephoneDTO();
            teleDto.setId(telephone.getId());
            teleDto.setContrycode(telephone.getContrycode());
            teleDto.setNumber(telephone.getNumber());
            teleDto.setCitycode(telephone.getCitycode());
            telephones.add(teleDto);
        }
        userDto.setPhones(telephones);

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
        user.setName(userDTO.getName());

        Set<Telephone> telephones = new HashSet<>();
        for (TelephoneDTO telephone:userDTO.getPhones()) {
            Telephone teleDto = new Telephone();
            teleDto.setId(telephone.getId());
            teleDto.setContrycode(telephone.getContrycode());
            teleDto.setNumber(telephone.getNumber());
            teleDto.setCitycode(telephone.getCitycode());
            telephones.add(teleDto);
        }
        user.setPhones(telephones);

        return user;
    }

}
