package com.atos.ejercicios.service;

import java.util.Optional;

import com.atos.ejercicios.dto.request.TiendaRequest;
import com.atos.ejercicios.dto.response.TiendaResponse;
import com.atos.ejercicios.entitie.Tienda;

public interface TiendaService {

	public TiendaResponse agregarTienda(TiendaRequest tiendaRequest);
		
	public TiendaRequest verTienda(String titulo);
	
	public Optional<Tienda> obtenerTienda(String titulo);

}
