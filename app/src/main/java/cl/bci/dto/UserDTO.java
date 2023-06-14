package cl.bci.dto;
import lombok.Data;
import java.util.Set;

@Data
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
	public UserDTO(String name, String email, String password, Set<TelephoneDTO> phones) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

	public UserDTO(int id,String name, String email, String password, Set<TelephoneDTO> phones) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

	public UserDTO(int id,String created, String lastLogin, String token, boolean isActive) {
		this.id = id;
		this.created = created;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
	}

	public UserDTO(){

	}

}

