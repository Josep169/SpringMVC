package com.atos.ejercicios.exceptions;

import com.atos.ejercicios.exceptions.generic.NotFoundException;

public class JuegoKONotFoundException extends NotFoundException {
	
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Game not found";

	public JuegoKONotFoundException() {
		super(MESSAGE);
	}
	
	public JuegoKONotFoundException(String detalle) {
		super(detalle);
	}
	
	

}
