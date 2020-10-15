package com.atos.ejercicios.service;

import com.atos.ejercicios.dto.request.JuegoRequest;
import com.atos.ejercicios.dto.response.JuegoResponse;
import com.atos.ejercicios.dto.response.JuegoResponseCompl;


public interface JuegoService {

	public JuegoResponse agregarJuego(JuegoRequest gameDto);
	
	public JuegoResponseCompl verJuego(String title);
}
