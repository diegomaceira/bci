package cl.com.model;

public class ErrorDetail {

	private String timestamp;
	private int codigo;
	private String detail;
	
	public ErrorDetail(String timestamp,int codigo,String detail) {
		this.timestamp=timestamp;
		this.codigo=codigo;
		this.detail=detail;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
