package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista,Long>{
	/*
	List<AnunciosFiltrados> findAllProjectedByBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThanAndRegiaoIn(Integer banheiros, Integer dormitorios, Integer vagas, Double areaPrivada, Double valorImovel, List<Regiao> regiao);
	List<AnunciosFiltrados> findAllProjectedByBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThan(Integer banheiros, Integer dormitorios, Integer vagas, Double areaPrivada, Double valorImovel);
	List<AnunciosFiltrados> findAllProjectedByBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThanAndRegiaoCidade(Integer banheiros, Integer dormitorios, Integer vagas, Double areaPrivada, Double valorImovel, String cidade);

	List<AnunciosFiltrados> findAllProjectedByTipoImovelAndBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThanAndRegiaoIn(TipoImovel tipoImovel, Integer banheiros, Integer dormitorios, Integer vagas, Double areaPrivada, Double valorImovel, List<Regiao> regiao);
	List<AnunciosFiltrados> findAllProjectedByTipoImovelAndBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThan(TipoImovel tipoImovel,Integer banheiros, Integer dormitorios, Integer vagas, Double areaPrivada, Double valorImovel);
	List<AnunciosFiltrados> findAllProjectedByTipoImovelAndBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThanAndRegiaoCidade(TipoImovel tipoImovel,Integer banheiros, Integer dormitorios, Integer vagas, Double areaPrivada, Double valorImovel, String cidade);

	AnuncioResumoCard findProjectedById(Long id);
 
	*/
	List<Motorista> findAllByAprovado(Integer aprovado);
	List<Motorista> findAllByTransportadoraCnpj(Long cnpj);
	Motorista findByCpf(Long cpf);

}
