package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.AprovacaoMotorista;

public interface AprovacaoMotoristaRepository extends JpaRepository<AprovacaoMotorista,Long>{
	/*
	List<AnunciosFiltrados> findAllProjectedByBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThanAndRegiaoIn(Integer banheiros, Integer dormitorios, Integer vagas, Double areaPrivada, Double valorImovel, List<Regiao> regiao);
	List<AnunciosFiltrados> findAllProjectedByBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThan(Integer banheiros, Integer dormitorios, Integer vagas, Double areaPrivada, Double valorImovel);
	List<AnunciosFiltrados> findAllProjectedByBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThanAndRegiaoCidade(Integer banheiros, Integer dormitorios, Integer vagas, Double areaPrivada, Double valorImovel, String cidade);

	List<AnunciosFiltrados> findAllProjectedByTipoImovelAndBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThanAndRegiaoIn(TipoImovel tipoImovel, Integer banheiros, Integer dormitorios, Integer vagas, Double areaPrivada, Double valorImovel, List<Regiao> regiao);
	List<AnunciosFiltrados> findAllProjectedByTipoImovelAndBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThan(TipoImovel tipoImovel,Integer banheiros, Integer dormitorios, Integer vagas, Double areaPrivada, Double valorImovel);
	List<AnunciosFiltrados> findAllProjectedByTipoImovelAndBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThanAndRegiaoCidade(TipoImovel tipoImovel,Integer banheiros, Integer dormitorios, Integer vagas, Double areaPrivada, Double valorImovel, String cidade);

	AnuncioResumoCard findProjectedById(Long id);
 
	*/
	List<AprovacaoMotorista> findAllByCnpjTransportadora(Long cnpj);
	List<AprovacaoMotorista> findAllByCpfMotorista(Long cpf);
	AprovacaoMotorista findByCnpjTransportadoraAndCpfMotorista(Long cnpj,Long cpf);
	List<AprovacaoMotorista> findAllByCpfMotoristaAndAprovado(Long cpf, int aprovado);



}
