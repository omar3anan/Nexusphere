package com.RestAPIs.restfulwebservice.BeanVsText;

//CREATE the JSON BODY

public class HelloJsonBean {
	private String message;

	public HelloJsonBean(String message) {
		super();
		this.message = message;
//			JSON
//		{
//			message:****
//		}

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	@Override
//	public String toString() {
//		return "HelloJsonBean [message=" + message + "]";
//	}

}
