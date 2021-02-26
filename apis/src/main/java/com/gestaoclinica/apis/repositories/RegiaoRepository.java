package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Regiao;
import com.gestaoclinica.apis.entities.Transportadora;

public interface RegiaoRepository extends JpaRepository<Regiao, Long> {
	List<Regiao> findAllByEstado(String estado);
	void deleteById(Long id);

	List<Regiao> findAllByEstadoAndCidade(String estado, String cidade);
}
