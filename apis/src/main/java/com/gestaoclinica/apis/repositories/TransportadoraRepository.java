package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Regiao;
import com.gestaoclinica.apis.entities.Transportadora;

public interface TransportadoraRepository extends JpaRepository<Transportadora,Long>{
	
	List<Transportadora> findAllByAprovado(Integer aprovado);
	List<Transportadora> findAllByRegiaoIn(List<Regiao> regioes);
	Transportadora findByCnpj(Long cnpj);
	List<Transportadora> findAllByRegiaoInAndAprovado(List<Regiao> regioes ,int aprovado);

}
