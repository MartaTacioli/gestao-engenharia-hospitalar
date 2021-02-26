package com.gestaoclinica.apis.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.AprovacaoMotorista;
import com.gestaoclinica.apis.repositories.AprovacaoMotoristaRepository;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;

@Service
public class AprovacaoMotoristaService {
		
	
	@Autowired
	private AprovacaoMotoristaRepository repository;
	

	
	public List<AprovacaoMotorista> findAll(){
		return repository.findAll();

	}
	
	public List<AprovacaoMotorista> findAllByCnpjTransportadora(Long cnpj){
		return repository.findAllByCnpjTransportadora(cnpj);

	}
	public List<AprovacaoMotorista> findAllByCpfMotorista(Long cpf){
		return repository.findAllByCpfMotorista(cpf);

	}
	public AprovacaoMotorista findByCnpjTransportadoraAndCpfMotorista(Long cnpj,Long cpf){
		return repository.findByCnpjTransportadoraAndCpfMotorista(cnpj,cpf);

	}
	public List<AprovacaoMotorista> findAllByCpfMotoristaAndAprovado(Long cpf, int aprovado){
		return repository.findAllByCpfMotoristaAndAprovado(cpf,aprovado);

	}

	public AprovacaoMotorista insert (AprovacaoMotorista obj) {	
		try {
		 repository.save(obj);
		} catch (DataIntegrityViolationException e){
	 		
			  throw new RecursoJaCadastradoException ("Ja cadastrado",1);
				
			} catch (ConstraintViolationException e) {
				throw new CamposObrigatoriosException (obj, "Taxa ja cadastrada para esse CNPJ");
				
			} catch (RuntimeException e) {
				e.printStackTrace();
				throw new ErroNaoMapeadoException ("");
			}
		return obj;
	
	}
	/*
	public AprovacaoMotorista delete (AprovacaoMotorista obj) {	
		try {
		 repository.deleteBy(obj.getId());
		} catch (DataIntegrityViolationException e){
	 		
			  throw new DatabaseException ("Ja deletado");
				
			} catch(EmptyResultDataAccessException e){
				
				  throw new DatabaseException ("Não existe esse registro.");

			}catch (RuntimeException e) {
			
				e.printStackTrace();
				throw new ErroNaoMapeadoException ("");
			}
		return obj;
	
	}
	*/
	


  
}

	
	
//	new BCryptPasswordEncoder().encode


