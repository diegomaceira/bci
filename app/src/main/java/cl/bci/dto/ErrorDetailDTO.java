package cl.bci.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetailDTO {

	private String timestamp;
	private int codigo;
	private String detail;

	@Override
	public String toString() {
		return "{" +
				"\"timestamp\":" + "\"" + timestamp + "\"," +
				"\"codigo\":" + codigo + "," +
				"\"detail\":" + "\"" + detail + "\"" +
				'}';
	}
}
