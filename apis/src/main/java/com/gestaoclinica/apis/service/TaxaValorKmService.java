package com.gestaoclinica.apis.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.TaxaValorKm;
import com.gestaoclinica.apis.repositories.TaxaValorKmRepository;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;

@Service
public class TaxaValorKmService {
	
	
	@Autowired
	private TaxaValorKmRepository repository;
	

	
	public List<TaxaValorKm> findAll(){
		return repository.findAll();

	}
	
	public List<TaxaValorKm> findAllByCnpj(Long cnpj){
		return repository.findAllByCnpj(cnpj);

	}
	
	
	public Double precoPorKm(Long cnpj, Double km){
		double precoPorKm = 0;
		
		TaxaValorKm taxaValorKm = new TaxaValorKm();
		
		taxaValorKm = repository.findByCnpj (cnpj);
		
		precoPorKm = km*taxaValorKm.getValorKm();
		
		return precoPorKm;

	}

	public TaxaValorKm insert (TaxaValorKm obj) {	
		if (obj.getValorKm() == 0) {
			throw new CamposObrigatoriosException (obj, "Valor inv�lido!");
		} else {
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
	}
	

	

  
}

	
	
//	new BCryptPasswordEncoder().encode


