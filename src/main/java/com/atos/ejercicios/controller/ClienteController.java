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

import com.atos.ejercicios.dto.request.ClienteRequest;
import com.atos.ejercicios.dto.response.ClienteResponse;
import com.atos.ejercicios.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;

	@GetMapping("/cliente")
	public ResponseEntity<Object> verCliente(@RequestParam("dni") String dni, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.verCliente(dni));
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<Object> agregarJuego(@RequestBody @Valid ClienteRequest clienteRequest, HttpServletRequest request){
		ClienteResponse clienteResponse = clienteService.agregarCliente(clienteRequest);
		return ResponseEntity.status(HttpStatus.OK).body(clienteResponse);
	}
}
