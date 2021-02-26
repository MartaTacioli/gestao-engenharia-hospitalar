package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Maquina;
import com.gestaoclinica.apis.entities.TaxaCepEscala;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
	void deleteById(Long id);
}
