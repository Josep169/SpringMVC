package com.atos.ejercicios.service;

import com.atos.ejercicios.dto.request.StockRequest;

public interface StockService {
	
	public StockRequest agregarStock(StockRequest stockRequest);
	
	public StockRequest verStock(String tituloT, String tituloJ);
}
