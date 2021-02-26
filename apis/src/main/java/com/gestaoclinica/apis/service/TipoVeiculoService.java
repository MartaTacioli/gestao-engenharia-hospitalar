package com.gestaoclinica.apis.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.TipoVeiculo;
import com.gestaoclinica.apis.repositories.TipoVeiculoRepository;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.ViolacaoDeChaveException;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;

@Service
public class TipoVeiculoService {
	
	@Autowired
	private TipoVeiculoRepository repository;
	
	public List<TipoVeiculo> findAll(){
		return repository.findAll();
	}
	
	public TipoVeiculo findById(Long id) {
		Optional<TipoVeiculo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id,1));
	}
	
	public TipoVeiculo insert (TipoVeiculo obj) {
		try {
		repository.save(obj);
		
		} catch (DataIntegrityViolationException e){
		  throw new RecursoJaCadastradoException (obj.getTipoVeiculo(),1);
		
		} catch (ConstraintViolationException e) {
			throw new CamposObrigatoriosException (obj, "Tipo de Veículo");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ErroNaoMapeadoException ("");
		}
		
		return obj;
	}
	

	public TipoVeiculo delete (TipoVeiculo obj) {	
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
