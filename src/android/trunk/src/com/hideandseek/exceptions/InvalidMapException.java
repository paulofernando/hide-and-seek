package com.hideandseek.exceptions;

public class InvalidMapException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidMapException() {
		super("The map is an invalide map!");
	}

}
