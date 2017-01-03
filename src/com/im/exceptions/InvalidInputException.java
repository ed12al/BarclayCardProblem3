package com.im.exceptions;

public class InvalidInputException extends Exception {
	
	private static final long serialVersionUID = 1104868158111535765L;

	public InvalidInputException() {
		super("Invaild input!");
	}
	
	public InvalidInputException(String message) {
		super(message);
	}
}
