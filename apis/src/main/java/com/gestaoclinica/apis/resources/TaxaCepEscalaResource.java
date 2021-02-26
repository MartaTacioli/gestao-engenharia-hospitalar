package com.gestaoclinica.apis.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gestaoclinica.apis.entities.TaxaCepEscala;
import com.gestaoclinica.apis.service.TaxaCepEscalaService;

@RestController
@RequestMapping (value = "/taxa-cep-escala")
public class TaxaCepEscalaResource {
	
	@Autowired
	private TaxaCepEscalaService service;
	

	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<List<TaxaCepEscala>> findAllByCnpj(@PathVariable Long cnpj){
		List<TaxaCepEscala> obj = service.findAllByCnpj(cnpj);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<TaxaCepEscala> insert (@RequestBody TaxaCepEscala obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PostMapping(value = "/deletar")
	public ResponseEntity<TaxaCepEscala> delete (@RequestBody TaxaCepEscala obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	
	

}
