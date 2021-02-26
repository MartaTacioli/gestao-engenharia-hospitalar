package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_MAQUINA", uniqueConstraints = @UniqueConstraint(columnNames = { "maquina" }))
public class Maquina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String maquina;

	@OneToMany (mappedBy = "maquina")
	@JsonIgnore
	private List<Modelo> modelo = new ArrayList<>();
	
	
	public Maquina() {

	}


	public Maquina(@NotEmpty String maquina, List<Modelo> modelo) {
		this.maquina = maquina;
		this.modelo = modelo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMaquina() {
		return maquina;
	}


	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}


	public List<Modelo> getModelo() {
		return modelo;
	}


	public void setModelo(List<Modelo> modelo) {
		this.modelo = modelo;
	}



	

}
