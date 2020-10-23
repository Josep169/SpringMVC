package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.dto.request.TiendaRequest;
import com.atos.ejercicios.entitie.Tienda;

public class TiendaRequestToTienda implements Converter<TiendaRequest, Tienda>{

	@Override
	public Tienda convert(TiendaRequest source) {
		Tienda tienda = new Tienda();
		tienda.setTitle(source.getTitulo());
		tienda.setDireccion(source.getCalle());
		tienda.setNumero(source.getNumero());
		return tienda;
	}

}
