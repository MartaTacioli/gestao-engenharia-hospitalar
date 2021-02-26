package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.TaxaValorKm;

public interface TaxaValorKmRepository extends JpaRepository<TaxaValorKm, Long> {
	List<TaxaValorKm> findAllByCnpj(Long cnpj);
	TaxaValorKm findByCnpj(Long cnpj);

}
