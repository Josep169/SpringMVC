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

import com.atos.ejercicios.dto.request.StockRequest;
import com.atos.ejercicios.service.StockService;

@RestController
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@GetMapping("/stock")
	public ResponseEntity<Object> verStock(@RequestParam("tituloT") String tituloT ,@RequestParam("tituloJ") String tituloJ, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(stockService.verStock(tituloT, tituloJ));
	}

	@PostMapping("/stock")
	public ResponseEntity<Object> agregarTienda(@RequestBody @Valid StockRequest stockRequest, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(stockService.agregarStock(stockRequest));
	}
	
}