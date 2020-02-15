package com.catalogue.product.model;

import org.springframework.http.HttpStatus;

public class SuccessMessage {
	private String message;
	private HttpStatus status;
	public SuccessMessage(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}
	@Override
	public String toString() {
		return "SuccessMessage [message=" + message + ", status=" + status + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
	

}
