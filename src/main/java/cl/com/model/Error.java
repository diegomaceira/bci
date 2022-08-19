package cl.com.model;

import java.util.List;

public class Error{
	
	private List<ErrorDetail> error;

	public Error(List<ErrorDetail> error) {		
		this.error=error;		
	}
	
	public List<ErrorDetail> getError() {
		return error;
	}

	public void setError(List<ErrorDetail> error) {
		this.error = error;
	}
	
}
