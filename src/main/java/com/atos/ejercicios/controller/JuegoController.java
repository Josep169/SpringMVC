package com.atos.ejercicios.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atos.ejercicios.dto.request.JuegoRequest;
import com.atos.ejercicios.dto.response.JuegoResponse;
import com.atos.ejercicios.service.JuegoService;

@RestController
public class JuegoController {
	
	@Autowired
	JuegoService juegoService;

	@GetMapping("/juego")
	public ResponseEntity<Object> verJuego(@RequestParam("titulo") String titulo, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(juegoService.verJuego(titulo));
	}
	
	@PostMapping("/juego")
	public ResponseEntity<Object> agregarJuego(@RequestBody @Valid JuegoRequest juegoRequest, HttpServletRequest request){
		JuegoResponse juegoResponse = juegoService.agregarJuego(juegoRequest);
		return ResponseEntity.status(HttpStatus.OK).body(juegoResponse);
	}
	
	@DeleteMapping("/juegob")
	public ResponseEntity<Object> borrarJuego(@RequestParam("titulo") String titulo, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(juegoService.borrarJuego(titulo));
	}
	@PutMapping("/juegoa")
	public ResponseEntity<Object> actualizarJuego(@RequestBody @Valid JuegoRequest juegoA, HttpServletRequest request){
		JuegoResponse juegoResponse = juegoService.actualizarJuego(juegoA);
		return ResponseEntity.status(HttpStatus.OK).body(juegoResponse);
	}
}
