package com.atos.ejercicios.service;

import java.util.Optional;

import com.atos.ejercicios.dto.request.StockRequest;
import com.atos.ejercicios.entitie.Juego;
import com.atos.ejercicios.entitie.Stock;
import com.atos.ejercicios.entitie.Tienda;

public interface StockService {
	
	public StockRequest agregarStock(StockRequest stockRequest);
	
	public StockRequest verStock(String tituloT, String tituloJ);
	
	public Optional<Stock> obtenerStock(Tienda tienda, Juego juego);
}
