package com.atos.ejercicios.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atos.ejercicios.dto.request.TiendaRequest;
import com.atos.ejercicios.dto.response.TiendaResponse;
import com.atos.ejercicios.service.TiendaService;

@RestController
public class TiendaController {
	
	@Autowired
	TiendaService tiendaService;
	
	@GetMapping("/tienda")
	public ResponseEntity<Object> verTienda(@RequestParam("titulo") String titulo, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(tiendaService.verTienda(titulo));
	}

	@PostMapping("/tienda")
	public ResponseEntity<Object> agregarTienda(@RequestBody @Valid TiendaRequest tiendaRequest, HttpServletRequest request){
		TiendaResponse tiendaResponse = tiendaService.agregarTienda(tiendaRequest);
		return ResponseEntity.status(HttpStatus.OK).body(tiendaResponse);
	}
	
}
