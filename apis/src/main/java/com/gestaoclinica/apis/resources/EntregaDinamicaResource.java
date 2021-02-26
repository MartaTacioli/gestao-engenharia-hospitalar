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

import com.gestaoclinica.apis.entities.EntregaDinamica;
import com.gestaoclinica.apis.service.EntregaDinamicaService;

@RestController
@RequestMapping (value = "/entrega-dinamica")
public class EntregaDinamicaResource {

	@Autowired
	private EntregaDinamicaService service;
	
	

	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<List<EntregaDinamica>> findAllByCnpjTransportadora(@PathVariable long cnpj){
		List<EntregaDinamica> obj = service.findAllByCnpjTransportadora(cnpj);
		
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<EntregaDinamica> insert (@RequestBody EntregaDinamica obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	
	@PostMapping(value = "/deletar")
	public ResponseEntity<EntregaDinamica> delete (@RequestBody EntregaDinamica obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	

}
