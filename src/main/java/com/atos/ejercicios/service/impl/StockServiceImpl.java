package com.atos.ejercicios.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.ejercicios.converter.StockRequestToStock;
import com.atos.ejercicios.converter.StockToStockRequest;
import com.atos.ejercicios.dto.request.StockRequest;
import com.atos.ejercicios.entitie.Juego;
import com.atos.ejercicios.entitie.Stock;
import com.atos.ejercicios.entitie.Tienda;
import com.atos.ejercicios.helper.StockHelper;
import com.atos.ejercicios.repository.StockRepository;
import com.atos.ejercicios.service.JuegoService;
import com.atos.ejercicios.service.StockService;
import com.atos.ejercicios.service.TiendaService;

@Service
public class StockServiceImpl implements StockService{
	
	StockToStockRequest STSR = new StockToStockRequest();
	StockRequestToStock sRTS = new StockRequestToStock();
	
	@Autowired
	TiendaService tiendaService;
	
	@Autowired
	JuegoService juegoService;
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	StockHelper stockHelper;
	
	@Override
	public StockRequest verStock(String tituloT, String tituloJ) {
		Optional<Juego> juegoO = juegoService.obtenerJuego(tituloJ);
		Juego juego = stockHelper.comprobarJuego(juegoO).get();
		Optional<Tienda> tiendaO = tiendaService.obtenerTienda(tituloT);
		Tienda tienda = stockHelper.comprobarTienda(tiendaO).get();
		Optional<Stock> stockO = stockRepository.findByTiendaAndJuego(tienda, juego);
		Stock stock = stockHelper.comprobarStock(stockO).get();
		return STSR.convert(stock);
	}

	@Override
	public StockRequest agregarStock(StockRequest stockRequest) {
		Optional<Juego> juegoO = juegoService.obtenerJuego(stockRequest.getNombreJ());
		Juego juego = stockHelper.comprobarJuego(juegoO).get();
		Optional<Tienda> tiendaO = tiendaService.obtenerTienda(stockRequest.getNombreT());
		Tienda tienda = stockHelper.comprobarTienda(tiendaO).get();
		Optional<Stock> stockO = stockRepository.findByTiendaAndJuego(tienda, juego);
		stockHelper.existeStock(stockO);
		Stock stock = sRTS.convert(stockRequest);
		stock.setJuego(juego);
		stock.setTienda(tienda);
		stockRepository.save(stock);
		return STSR.convert(stock);
	}

	@Override
	public Optional<Stock> obtenerStock(Tienda tienda, Juego juego) {
		return 	stockRepository.findByTiendaAndJuego(tienda, juego);
	}
	
	

}
