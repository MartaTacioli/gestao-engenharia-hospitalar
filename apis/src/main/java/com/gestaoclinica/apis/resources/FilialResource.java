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

import com.gestaoclinica.apis.entities.Filial;
import com.gestaoclinica.apis.service.FilialService;

@RestController
@RequestMapping (value = "/filial")
public class FilialResource {

	@Autowired
	private FilialService service;

	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<List<Filial>> findAllByCnpj(@PathVariable Long cnpj){
		List<Filial> obj = service.findAllByCnpj(cnpj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/filial-detalhe/{nome}")
	public ResponseEntity<Filial> findByNomeFilial(@PathVariable String nome){
		Filial obj = service.findByNomeFilial(nome);
		return ResponseEntity.ok().body(obj);
	}
	

	


	@PostMapping
	public ResponseEntity<Filial> insert (@RequestBody Filial obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PostMapping(value = "/deletar")
	public ResponseEntity<Filial> delete (@RequestBody Filial obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	

}
