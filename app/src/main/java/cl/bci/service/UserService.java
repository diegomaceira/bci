package cl.bci.service;

import cl.bci.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser();
    UserDTO getUserById(int id);
    UserDTO save(UserDTO userDto);

}
