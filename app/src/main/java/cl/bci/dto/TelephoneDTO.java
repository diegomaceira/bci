package cl.bci.dto;

import lombok.Data;
@Data
public class TelephoneDTO {
	private int id;
	private long number;
	private int citycode;
	private String contrycode;
}