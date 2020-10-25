package com.atos.ejercicios.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.ejercicios.converter.ReciboToReciboResponse;
import com.atos.ejercicios.dto.request.ReciboRequest;
import com.atos.ejercicios.dto.response.ReciboResponse;
import com.atos.ejercicios.entitie.Cliente;
import com.atos.ejercicios.entitie.Juego;
import com.atos.ejercicios.entitie.Recibo;
import com.atos.ejercicios.entitie.Stock;
import com.atos.ejercicios.entitie.Tienda;
import com.atos.ejercicios.helper.ReciboHelper;
import com.atos.ejercicios.repository.ReciboRepository;
import com.atos.ejercicios.service.ClienteService;
import com.atos.ejercicios.service.JuegoService;
import com.atos.ejercicios.service.ReciboService;
import com.atos.ejercicios.service.StockService;
import com.atos.ejercicios.service.TiendaService;

@Service
public class ReciboServiceImpl implements ReciboService{

	ReciboToReciboResponse rTRR = new ReciboToReciboResponse();
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	TiendaService tiendaService;
	
	@Autowired
	JuegoService juegoService;
	
	@Autowired
	StockService stockService;
	
	@Autowired
	ReciboRepository reciboRepository;
	
	@Autowired
	ReciboHelper reciboHelper;
	
	@Override
	public ReciboResponse verRecibo(String dni) {
		Optional<Cliente> clienteO = clienteService.obtenerCliente(dni);
		Cliente cliente = reciboHelper.comprobarCliente(clienteO).get();
		Optional<Recibo> reciboO = reciboRepository.findByCliente(cliente);
		Recibo recibo = reciboHelper.comprobarRecibo(reciboO).get();
		return rTRR.convert(recibo);
		
	}

	@Override
	public ReciboResponse agregarRecibo(ReciboRequest reciboRequest) {
		Optional<Juego> juegoO = juegoService.obtenerJuego(reciboRequest.getNombreJ());
		Juego juego = reciboHelper.comprobarJuego(juegoO).get();
		Optional<Tienda> tiendaO = tiendaService.obtenerTienda(reciboRequest.getNombreT());
		Tienda tienda = reciboHelper.comprobarTienda(tiendaO).get();
		Optional<Stock> stockO = stockService.obtenerStock(tienda, juego);
		reciboHelper.comprobarStock(stockO).get();
		Optional<Cliente> clienteO = clienteService.obtenerCliente(reciboRequest.getDni());
		Cliente cliente = reciboHelper.comprobarCliente(clienteO).get();
		Optional<Recibo> reciboO = reciboRepository.findByCliente(cliente);
		reciboHelper.existeRecibo(reciboO);
		Recibo recibo = new Recibo();
		recibo.setCliente(cliente);
		reciboRepository.save(recibo);
		ReciboResponse reciboResponse = rTRR.convert(recibo);
		reciboResponse.setNomberJ(juego.getTitle());
		reciboResponse.setNombreT(tienda.getTitle());
		return reciboResponse;
	}
	
	

}