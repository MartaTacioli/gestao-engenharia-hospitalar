package com.gestaoclinica.apis.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gestaoclinica.apis.entities.Maquina;
import com.gestaoclinica.apis.entities.Maquina;
import com.gestaoclinica.apis.service.MaquinaService;

@RestController
@RequestMapping (value = "/maquina")
public class MaquinaResource {
	
	@Autowired
	private MaquinaService service;
	
	@GetMapping
	public ResponseEntity<List<Maquina>> findAll(){
		List<Maquina> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Maquina> insert (@RequestBody Maquina obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/deletar")
	public ResponseEntity<Maquina> delete (@RequestBody Maquina obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	

}
