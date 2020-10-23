package com.atos.ejercicios.helper;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atos.ejercicios.entitie.Tienda;
import com.atos.ejercicios.exceptions.generic.JuegoKOException;

@Service
public class TiendaHelper {

	
	public void existeTienda(Optional<Tienda> tienda) {
		if(tienda.isPresent()) {
			throw new JuegoKOException("Este juego ya existe.");
	}
	}
	
	public Optional<Tienda> comprobarTienda(Optional<Tienda> tienda) {
	if(tienda.isPresent()) {
	    return tienda;
	} else {
		throw new JuegoKOException("Juego no encontrado");
	}
	}
	
}
