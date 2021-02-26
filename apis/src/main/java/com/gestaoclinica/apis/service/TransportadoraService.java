package com.gestaoclinica.apis.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.gestaoclinica.apis.entities.Login;
import com.gestaoclinica.apis.entities.Regiao;
import com.gestaoclinica.apis.entities.TaxaCepEscala;
import com.gestaoclinica.apis.entities.TaxaPesoEscala;
import com.gestaoclinica.apis.entities.TaxaValorKm;
import com.gestaoclinica.apis.entities.Transportadora;
import com.gestaoclinica.apis.entities.matrix.Nota;
import com.gestaoclinica.apis.entities.matrix.NotaRequest;
import com.gestaoclinica.apis.repositories.LoginRepository;
import com.gestaoclinica.apis.repositories.TaxaCepEscalaRepository;
import com.gestaoclinica.apis.repositories.TaxaPesoEscalaRepository;
import com.gestaoclinica.apis.repositories.TaxaValorKmRepository;
import com.gestaoclinica.apis.repositories.TransportadoraRepository;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.SenhasDiferentesException;
import com.gestaoclinica.apis.service.exceptions.ValidacaoTamanhoSenhaException;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;

@Service
public class TransportadoraService {
	
	@Autowired
	private TransportadoraRepository repository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private TaxaValorKmRepository taxaValorKmRepository;
	
	@Autowired
	private TaxaCepEscalaRepository taxaCepEscalaRepository;
	
	@Autowired
	private TaxaPesoEscalaRepository taxaPesoEscalaRepository;
	
	@Autowired
	private LoginService loginService;
	
