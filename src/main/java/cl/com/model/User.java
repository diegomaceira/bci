package cl.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id  	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)   
	@Column
	private int id;

	@Column
	private String name;
	
	@Column	
	private String email;
	
	@Column
	private String password;	

	@Column
	private String created;

	@Column
	private String lastLogin;

	@Column
	private String token;

	@Column
	private Boolean isActive;
		
	@OneToMany(targetEntity= Telephone.class,cascade = CascadeType.ALL)
    private List<Telephone> phones;  
	
	public User(String name, String email, String password, List<Telephone> phones) {			
		this.name = name;
		this.email = email;
		this.password = password;		
		this.phones = phones;
	}
	
	public User(int id,String created, String lastLogin, String token, boolean isActive) {			
		this.id = id;
		this.created = created;
		this.lastLogin = lastLogin;
		this.token = token;		
		this.isActive = isActive;
	}
	
	public User(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Telephone> getPhones() {
		return phones;
	}

	public void setPhones(List<Telephone> phones) {
		this.phones = phones;
	}
	
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}

