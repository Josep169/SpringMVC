package com.atos.ejercicios.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atos.ejercicios.converter.GeneroEnumToGenero;
import com.atos.ejercicios.converter.GeneroToGeneroDto;
import com.atos.ejercicios.converter.JuegoRequestToJuego;
import com.atos.ejercicios.converter.JuegoToJuegoResponseCmpl;
import com.atos.ejercicios.dto.request.JuegoRequest;
import com.atos.ejercicios.dto.response.GeneroDto;
import com.atos.ejercicios.dto.response.JuegoResponseCompl;
import com.atos.ejercicios.entitie.Gender;
import com.atos.ejercicios.entitie.Juego;
import com.atos.ejercicios.exceptions.generic.JuegoKOException;

@Service
public class JuegoHelper {

	JuegoRequestToJuego jRTJ = new JuegoRequestToJuego();
	JuegoToJuegoResponseCmpl jTJRC = new JuegoToJuegoResponseCmpl();
	GeneroEnumToGenero gETG = new GeneroEnumToGenero();
	GeneroToGeneroDto gTGD = new GeneroToGeneroDto();
	
	public Optional<Juego> comprobarJuego(Optional<Juego> juego) {
	if(juego.isPresent()) {
	    return juego;
	} else {
		throw new JuegoKOException("Juego no encontrado");
	}
	}
	
	public JuegoResponseCompl convertirJuegoAJuegoResponseCompl(Optional<Juego> juego) {
		JuegoResponseCompl juegoResponse = jTJRC.convert(juego.get());
	    List<GeneroDto> generos = new ArrayList<GeneroDto>();
	    juego.get().getGeneros().forEach(genero -> {
	    	GeneroDto generoI = gTGD.convert(genero);
	    	generos.add(generoI);
	    });
	    juegoResponse.setGenre(generos);
	    return juegoResponse;
	}
	
	public void existeJuego(Optional<Juego> juego) {
		if(juego.isPresent()) {
			throw new JuegoKOException("Este juego ya existe.");
	}
	}
	public Juego convertirJuegoRequestAJuego(JuegoRequest juegoRequest) {
		List<Juego> juegoI = new ArrayList<Juego>();
		Juego juego = jRTJ.convert(juegoRequest);
		List<Gender> genders = new ArrayList<Gender>();
		juegoRequest.getGenre().forEach(generoEnum -> {
			Gender genero = gETG.convert(generoEnum);
			juegoI.add(juego);
			genero.setJuegos(juegoI);
			genders.add(genero);
		});
		juego.setGeneros(genders);
		return juego;
	}
	
	public Juego cambiarJuego(JuegoRequest juegoA, Optional<Juego> juegoE) {
		juegoE.get().setDescription(juegoA.getDescripcion());
		juegoE.get().setRelease(juegoA.getFecha());
		List<Gender> genders = new ArrayList<Gender>();
		juegoA.getGenre().forEach(generoEnum -> {
			Gender genero = gETG.convert(generoEnum);
			genders.add(genero);
		});
		juegoE.get().setGeneros(genders);
		return juegoE.get();
	}
	
	
}