	public List<Transportadora> findAll(){
		return repository.findAll();
	}
	public List<Transportadora> findAllByRegiao(List<Regiao> regioes){
		String transportadorasRepetidas = "";
		List<Transportadora> obj = repository.findAllByRegiaoInAndAprovado(regioes, 1);
		List<Transportadora> objResponse =  new ArrayList<>();
	
		 for (Transportadora transportadoraAtual : obj) {
		

			 if ((transportadoraAtual.getAprovado() == 1 || transportadoraAtual.getAprovado() == 10) &&
					 (!transportadorasRepetidas.contains(transportadoraAtual.getCnpj().toString()))) {
					transportadorasRepetidas =transportadorasRepetidas + transportadoraAtual.getCnpj().toString();
					objResponse.add(transportadoraAtual);

			 }
	        }
		 return objResponse;
	}
	
	
	public List<Transportadora> findPendentes(){
		try {
			List<Transportadora> obj = repository.findAllByAprovado(0);
			return obj;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	public Nota consultarNota(NotaRequest obj){
		
		
		return null;
		
		
	}

	public Transportadora findById(Long cpf) {
		//Optional: Garante que estamos retornando o objeto no banco de dados, não apenas seus valores//
		Optional<Transportadora> obj = repository.findById(cpf);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(cpf,1));
	}
	
	public Transportadora findByCnpj(Long cnpj) {
		//Optional: Garante que estamos retornando o objeto no banco de dados, não apenas seus valores//
		Transportadora obj = repository.findByCnpj(cnpj);
		return obj;
	}
	
	
	
	public Transportadora atualizarEscolhaPreco(Transportadora obj){
		try {
		
			 Transportadora entity = repository.getOne(obj.getCnpj());
			 entity.setTipoDePreco(obj.getTipoDePreco());
	         repository.save(entity);
	        
		 
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontradoException ("O recurso a ser aprovado não existe na base. Atualize a página e tente novamente.",1);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ErroNaoMapeadoException("Erro não mapeado na aprovação de corretores.");
		}
		return obj;
	}
	
	
	
	public List<Transportadora> aprovarTransportadoras(List<Transportadora> obj){
		try {
		 for (Transportadora transportadoraAtual : obj) {
			 Transportadora entity = repository.getOne(transportadoraAtual.getCnpj());
			 Login loginEntity = loginRepository.getOne(transportadoraAtual.getCnpj());
			 entity.setAprovado(transportadoraAtual.getAprovado());
			 loginEntity.setAprovado(transportadoraAtual.getAprovado());
	         repository.save(entity);
	        }
		 
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontradoException ("O recurso a ser aprovado não existe na base. Atualize a página e tente novamente.",1);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ErroNaoMapeadoException("Erro não mapeado na aprovação de corretores.");
		}
		return obj;
	}
	public Transportadora insert (Transportadora obj) {
	if (obj.getSenha().toString().equals(obj.getSenhaConfirmacao().toString())) {
		if(repository.existsById(obj.getCnpj())){
			throw new RecursoJaCadastradoException(obj.getCnpj().toString(),1);
		} else {
			if (obj.getSenha().length() > 5) {
			try {
				Transportadora objEcp = new Transportadora ();
				objEcp = obj;
				objEcp.setSenha(new BCryptPasswordEncoder().encode(obj.getSenha()));
				objEcp.setSenhaConfirmacao(new BCryptPasswordEncoder().encode(obj.getSenhaConfirmacao()));	
				obj.setAprovado(0);

				loginService.saveLoginCorretor(objEcp);
				repository.save(objEcp);
							
			}catch (DataIntegrityViolationException e) {
					e.printStackTrace();
			       throw new RecursoJaCadastradoException(obj.getCnpj().toString(),1);
			       
				} catch (TransactionSystemException e) {
					System.out.println("2");

					e.printStackTrace();	
					e.getCause().getStackTrace();
					throw new CamposObrigatoriosException (obj, e.getMostSpecificCause().toString());
				} catch (JpaSystemException e) {
					System.out.println("3");

					e.printStackTrace();
					throw new CamposObrigatoriosException (obj, e.getMostSpecificCause().toString());
				} 
				} else {
					throw new ValidacaoTamanhoSenhaException ("A senha deve conter no mínimo 6 caracteres!");
				}
				}
	} else {
		throw new SenhasDiferentesException ("Senhas no cadastro de corretores não estão iguais.");
	}
		
		return obj;
	}
	
	

	public Transportadora atualizarTransportadora(Transportadora obj){
		try {
		
			Transportadora entity = repository.findByCnpj(obj.getCnpj());
			entity.setNome(obj.getNome());
			entity.setNumero(obj.getNumero());
			entity.setLogradouro(obj.getLogradouro());
			entity.setCidade(obj.getCidade());
			entity.setBairro(obj.getBairro());
			entity.setEstado(obj.getEstado());
			entity.setEmail(obj.getEmail());
			entity.setCelular(obj.getCelular());
			entity.setCep(obj.getCep());
			if (obj.getRegiao().size() >= 1) {
				entity.setRegiao(obj.getRegiao());
			}


			return repository.save(entity);
			
	        
		} catch (TransactionSystemException e) {
			
			throw new CamposObrigatoriosException ("Existem campos vazios!", null);

		} catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontradoException ("O recurso a ser aprovado não existe na base. Atualize a página e tente novamente.",1);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ErroNaoMapeadoException("Erro não mapeado na aprovação de corretores.");
		}
	}
	
	
	
	
	public double calcularPreco(Long cnpj, double km) {
		//Optional: Garante que estamos retornando o objeto no banco de dados, não apenas seus valores//
		Transportadora obj = repository.findByCnpj(cnpj);
		double valor = 0;
		if (obj.getTipoDePreco() == 1) {
			TaxaValorKm taxaValorKm = new TaxaValorKm();
			taxaValorKm = taxaValorKmRepository.findByCnpj(cnpj);
			valor = km * taxaValorKm.getValorKm();
			
		} else if (obj.getTipoDePreco() == 2){
			List<TaxaCepEscala> taxaCepEscala = new ArrayList<TaxaCepEscala>();
			taxaCepEscala = taxaCepEscalaRepository.findAllByCnpj(cnpj);
			valor = 1;
			
			
		} else if (obj.getTipoDePreco() == 3){
			List<TaxaPesoEscala> taxaPesoEscala = new ArrayList<TaxaPesoEscala>();
			taxaPesoEscala = taxaPesoEscalaRepository.findAllByCnpj(cnpj);
			valor = 1;
			
			
		}
		
		return valor;
	}
	
}
