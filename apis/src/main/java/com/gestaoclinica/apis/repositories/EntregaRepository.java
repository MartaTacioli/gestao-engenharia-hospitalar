package com.gestaoclinica.apis.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
	void deleteById(Long id);

}
