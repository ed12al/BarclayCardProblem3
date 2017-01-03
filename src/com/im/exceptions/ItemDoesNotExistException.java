package com.im.exceptions;

public class ItemDoesNotExistException extends Exception {

	private static final long serialVersionUID = -3970159020140994662L;

	public ItemDoesNotExistException() {
		super("This item does not exist!");
	}
	
	public ItemDoesNotExistException(String message) {
		super(message);
	}
}
