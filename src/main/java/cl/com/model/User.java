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
import javax.validation.constraints.Email;

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
	@Email(message = "formato de email invalido")
	private String email;
	
	@Column
	private String password;
	
	@OneToMany(targetEntity=Telephone.class,cascade = CascadeType.ALL)  
    private List<Telephone> phones;  
	
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

}

