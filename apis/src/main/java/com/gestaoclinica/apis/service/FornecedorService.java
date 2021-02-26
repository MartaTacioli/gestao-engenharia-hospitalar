package com.gestaoclinica.apis.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.Fornecedor;
import com.gestaoclinica.apis.repositories.FornecedorRepository;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;

	public List<Fornecedor> findAll() {
		return repository.findAll();

	}

	public Fornecedor insert(Fornecedor obj) {
		try {
			repository.save(obj);
		} catch (DataIntegrityViolationException e) {

			throw new RecursoJaCadastradoException("Esse fornecedor já foi cadastrado no sistema.", obj.getFornecedor());

		} catch (ConstraintViolationException e) {
			
			throw new CamposObrigatoriosException(null,"Campos obrigatórios devem ser preenchidos.");
			
		} catch (RuntimeException e) {

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}
		return obj;
	}

	public Fornecedor delete(Fornecedor obj) {

		try {
			repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e) {

			throw new RecursoNaoEncontradoException("o esse fornecedor", obj.getId());

		} catch (EmptyResultDataAccessException e) {

			throw new RecursoNaoEncontradoException("o esse fornecedor", obj.getId());

		}  catch (InvalidDataAccessApiUsageException e) {
			
			throw new CamposObrigatoriosException(null,"O id do recurso a ser deletado deve ser informado.");
			
			
		} catch (RuntimeException e) {
		

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}
		return obj;

	}

}
