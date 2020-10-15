package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.dto.response.JuegoResponse;
import com.atos.ejercicios.entitie.Juego;

public class JuegoToJuegoResponse implements Converter<Juego, JuegoResponse> {

	@Override
	public JuegoResponse convert(Juego juego) {
		JuegoResponse juegoResponse = new JuegoResponse();
		juegoResponse.setTitle(juego.getTitle());
		juegoResponse.setDate(juego.getRelease());
		return juegoResponse;
	}

	
}
