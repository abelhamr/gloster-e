package ma.gloster.microservice.dto;

public class ResponseDTO {
	
	private String message;
	private String data;
	private String status;
	
	
	
	public ResponseDTO(String message) {
		super();
		this.message = message;
	}
	public ResponseDTO(String message, String data) {
		super();
		this.message = message;
		this.data = data;
	}
	public ResponseDTO(String message, String data, String status) {
		super();
		this.message = message;
		this.data = data;
		this.status = status;
	}
	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
	    if(this.status!=null) {
	    	return "{ message : "+this.message+", data: "+this.data+", status : "+this.status+"}";
	    }else {
	    	if(this.data!=null) return "{ message : "+this.message+", data: "+this.data+"}";
	    	 return "{ message : "+this.message+"}";
	    }
				
	}

}
