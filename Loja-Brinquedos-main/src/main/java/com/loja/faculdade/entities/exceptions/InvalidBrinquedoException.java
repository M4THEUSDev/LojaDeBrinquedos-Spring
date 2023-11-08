package com.loja.faculdade.entities.exceptions;

public class InvalidBrinquedoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidBrinquedoException(String message) {
		super(message);
	}
}
