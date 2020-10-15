package com.atos.ejercicios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.ejercicios.entitie.Juego;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long>{

	public Optional<Juego> findBytitle(String titulo);
}
