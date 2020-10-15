package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.dto.request.JuegoRequest;
import com.atos.ejercicios.entitie.Juego;

public class JuegoRequestToJuego implements Converter<JuegoRequest, Juego>{

	@Override
	public Juego convert(JuegoRequest juegoRequest) {
		Juego juego = new Juego();
		juego.setTitle(juegoRequest.getTitulo());
		juego.setRelease(juegoRequest.getFecha());
		juego.setDescription(juegoRequest.getDescripcion());
		return juego;
	}

}
