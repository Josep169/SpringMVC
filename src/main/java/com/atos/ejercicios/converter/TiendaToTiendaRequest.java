package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.dto.request.TiendaRequest;
import com.atos.ejercicios.entitie.Tienda;

public class TiendaToTiendaRequest implements Converter<Tienda, TiendaRequest>{

	@Override
	public TiendaRequest convert(Tienda source) {
		TiendaRequest tienda = new TiendaRequest();
		tienda.setTitulo(source.getTitle());
		tienda.setCalle(source.getDireccion());
		tienda.setNumero(source.getNumero());
		return tienda;
	}

}
