package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.TaxaPesoEscala;

public interface TaxaPesoEscalaRepository extends JpaRepository<TaxaPesoEscala, Long> {
	List<TaxaPesoEscala> findAllByCnpj(Long cnpj);
	void deleteById(Long id);

}
