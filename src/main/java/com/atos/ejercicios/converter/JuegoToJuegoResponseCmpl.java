package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.dto.response.JuegoResponseCompl;
import com.atos.ejercicios.entitie.Juego;

public class JuegoToJuegoResponseCmpl implements Converter<Juego, JuegoResponseCompl> {

	@Override
	public JuegoResponseCompl convert(Juego juego) {
		JuegoResponseCompl juegoResponse = new JuegoResponseCompl();
		juegoResponse.setTitulo(juego.getTitle());
		juegoResponse.setDescripcion(juego.getDescription());
		juegoResponse.setFecha(juego.getRelease());
		return juegoResponse;
	}

	
}
