package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.dto.request.ClienteRequest;
import com.atos.ejercicios.dto.response.ClienteResponse;

public class ClienteRequestToClienteResponse implements Converter<ClienteRequest, ClienteResponse>{

	@Override
	public ClienteResponse convert(ClienteRequest clienteRequest) {
		ClienteResponse clienteResponse = new ClienteResponse();
		clienteResponse.setNomAp(clienteRequest.getNombre() + " " + clienteRequest.getApellidos());
		clienteResponse.setPuntos(clienteRequest.getPuntos());
		return clienteResponse;
	}

}