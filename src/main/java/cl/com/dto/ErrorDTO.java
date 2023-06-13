package cl.com.dto;


import java.util.List;

public class ErrorDTO {
	
	private List<ErrorDetailDTO> error;

	public ErrorDTO(List<ErrorDetailDTO> error) {
		this.error=error;		
	}
	
	public List<ErrorDetailDTO> getError() {
		return error;
	}

	public void setError(List<ErrorDetailDTO> error) {
		this.error = error;
	}
	
}
