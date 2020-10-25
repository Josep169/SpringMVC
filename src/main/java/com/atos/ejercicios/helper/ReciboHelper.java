package com.atos.ejercicios.helper;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atos.ejercicios.entitie.Cliente;
import com.atos.ejercicios.entitie.Juego;
import com.atos.ejercicios.entitie.Recibo;
import com.atos.ejercicios.entitie.Stock;
import com.atos.ejercicios.entitie.Tienda;
import com.atos.ejercicios.exceptions.generic.JuegoKOException;
import com.atos.ejercicios.exceptions.generic.StockKOException;
import com.atos.ejercicios.exceptions.generic.TiendaKOException;

@Service
public class ReciboHelper {

	public Optional<Cliente> comprobarCliente(Optional<Cliente> cliente) {
	if(cliente.isPresent()) {
	    return cliente;
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
	
	public Optional<Juego> comprobarJuego(Optional<Juego> juego) {
	if(juego.isPresent()) {
	    return juego;
	} else {
		throw new JuegoKOException("Juego no encontrado");
	}
	}
	
	public Optional<Stock> comprobarStock(Optional<Stock> stock) {
	if(stock.isPresent()) {
	    return stock;
	} else {
		throw new StockKOException("Stock no encontrado");
	}
	}
	
	public Optional<Recibo> comprobarRecibo(Optional<Recibo> recibo) {
	if(recibo.isPresent()) {
	    return recibo;
	} else {
		throw new StockKOException("Recibo no encontrado");
	}
	}
	
	public void existeRecibo(Optional<Recibo> recibo) {
		if(recibo.isPresent()) {
			throw new StockKOException("Este stock ya existe.");
		}
	}
}
