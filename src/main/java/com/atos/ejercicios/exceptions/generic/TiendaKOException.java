package com.atos.ejercicios.exceptions.generic;

public class TiendaKOException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final String detalle;
	
	public TiendaKOException(String detalle) {
		this.detalle = detalle;
	}

	public String getDetalle() {
		return detalle;
	}	
	
	

}
