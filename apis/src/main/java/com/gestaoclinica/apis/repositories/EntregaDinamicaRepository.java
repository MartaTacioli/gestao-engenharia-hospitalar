package com.gestaoclinica.apis.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.EntregaDinamica;
import com.gestaoclinica.apis.entities.EntregaDinamicaLista;

public interface EntregaDinamicaRepository extends JpaRepository<EntregaDinamica, Long> {
	void deleteById(Long id);
	List<EntregaDinamica> findAllByCnpjTransportadora(Long cnpj);
}
