package com.atos.ejercicios.helper;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atos.ejercicios.entitie.Cliente;
import com.atos.ejercicios.exceptions.generic.JuegoKOException;

@Service
public class ClienteHelper {
	
	public Optional<Cliente> comprobarCliente(Optional<Cliente> cliente) {
	if(cliente.isPresent()) {
	    return cliente;
	} else {
		throw new JuegoKOException("Juego no encontrado");
	}
	}
	
	public void existeCliente(Optional<Cliente> cliente) {
		if(cliente.isPresent()) {
			throw new JuegoKOException("Este juego ya existe.");
		}
	}
}
