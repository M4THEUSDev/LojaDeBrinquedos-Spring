package com.loja.faculdade.entities.exceptions;

public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String string) {
        super("usario não encontrado com o ID: " + string);
    }
}
