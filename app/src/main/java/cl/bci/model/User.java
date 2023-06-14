package cl.bci.model;


import cl.bci.dto.TelephoneDTO;
import lombok.*;

import java.util.Set;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Set<Telephone> phones;

	public User(int id,String name, String email, String password, Set<Telephone> phones) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

}

