package com.atos.ejercicios.service;

import java.util.Optional;

import com.atos.ejercicios.dto.request.JuegoRequest;
import com.atos.ejercicios.dto.response.JuegoResponse;
import com.atos.ejercicios.dto.response.JuegoResponseCompl;
import com.atos.ejercicios.entitie.Juego;


public interface JuegoService {

	public JuegoResponse agregarJuego(JuegoRequest gameDto);
	
	public JuegoResponseCompl verJuego(String title);
	
	public String borrarJuego(String title);
	
	public JuegoResponse actualizarJuego(JuegoRequest juegoA);
	
	public Optional<Juego> obtenerJuego(String titulo);
}
