package com.atos.ejercicios.service;

import com.atos.ejercicios.dto.request.ReciboRequest;
import com.atos.ejercicios.dto.response.ReciboResponse;

public interface ReciboService {
	
	public ReciboResponse agregarRecibo(ReciboRequest reciboRequest);
	
	public ReciboResponse verRecibo(String dni);
}
