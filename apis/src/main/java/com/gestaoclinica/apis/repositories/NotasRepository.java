package com.gestaoclinica.apis.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Notas;

public interface NotasRepository extends JpaRepository<Notas, Long> {
	void deleteById(Long id);

}
