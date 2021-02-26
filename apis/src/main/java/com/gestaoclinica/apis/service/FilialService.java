package com.gestaoclinica.apis.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.Filial;
import com.gestaoclinica.apis.repositories.FilialRepository;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.ViolacaoDeChaveException;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;

@Service
public class FilialService {
	
	@Autowired
	private FilialRepository repository;
	
	public List<Filial> findAllByCnpj(Long cnpj){
		return repository.findAllByCnpj(cnpj);
	}
	
	public Filial findByNomeFilial(String nome){
		return repository.findByNomeFilial(nome);
	}
	
	
	public Filial findById(Long id) {
		Optional<Filial> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id,1));
	}
	
	public Filial insert (Filial obj) {
		try {
			repository.save(obj);
	 	} catch (DataIntegrityViolationException e){
	 		
	 		  throw new RecursoJaCadastradoException ("N�o existe esse registro.",1);			
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			throw new CamposObrigatoriosException (obj, "Caracteristica do Im�vel");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ErroNaoMapeadoException ("");
		}
		return obj;

}
	
	public Filial delete (Filial obj) {	
		try {
		 repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e){
	 		 e.printStackTrace();
			  throw new ViolacaoDeChaveException ("Esse recurso esta sendo utilizado!");
				
			} catch(EmptyResultDataAccessException e){
				 e.printStackTrace();
				  throw new RecursoJaCadastradoException ("N�o existe esse registro.",1);

			}catch (RuntimeException e) {
			
				e.printStackTrace();
				throw new ErroNaoMapeadoException ("");
			}
		return obj;
	
	}
	
}
