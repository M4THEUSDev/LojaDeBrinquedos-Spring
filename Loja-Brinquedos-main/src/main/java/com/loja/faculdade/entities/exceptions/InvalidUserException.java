package com.loja.faculdade.entities.exceptions;

public class InvalidUserException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public InvalidUserException(String message) {
        super(message);
    }
}
