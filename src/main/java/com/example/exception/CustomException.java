package com.example.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {
	
	private HttpStatus httpStatus;
	
	public  CustomException(String message,HttpStatus httpStatus) {
		super(message);
		setHttpStatus(httpStatus);
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
