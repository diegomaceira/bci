package cl.com.dto;


import java.util.ArrayList;
import java.util.List;

public class ErrorDTO {
	public ErrorDTO(){}
	private List<ErrorDetailDTO> errorDetail = new ArrayList<>();

	public ErrorDTO(List<ErrorDetailDTO> error) {
		this.errorDetail=error;
	}

	public List<ErrorDetailDTO> getErrorDetail() {
		return errorDetail;
	}
	public void setErrorDetail(List<ErrorDetailDTO> errorDetail) {
		this.errorDetail = errorDetail;
	}

	@Override
	public String toString() {
		return "{" +
				"\"error\":" + errorDetail  +
				'}';
	}
}
