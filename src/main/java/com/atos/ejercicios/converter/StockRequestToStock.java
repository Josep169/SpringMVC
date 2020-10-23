package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.dto.request.StockRequest;
import com.atos.ejercicios.entitie.Stock;

public class StockRequestToStock implements Converter<StockRequest, Stock>{

	@Override
	public Stock convert(StockRequest source) {
		Stock stock = new Stock();
		stock.setCantidad(source.getStock());
		return stock;
	}

}
