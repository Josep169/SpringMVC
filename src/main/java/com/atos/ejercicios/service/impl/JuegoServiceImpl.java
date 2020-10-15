package com.atos.ejercicios.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.ejercicios.converter.GeneroEnumToGenero;
import com.atos.ejercicios.converter.GeneroToGeneroDto;
import com.atos.ejercicios.converter.JuegoRequestToJuego;
import com.atos.ejercicios.converter.JuegoToJuegoResponse;
import com.atos.ejercicios.converter.JuegoToJuegoResponseCmpl;
import com.atos.ejercicios.dto.request.JuegoRequest;
import com.atos.ejercicios.dto.response.JuegoResponse;
import com.atos.ejercicios.dto.response.JuegoResponseCompl;
import com.atos.ejercicios.entitie.Juego;
import com.atos.ejercicios.helper.JuegoHelper;
import com.atos.ejercicios.repository.JuegoRepository;
import com.atos.ejercicios.service.JuegoService;

@Service
public class JuegoServiceImpl implements JuegoService {

	@Autowired
	JuegoRepository juegoRepository;

	JuegoRequestToJuego jRTJ = new JuegoRequestToJuego();
	JuegoToJuegoResponse jTJR = new JuegoToJuegoResponse();
	JuegoToJuegoResponseCmpl jTJRC = new JuegoToJuegoResponseCmpl();
	GeneroEnumToGenero gETG = new GeneroEnumToGenero();
	GeneroToGeneroDto gTGD = new GeneroToGeneroDto();

	@Autowired
	JuegoHelper juegoHelper;
	
	@Override
	public JuegoResponse agregarJuego(JuegoRequest juegoRequest) {
		juegoHelper.existeJuego(juegoRequest);
		Juego juego = juegoHelper.convertirJuegoRequestAJuego(juegoRequest);
		juegoRepository.save(juego);
		return jTJR.convert(juego);
	}
	
	@Override
	public JuegoResponseCompl verJuego(String title) {
		Optional<Juego> juego = juegoHelper.comprobarJuego(title);
		JuegoResponseCompl juegoResponse = juegoHelper.convertirJuegoAJuegoResponseCompl(juego);
		return juegoResponse;
	}
}
