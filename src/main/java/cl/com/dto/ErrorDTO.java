package cl.com.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
	private List<ErrorDetailDTO> errorDetail = new ArrayList<>();
	@Override
	public String toString() {
		return "{" +
				"\"error\":" + errorDetail  +
				'}';
	}
}
