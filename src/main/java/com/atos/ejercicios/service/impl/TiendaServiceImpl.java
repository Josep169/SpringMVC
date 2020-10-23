package com.atos.ejercicios.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.ejercicios.converter.TiendaRequestToTienda;
import com.atos.ejercicios.converter.TiendaToTiendaRequest;
import com.atos.ejercicios.dto.request.TiendaRequest;
import com.atos.ejercicios.dto.response.TiendaResponse;
import com.atos.ejercicios.entitie.Tienda;
import com.atos.ejercicios.helper.TiendaHelper;
import com.atos.ejercicios.repository.TiendaRepository;
import com.atos.ejercicios.service.TiendaService;

@Service
public class TiendaServiceImpl implements TiendaService {
	
	@Autowired
	TiendaRepository tiendaRepository;
	
	@Autowired
	TiendaHelper tiendaHelper;
	
	TiendaRequestToTienda tRTT = new TiendaRequestToTienda();
	TiendaToTiendaRequest tTTR = new TiendaToTiendaRequest();

	@Override
	public TiendaResponse agregarTienda(TiendaRequest tiendaRequest) {
		Optional<Tienda> tienda = tiendaRepository.findBytitle(tiendaRequest.getTitulo());
		tiendaHelper.existeTienda(tienda);
		Tienda tiendaF = tRTT.convert(tiendaRequest);
		tiendaRepository.save(tiendaF);
		return new TiendaResponse(tiendaF.getTitle());
	}

	@Override
	public TiendaRequest verTienda(String titulo) {
		Optional<Tienda> tienda = tiendaRepository.findBytitle(titulo);
		Optional<Tienda> tiendaE = tiendaHelper.comprobarTienda(tienda);
		return tTTR.convert(tiendaE.get());
	}

	@Override
	public Optional<Tienda> obtenerTienda(String titulo) {
		return tiendaRepository.findBytitle(titulo);
	}

}
