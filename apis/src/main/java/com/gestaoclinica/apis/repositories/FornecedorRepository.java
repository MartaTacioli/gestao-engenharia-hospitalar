package com.gestaoclinica.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
	void deleteById(Long id);
}
