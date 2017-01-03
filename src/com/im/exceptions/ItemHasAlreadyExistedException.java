package com.im.exceptions;

public class ItemHasAlreadyExistedException extends Exception {

	private static final long serialVersionUID = -3970159020140994662L;

	public ItemHasAlreadyExistedException() {
		super("This item has already existed!");
	}
	
	public ItemHasAlreadyExistedException(String message) {
		super(message);
	}
}
