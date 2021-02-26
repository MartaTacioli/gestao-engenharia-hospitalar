package com.gestaoclinica.apis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.EntregaDinamica;
import com.gestaoclinica.apis.entities.EntregaDinamicaLista;
import com.gestaoclinica.apis.entities.Notas;
import com.gestaoclinica.apis.repositories.EntregaDinamicaRepository;
import com.gestaoclinica.apis.repositories.NotasRepository;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.ViolacaoDeChaveException;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;

@Service
public class EntregaDinamicaService {

	@Autowired
	private EntregaDinamicaRepository repository;

	@Autowired
	private NotasRepository notasRepository;
	
	public List<EntregaDinamica> findAllByCnpjTransportadora(Long cnpj) {
		return repository.findAllByCnpjTransportadora(cnpj);
		
	}

	public EntregaDinamica findById(Long id) {
		Optional<EntregaDinamica> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id,1));
	}
	
	public EntregaDinamica insert (EntregaDinamica obj) {
		try {
			for (Notas objAtual : obj.getNotas()) {
				notasRepository.save(objAtual);
				
				}

			repository.save(obj);
	 	} catch (DataIntegrityViolationException e){
	 		
		  throw new RecursoJaCadastradoException ("Ja cadastrado",1);
			
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			throw new CamposObrigatoriosException (obj, "Caracteristica do Im�vel");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ErroNaoMapeadoException ("");
		}
		return obj;

}

	public EntregaDinamica delete(EntregaDinamica obj) {
		try {
			repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new ViolacaoDeChaveException("Esse recurso esta sendo utilizado!");

		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			throw new RecursoJaCadastradoException("N�o existe esse registro.",1);

		} catch (RuntimeException e) {

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}
		return obj;

	}



}
