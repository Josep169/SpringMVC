package com.atos.ejercicios.helper;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atos.ejercicios.entitie.Juego;
import com.atos.ejercicios.entitie.Stock;
import com.atos.ejercicios.entitie.Tienda;
import com.atos.ejercicios.exceptions.generic.JuegoKOException;
import com.atos.ejercicios.exceptions.generic.StockKOException;
import com.atos.ejercicios.exceptions.generic.TiendaKOException;

@Service
public class StockHelper {

	public Optional<Juego> comprobarJuego(Optional<Juego> juego) {
	if(juego.isPresent()) {
	    return juego;
	} else {
		throw new JuegoKOException("Juego no encontrado");
	}
	}
	
	public Optional<Tienda> comprobarTienda(Optional<Tienda> tienda) {
	if(tienda.isPresent()) {
	    return tienda;
	} else {
		throw new TiendaKOException("Tienda no encontrada");
	}
	}
	public Optional<Stock> comprobarStock(Optional<Stock> stock) {
	if(stock.isPresent()) {
	    return stock;
	} else {
		throw new StockKOException("Stock no encontrado");
	}
	}
	public void existeStock(Optional<Stock> stock) {
		if(stock.isPresent()) {
			throw new StockKOException("Este stock ya existe.");
		}
	}
}
