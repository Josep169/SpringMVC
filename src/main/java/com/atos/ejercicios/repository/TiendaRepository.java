package com.atos.ejercicios.repository;

import org.springframework.stereotype.Repository;
import com.atos.ejercicios.entitie.Tienda;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Long>{

	public Optional<Tienda> findBytitle(String titulo);
}
