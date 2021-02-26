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

import com.gestaoclinica.apis.entities.Regiao;
import com.gestaoclinica.apis.entities.TipoVeiculo;
import com.gestaoclinica.apis.service.RegiaoService;

@RestController
@RequestMapping (value = "/regiao")
public class RegiaoResource {

	@Autowired
	private RegiaoService service;

	@GetMapping
	public ResponseEntity<List<Regiao>> findAll(){
		List<Regiao> obj = service.findAll();
		
		return ResponseEntity.ok().body(obj);
	}
	
	
	@GetMapping(value = "/estados/{estado}")
	public ResponseEntity<List<Regiao>> findAllByEstado(@PathVariable String estado){
		List<Regiao> obj = service.findAllByEstado(estado);
		
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/zona/{estado}/{cidade}")
	public ResponseEntity<List<Regiao>> findAllByEstadoAndCidade(@PathVariable String estado,@PathVariable String cidade){
		List<Regiao> obj = service.findAllByEstadoAndCidade(estado,cidade);
		
		return ResponseEntity.ok().body(obj);
	}

	/*
	@GetMapping(value = "/{id}")
	public ResponseEntity<Regiao> findById(@PathVariable Long cpf){
		CaracteristicasImovel obj = service.findById(cpf);
		return ResponseEntity.ok().body(obj);
	}
	*/
	
	@PostMapping
	public ResponseEntity<Regiao> insert (@RequestBody Regiao obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PostMapping(value = "/deletar")
	public ResponseEntity<Regiao> delete (@RequestBody Regiao obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	

}
