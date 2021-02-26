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

import com.gestaoclinica.apis.entities.AprovacaoMotorista;
import com.gestaoclinica.apis.service.AprovacaoMotoristaService;

@RestController
@RequestMapping (value = "/aprovar-motorista")
public class AprovacaoMotoristaResource {
	
	@Autowired
	private AprovacaoMotoristaService service;
	/*
	@GetMapping
	public ResponseEntity<List<AprovacaoMotorista>> findAll(){
		List<AprovacaoMotorista> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<List<AprovacaoMotorista>> findAllByCnpj(@PathVariable Long cnpj){
		List<AprovacaoMotorista> obj = service.findAllByCnpj(cnpj);
		return ResponseEntity.ok().body(obj);
	}
		*/

	
	
	@PostMapping
	public ResponseEntity<AprovacaoMotorista> insert (@RequestBody AprovacaoMotorista obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	/*
	
	@PostMapping(value = "/deletar")
	public ResponseEntity<AprovacaoMotorista> delete (@RequestBody AprovacaoMotorista obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	*/
	
	

}
