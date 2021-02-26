package com.gestaoclinica.apis.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gestaoclinica.apis.entities.TaxaCepEscala;
import com.gestaoclinica.apis.entities.TipoVeiculo;
import com.gestaoclinica.apis.service.TipoVeiculoService;

@RestController
@RequestMapping (value = "/tipo-veiculo")
public class TipoVeiculoResource {
	
	@Autowired
	private TipoVeiculoService service;
	
	@GetMapping
	public ResponseEntity<List<TipoVeiculo>> findAll(){
		List<TipoVeiculo> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}

/*
	@GetMapping(value = "/{id}")
	public ResponseEntity<TipoVeiculo> findById(@PathVariable Long cpf){
		TipoVeiculo obj = service.findById(cpf);
		return ResponseEntity.ok().body(obj);
	}
	*/
	@PostMapping
	public ResponseEntity<TipoVeiculo> insert (@RequestBody TipoVeiculo obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getTipoVeiculo()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PostMapping(value = "/deletar")
	public ResponseEntity<TipoVeiculo> delete (@RequestBody TipoVeiculo obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	

}
