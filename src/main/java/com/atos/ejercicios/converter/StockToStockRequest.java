package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.dto.request.StockRequest;
import com.atos.ejercicios.entitie.Stock;

public class StockToStockRequest implements Converter<Stock, StockRequest>{

	@Override
	public StockRequest convert(Stock source) {
		StockRequest stockRequest = new StockRequest();
		stockRequest.setNombreJ(source.getJuego().getTitle());
		stockRequest.setNombreT(source.getTienda().getTitle());
		stockRequest.setStock(source.getCantidad());
		return stockRequest;
	}

}
