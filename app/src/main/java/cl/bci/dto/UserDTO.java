package cl.bci.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String password;
    private String created;
    private String lastLogin;
    private String token;
    private Boolean isActive;
    private Set<TelephoneDTO> phones;

}

