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

import com.gestaoclinica.apis.entities.TaxaPesoEscala;
import com.gestaoclinica.apis.service.TaxaPesoEscalaService;

@RestController
@RequestMapping (value = "/taxa-peso-escala")
public class TaxaPesoEscalaResource {
	
	@Autowired
	private TaxaPesoEscalaService service;
	/*
	@GetMapping
	public ResponseEntity<List<TaxaPesoEscala>> findAll(){
		List<TaxaPesoEscala> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	*/
	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<List<TaxaPesoEscala>> findAllByCnpj(@PathVariable Long cnpj){
		List<TaxaPesoEscala> obj = service.findAllByCnpj(cnpj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/escalas/{cnpj}")
	public ResponseEntity<List<Integer>> findAllEscalas(@PathVariable Long cnpj){
		System.out.println("TAXA PESO ESCALAS");
		List<Integer> obj = service.findAllEscalas(cnpj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<TaxaPesoEscala> insert (@RequestBody TaxaPesoEscala obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PostMapping(value = "/deletar")
	public ResponseEntity<TaxaPesoEscala> delete (@RequestBody TaxaPesoEscala obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	

}
