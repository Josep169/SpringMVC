package com.atos.ejercicios.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.ejercicios.converter.ClienteRequestToCliente;
import com.atos.ejercicios.converter.ClienteRequestToClienteResponse;
import com.atos.ejercicios.converter.ClienteToClienteResponse;
import com.atos.ejercicios.dto.request.ClienteRequest;
import com.atos.ejercicios.dto.response.ClienteResponse;
import com.atos.ejercicios.entitie.Cliente;
import com.atos.ejercicios.helper.ClienteHelper;
import com.atos.ejercicios.repository.ClienteRepository;
import com.atos.ejercicios.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	ClienteRequestToClienteResponse cRTCR = new ClienteRequestToClienteResponse();
	ClienteRequestToCliente cRTC = new ClienteRequestToCliente();
	ClienteToClienteResponse cTCR = new ClienteToClienteResponse();

	@Autowired
	ClienteHelper clienteHelper;
	
	@Override
	public ClienteResponse agregarCliente(ClienteRequest clienteRequest) {
		Optional<Cliente> clienteE = clienteRepository.findBydni(clienteRequest.getDni());
		clienteHelper.existeCliente(clienteE);
		Cliente cliente = cRTC.convert(clienteRequest);
		clienteRepository.save(cliente);
		ClienteResponse clienteResponse = cRTCR.convert(clienteRequest);
		return clienteResponse;
	}
	
	@Override
	public ClienteResponse verCliente(String dni) {
		Optional<Cliente> cliente = clienteRepository.findBydni(dni);
		clienteHelper.comprobarCliente(cliente);
		ClienteResponse clienteResponse= cTCR.convert(cliente.get());
		return clienteResponse;
	}

	@Override
	public Optional<Cliente> obtenerCliente(String dni) {
		return clienteRepository.findBydni(dni);
	}
}