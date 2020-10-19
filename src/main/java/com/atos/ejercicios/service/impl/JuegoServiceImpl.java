package com.atos.ejercicios.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.ejercicios.converter.JuegoToJuegoResponse;
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

	JuegoToJuegoResponse jTJR = new JuegoToJuegoResponse();

	@Autowired
	JuegoHelper juegoHelper;
	
	@Override
	public JuegoResponse agregarJuego(JuegoRequest juegoRequest) {
		Optional<Juego> juegoE = juegoRepository.findBytitle(juegoRequest.getTitulo());
		juegoHelper.existeJuego(juegoE);
		Juego juego = juegoHelper.convertirJuegoRequestAJuego(juegoRequest);
		juegoRepository.save(juego);
		return jTJR.convert(juego);
	}
	
	@Override
	public JuegoResponseCompl verJuego(String title) {
		Optional<Juego> juego = juegoRepository.findBytitle(title);
		juegoHelper.comprobarJuego(juego);
		JuegoResponseCompl juegoResponse = juegoHelper.convertirJuegoAJuegoResponseCompl(juego);
		return juegoResponse;
	}

	@Override
	public String borrarJuego(String title) {
		Optional<Juego> juego = juegoRepository.findBytitle(title);
		Juego juegoE = juegoHelper.comprobarJuego(juego).get();
		juegoRepository.deleteById(juegoE.getId());
		return ("Juego borrado con exito");
	}

	@Override
	public JuegoResponse actualizarJuego(JuegoRequest juegoA) {
		Optional<Juego> juegoE = juegoRepository.findBytitle(juegoA.getTitulo());
		juegoHelper.comprobarJuego(juegoE);
		juegoHelper.cambiarJuego(juegoA, juegoE);
		juegoRepository.save(juegoE.get());
		return jTJR.convert(juegoE.get());
		}
}
