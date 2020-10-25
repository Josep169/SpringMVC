package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.dto.response.ReciboResponse;
import com.atos.ejercicios.entitie.Recibo;

public class ReciboToReciboResponse implements Converter<Recibo, ReciboResponse>{

	@Override
	public ReciboResponse convert(Recibo recibo) {
		ReciboResponse reciboResponse = new ReciboResponse();
		reciboResponse.setNombreC(recibo.getCliente().getNombre() + " " + recibo.getCliente().getApellidos());
		return reciboResponse;
	}

}
