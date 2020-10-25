package com.atos.ejercicios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.ejercicios.entitie.Cliente;
import com.atos.ejercicios.entitie.Recibo;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Long>{
	
	public Optional<Recibo> findByCliente(Cliente cliente);

}
