package com.atos.ejercicios.exceptions;

import com.atos.ejercicios.exceptions.generic.NotFoundException;

public class JuegoNotFoundException extends NotFoundException{

	private static final long serialVersionUID = 1L;
	
	private static final String DETAIL = "Juego no encontrado";
	
	
	public JuegoNotFoundException(String detalle) {
		super(detalle);
	}

	public JuegoNotFoundException() {
		super(DETAIL);
	}
}
