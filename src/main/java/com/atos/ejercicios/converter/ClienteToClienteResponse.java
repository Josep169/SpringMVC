package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.dto.response.ClienteResponse;
import com.atos.ejercicios.entitie.Cliente;


public class ClienteToClienteResponse implements Converter<Cliente, ClienteResponse>{

	@Override
	public ClienteResponse convert(Cliente cliente) {
		ClienteResponse clienteResponse = new ClienteResponse();
		clienteResponse.setNomAp(cliente.getNombre() + " " + cliente.getApellidos());
		clienteResponse.setPuntos(cliente.getPuntos());
		return clienteResponse;
	}

}
