package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.dto.request.ClienteRequest;
import com.atos.ejercicios.entitie.Cliente;

public class ClienteRequestToCliente implements Converter<ClienteRequest, Cliente>{

	@Override
	public Cliente convert(ClienteRequest clienteRequest) {
		Cliente cliente = new Cliente();
		cliente.setNombre(clienteRequest.getNombre());
		cliente.setApellidos(clienteRequest.getApellidos());
		cliente.setDni(clienteRequest.getDni());
		cliente.setPuntos(clienteRequest.getPuntos());
		return cliente;
	}

}
