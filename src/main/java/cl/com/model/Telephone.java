package cl.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table
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

	public Telephone(long number, int citycode, String contrycode) {		
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
	}

	public Telephone() {		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public long getNumber() {
		return number;
	}
	
	public void setNumber(long number) {
		this.number = number;
	}
	
	public int getCitycode() {
		return citycode;
	}
	
	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}
	
	public String getContrycode() {
		return contrycode;
	}
	
	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

}

