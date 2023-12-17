package com.RestAPIs.restfulwebservice.HandleError;

//{
//  status:500,
//      "message":"******",
//      "timeStap":5644
//}
public class ErrorResponse {
	private int status;
	private String message;
	private long timeStamp;
	private String description;

	public ErrorResponse() {
	}

	public ErrorResponse(int status, String message, long timeStamp, String description) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
