package com.gmt.ecommerce.dao.impl;

public class ResponseDTO {
	
	public static final String FAILURE = "Failure";
	public static final String SUCCESS = "Success";
	
	private String status;
	private String message;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
