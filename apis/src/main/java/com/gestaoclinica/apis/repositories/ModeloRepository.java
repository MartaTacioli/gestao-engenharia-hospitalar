package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
	void deleteById(Long id);
	List<Modelo> findAllByMaquina_Id(Long id);
}
