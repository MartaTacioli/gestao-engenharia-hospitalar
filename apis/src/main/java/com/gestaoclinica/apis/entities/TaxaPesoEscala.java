package com.gestaoclinica.apis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "TB_PESO_ESCALA")
public class TaxaPesoEscala implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull
	private Long cnpj;
	
	@NotNull
	private double pesoDe;

	@NotNull
	private double pesoAte;
	
	@NotNull
	private double valor;
	
	@NotNull
	private int escala;
	public TaxaPesoEscala () {
		
	}
	

	public TaxaPesoEscala(@NotNull Long cnpj, @NotNull double pesoDe, @NotNull double pesoAte, @NotNull double valor,
			@NotNull int escala) {
		super();
		this.cnpj = cnpj;
		this.pesoDe = pesoDe;
		this.pesoAte = pesoAte;
		this.valor = valor;
		this.escala = escala;
	}



	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	public Long getCnpj() {
		return cnpj;
	}


	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}


	public double getPesoDe() {
		return pesoDe;
	}
	public void setPesoDe(double pesoDe) {
		this.pesoDe = pesoDe;
	}
	public double getPesoAte() {
		return pesoAte;
	}
	public void setPesoAte(double pesoAte) {
		this.pesoAte = pesoAte;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getEscala() {
		return escala;
	}
	public void setEscala(int escala) {
		this.escala = escala;
	}

	



	
	
}
