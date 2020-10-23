package com.atos.ejercicios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.ejercicios.entitie.Juego;
import com.atos.ejercicios.entitie.Stock;
import com.atos.ejercicios.entitie.Tienda;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	
	public Optional<Stock> findByTiendaAndJuego(Tienda tienda, Juego juego);

}
