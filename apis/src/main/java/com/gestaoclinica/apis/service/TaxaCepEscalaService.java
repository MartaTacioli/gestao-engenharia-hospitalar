package com.gestaoclinica.apis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.TaxaCepEscala;
import com.gestaoclinica.apis.repositories.TaxaCepEscalaRepository;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;

@Service
public class TaxaCepEscalaService {
	
	
	@Autowired
	private TaxaCepEscalaRepository repository;
	

	
	public List<TaxaCepEscala> findAll(){
		return repository.findAll();

	}
	public List<TaxaCepEscala> findAllByCnpj(Long cnpj){
		return repository.findAllByCnpj(cnpj);

	}
	
	

	public TaxaCepEscala insert (TaxaCepEscala obj) {	
		try {
		 repository.save(obj);
		} catch (DataIntegrityViolationException e){
	 		
			  throw new RecursoJaCadastradoException ("Ja cadastrado",1);
				
			} catch (RuntimeException e) {
				e.printStackTrace();
				throw new ErroNaoMapeadoException ("");
			}
		return obj;
	
	}
	

	

	public TaxaCepEscala delete (TaxaCepEscala obj) {	

	
		try {
		 repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e){
	 		
			  throw new RecursoJaCadastradoException ("Ja deletado",1);
				
			} catch(EmptyResultDataAccessException e){
				
				  throw new RecursoJaCadastradoException ("Não existe esse registro.",1);

			}catch (RuntimeException e) {
			
				e.printStackTrace();
				throw new ErroNaoMapeadoException ("");
			}
		return obj;
	
	}

	 
}

	
	
//	new BCryptPasswordEncoder().encode


