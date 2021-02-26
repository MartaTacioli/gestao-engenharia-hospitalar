package com.gestaoclinica.apis.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.TaxaPesoEscala;
import com.gestaoclinica.apis.repositories.TaxaPesoEscalaRepository;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;

@Service
public class TaxaPesoEscalaService {
	
	
	@Autowired
	private TaxaPesoEscalaRepository repository;
	

	
	public List<TaxaPesoEscala> findAll(){
		return repository.findAll();

	}
	public List<TaxaPesoEscala> findAllByCnpj(Long cnpj){
		return repository.findAllByCnpj(cnpj);

	}
	public List<Integer> findAllEscalas(Long cnpj){
		List<Integer> objFinal = new ArrayList<Integer>();

		List<TaxaPesoEscala> objResponse = new ArrayList<TaxaPesoEscala>();
		objResponse = repository.findAllByCnpj(cnpj);
		
		for (TaxaPesoEscala atual: objResponse) {
			var contem = false;
			for (Integer atualFinal: objFinal) {
				if (atualFinal == atual.getEscala()) {
					contem = true;
				}
				
			}
			if (contem == false) {
				System.out.println("TAXA PESO ESCALAS:entrando");

				objFinal.add(atual.getEscala());
			} 
			
		}
		return objFinal;

	}

	public TaxaPesoEscala insert (TaxaPesoEscala obj) {	
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
	
	public TaxaPesoEscala delete (TaxaPesoEscala obj) {	
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


