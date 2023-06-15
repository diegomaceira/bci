package cl.bci.mapper;

import cl.bci.dto.TelephoneDTO;
import cl.bci.dto.UserDTO;
import cl.bci.model.Telephone;
import cl.bci.model.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserMapper {

    public UserDTO convertUserToUserDTO(User user) {

        Set<TelephoneDTO> telephones = new HashSet<>();
        for (Telephone telephone : user.getPhones()) {
            TelephoneDTO phone = new TelephoneDTO(telephone.getId(), telephone.getNumber(), telephone.getCitycode(), telephone.getContrycode());
            telephones.add(phone);
        }

        return UserDTO.builder().created(user.getCreated()).id(user.getId()).password(user.getPassword()).email(user.getEmail()).lastLogin(user.getLastLogin()).isActive(user.getIsActive()).token(user.getToken()).name(user.getName()).phones(telephones).build();

    }

    public User convertUserDTOToUser(UserDTO userDTO) {

        Set<Telephone> telephones = new HashSet<>();
        for (TelephoneDTO telephone : userDTO.getPhones()) {
            Telephone phone = new Telephone(telephone.getId(), telephone.getNumber(), telephone.getCitycode(), telephone.getContrycode());
            telephones.add(phone);
        }

        return User.builder().created(userDTO.getCreated()).id(userDTO.getId()).password(userDTO.getPassword()).email(userDTO.getEmail()).lastLogin(userDTO.getLastLogin()).isActive(userDTO.getIsActive()).token(userDTO.getToken()).name(userDTO.getName()).phones(telephones).build();
    }

}
