package cl.bci.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Telephone {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)   	
	@Column
	private int id;
	@Column
	private long number;
	@Column
	private int citycode;
	@Column
	private String contrycode;

}

