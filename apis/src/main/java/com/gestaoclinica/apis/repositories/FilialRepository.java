package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Filial;

public interface FilialRepository extends JpaRepository<Filial, Long> {
	void deleteById(Long id);
	List<Filial> findAllByCnpj(Long cnpj);
	Filial findByNomeFilial(String nomeFilial);
}
