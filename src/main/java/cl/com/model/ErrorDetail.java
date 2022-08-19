package cl.com.model;

import java.sql.Timestamp;

public class ErrorDetail {

	private Timestamp timestamp;
	private int codigo;
	private String detail;
	
	public ErrorDetail(Timestamp timestamp,int codigo,String detail) {
		this.timestamp=timestamp;
		this.codigo=codigo;
		this.detail=detail;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
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
