package com.gestaoclinica.apis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.gestaoclinica.apis.entities.Proprietario;
import com.gestaoclinica.apis.repositories.ProprietarioRepository;
import com.gestaoclinica.apis.service.exceptions.ReferenciaExternaException;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;

@Service
public class ProprietarioService {
	/*
	@Autowired
	private ProprietarioRepository repository;
	
	
	public List<Proprietario> findAll(){
		return repository.findAll();
	}
	
	public Proprietario findById(Long cpf) {
		Optional<Proprietario> obj = repository.findById(cpf);

		return obj.orElseThrow(() -> new ResourceNotFoundException(cpf));
	}
 	
	public Proprietario insert (Proprietario obj) {
		System.out.println("INSERÇÃO DE PROPRIETARIO");
		if(repository.existsById(obj.getCpf())){
			System.out.println("INSERÇÃO DE PROPRIETARIO NAO LIBERADA");

			       throw new DatabaseException(obj.getCpf().toString());
		} else {

		try { 

			repository.save(obj);
		
		} catch (JpaObjectRetrievalFailureException e) {
			throw new AccessApiUsageException (obj.getCorretor().getCpf().toString());
			
		} catch (TransactionSystemException e) {
			
			throw new ViolationException (obj, e.getMostSpecificCause().toString());
	
		}  catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		       throw new DatabaseException(obj.getCpf().toString());
		       
		}  catch (JpaSystemException e) {

			e.printStackTrace();
			throw new ViolationException (obj, e.getMostSpecificCause().toString());
		
		
		} catch (RuntimeException e) {
		
			e.printStackTrace();
			throw new ErroNaoMapeadoException ("");
		}
			}
		
		return obj;
	}
	*/
}
