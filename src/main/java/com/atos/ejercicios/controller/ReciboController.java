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

import com.atos.ejercicios.dto.request.ReciboRequest;
import com.atos.ejercicios.dto.response.ReciboResponse;
import com.atos.ejercicios.service.ReciboService;

@RestController
public class ReciboController {
	
	@Autowired
	ReciboService reciboService;

	@GetMapping("/recibo")
	public ResponseEntity<Object> verRecibo(@RequestParam("dni") String dni, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(reciboService.verRecibo(dni));
	}
	
	@PostMapping("/recibo")
	public ResponseEntity<Object> agregarJuego(@RequestBody @Valid ReciboRequest reciboRequest, HttpServletRequest request){
		ReciboResponse reciboResponse = reciboService.agregarRecibo(reciboRequest);
		return ResponseEntity.status(HttpStatus.OK).body(reciboResponse);
	}
}