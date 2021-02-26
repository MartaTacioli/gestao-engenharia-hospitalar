package com.gestaoclinica.apis.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gestaoclinica.apis.entities.Regiao;
import com.gestaoclinica.apis.entities.Transportadora;
import com.gestaoclinica.apis.entities.matrix.Nota;
import com.gestaoclinica.apis.entities.matrix.NotaRequest;
import com.gestaoclinica.apis.service.TransportadoraService;

@RestController
@RequestMapping (value = "/transportadora")
public class TransportadoraResource {
	
	@Autowired	
	private TransportadoraService service;
	
	@GetMapping
	public ResponseEntity<List<Transportadora>> findAll(){
		List<Transportadora> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	
	@GetMapping(value = "/preco/{cnpj}/{km}")
	public double calcularPreco (@Valid @PathVariable Long cnpj, @Valid @PathVariable double km){
		
		double valor = service.calcularPreco(cnpj,km);
		return valor;
	}
	
	@PostMapping(value = "/filter/regiao")
	public ResponseEntity<List<Transportadora>> findAllByRegiao (@RequestBody List<Regiao> obj){
		
		List<Transportadora> list = service.findAllByRegiao(obj);
		return ResponseEntity.ok().body(list);
	}
	
	
	@PostMapping(value = "/filter/regiao/quantidade")
	public ResponseEntity<Integer> findAllByRegiaoCount (@RequestBody List<Regiao> obj){
		var count = 0;
		count = service.findAllByRegiao(obj).size();
		return ResponseEntity.ok().body(count);
	}
	
	

	@GetMapping(value = "/pendentes")
	public ResponseEntity<List<Transportadora>> findPendentes(){
		List<Transportadora> list = service.findPendentes();
		return ResponseEntity.ok().body(list);
	}

	@PutMapping(value = "/atualizar")
	public ResponseEntity<Transportadora> atualizarTransportadora (@RequestBody Transportadora obj){
		System.out.println("entrou no put pelo menos");
		obj = service.atualizarTransportadora(obj);
		System.out.println("entrou no put");
	 return ResponseEntity.ok().body(obj);
	}
	
	
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<Transportadora> findById(@Valid @PathVariable Long cpf){
		Transportadora obj = service.findById(cpf);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	@PostMapping
	public ResponseEntity<Transportadora> insert (@RequestBody Transportadora obj){
		System.out.println(obj.toString());
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getCnpj()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	

	
	@PutMapping(value = "/pendentes/aprovar")
	public ResponseEntity<List<Transportadora>> aprovarTransportadoras (@RequestBody List<Transportadora> obj){
		System.out.println("entrou no put pelo menos");
		obj = service.aprovarTransportadoras(obj);
		System.out.println("entrou no put");
	 return ResponseEntity.ok().body(obj);
	}
	
	
	@PutMapping(value = "/tipo-de-preco")
	public ResponseEntity<Transportadora> atualizarEscolhaPreco (@RequestBody Transportadora obj){
		System.out.println("entrou no put pelo menos");
		obj = service.atualizarEscolhaPreco(obj);
		System.out.println("entrou no put");
	 return ResponseEntity.ok().body(obj);
	}
	

}
