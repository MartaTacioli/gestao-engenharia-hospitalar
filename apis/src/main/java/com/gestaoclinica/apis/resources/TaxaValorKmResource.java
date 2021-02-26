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

import com.gestaoclinica.apis.entities.TaxaValorKm;
import com.gestaoclinica.apis.service.TaxaValorKmService;

@RestController
@RequestMapping (value = "/taxa-valor-km")
public class TaxaValorKmResource {
	
	@Autowired
	private TaxaValorKmService service;
	
	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<List<TaxaValorKm>> findAllByCnpj(@PathVariable Long cnpj){
		List<TaxaValorKm> obj = service.findAllByCnpj(cnpj);

		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<TaxaValorKm>> findAll(){
		List<TaxaValorKm> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{cnpj}/{km}")
	public Double precoPorKm(@PathVariable Long cnpj, @PathVariable double km){
			return service.precoPorKm(cnpj,km);
	}
	@PostMapping
	public ResponseEntity<TaxaValorKm> insert (@RequestBody TaxaValorKm obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	
	
	
	
	

}
