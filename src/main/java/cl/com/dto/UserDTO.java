package cl.com.dto;
import cl.com.model.Telephone;
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
	private Set<Telephone> phones;
	public UserDTO(String name, String email, String password, Set<Telephone> phones) {
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

