package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.TaxaCepEscala;

public interface TaxaCepEscalaRepository extends JpaRepository<TaxaCepEscala, Long> {
	List<TaxaCepEscala> findAllByCnpj(Long cnpj);
	void deleteById(Long id);
}
