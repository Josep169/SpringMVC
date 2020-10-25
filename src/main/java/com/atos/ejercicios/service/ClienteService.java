package com.atos.ejercicios.service;

import java.util.Optional;

import com.atos.ejercicios.dto.request.ClienteRequest;
import com.atos.ejercicios.dto.response.ClienteResponse;
import com.atos.ejercicios.entitie.Cliente;


public interface ClienteService {

	public ClienteResponse agregarCliente(ClienteRequest clienteDto);
	
	public ClienteResponse verCliente(String title);
	
	public Optional<Cliente> obtenerCliente(String dni);
	
}
