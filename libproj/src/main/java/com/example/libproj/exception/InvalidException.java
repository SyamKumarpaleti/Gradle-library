package com.example.libproj.exception;

public class InvalidException {
	private static final long serialVersionUID = 2886693966507369162L;
	private String message;
	public InvalidException(String message) {
		
		super();
		
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
