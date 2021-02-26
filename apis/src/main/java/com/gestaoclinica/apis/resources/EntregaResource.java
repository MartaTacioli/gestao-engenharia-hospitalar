package com.gestaoclinica.apis.resources;

import java.io.IOException;
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

import com.gestaoclinica.apis.entities.Entrega;
import com.gestaoclinica.apis.entities.matrix.MatrixDistanciaRequest;
import com.gestaoclinica.apis.entities.matrix.MenorCaminhoRequest;
import com.gestaoclinica.apis.entities.matrix.MenorCaminhoResponse;
import com.gestaoclinica.apis.entities.matrix.Nota;
import com.gestaoclinica.apis.entities.matrix.NotaRequest;
import com.gestaoclinica.apis.service.EntregaService;

@RestController
@RequestMapping (value = "/entrega")
public class EntregaResource {

	@Autowired
	private EntregaService service;
	
	

	@GetMapping
	public ResponseEntity<List<Entrega>> findAll(){
		List<Entrega> obj = service.findAll();
		
		return ResponseEntity.ok().body(obj);
	}

	
	
	@PostMapping(value="/calcular-menor-caminho")
	public MenorCaminhoResponse calcularMenorCaminho (@RequestBody MenorCaminhoRequest obj){
	
		return service.calcularMenorDistancia(obj);
		
		 
	}
	
	@PostMapping(value = "/consultar-nota")
	public ResponseEntity<Nota> consultarNota (@RequestBody NotaRequest obj) throws IOException{
		
		Nota nota = service.apiConsultaNota(obj);
		return ResponseEntity.ok().body(nota);
	}
//	
//	@PostMapping
//	public ResponseEntity<Entrega> insert (@RequestBody Entrega obj){
//		obj = service.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				  .buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).body(obj);
//	}
	
	@PostMapping(value = "/deletar")
	public ResponseEntity<Entrega> delete (@RequestBody Entrega obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	

}
