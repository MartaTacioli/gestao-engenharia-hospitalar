package com.gestaoclinica.apis.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.Regiao;
import com.gestaoclinica.apis.entities.TipoVeiculo;
import com.gestaoclinica.apis.entities.Transportadora;
import com.gestaoclinica.apis.repositories.RegiaoRepository;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.ViolacaoDeChaveException;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;

@Service
public class RegiaoService {
	
	@Autowired
	private RegiaoRepository repository;
	
	public List<Regiao> findAll(){
		return repository.findAll();
	}
	public List<Regiao> findAllByEstado(String estado){
		return repository.findAllByEstado(estado);
	}

	public List<Regiao> findAllByEstadoAndCidade(String estado,String cidade){
		return repository.findAllByEstadoAndCidade(estado,cidade);
	}
	
	public Regiao findById(Long id) {
		Optional<Regiao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id,1));
	}
	
	public Regiao insert (Regiao obj) {
		try {
			repository.save(obj);
	 	} catch (DataIntegrityViolationException e){
	 		
		  throw new RecursoJaCadastradoException ("Ja cadastrado",1);
			
		} catch (ConstraintViolationException e) {
			throw new CamposObrigatoriosException (obj, "Caracteristica do Imóvel");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ErroNaoMapeadoException ("");
		}
		return obj;

}
	
	public Regiao delete (Regiao obj) {	
		try {
		 repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e){
	 		 e.printStackTrace();
			  throw new ViolacaoDeChaveException ("Esse recurso esta sendo utilizado!");
				
			} catch(EmptyResultDataAccessException e){
				 e.printStackTrace();
				  throw new RecursoJaCadastradoException ("Não existe esse registro.",1);

			}catch (RuntimeException e) {
			
				e.printStackTrace();
				throw new ErroNaoMapeadoException ("");
			}
		return obj;
	
	}
	
}
