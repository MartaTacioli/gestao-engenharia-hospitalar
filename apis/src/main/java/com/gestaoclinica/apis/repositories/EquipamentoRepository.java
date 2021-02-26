package com.gestaoclinica.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
	void deleteById(Long id);
	
}
