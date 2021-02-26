package com.gestaoclinica.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.TipoVeiculo;

public interface TipoVeiculoRepository extends JpaRepository<TipoVeiculo,Long>{
	void deleteById(Long id);

}
