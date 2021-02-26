package com.gestaoclinica.apis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table (name = "TB_FILIAL",
uniqueConstraints=
@UniqueConstraint(columnNames={"nomeFilial"})
)
public class Filial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull
	private Long cnpj;
	@NotNull
	private Long cnpjCentro;
	@NotEmpty
	private String nomeFilial;


	private String complementacao;
	
	@NotEmpty
	private String endereco;
	
	@NotNull
	private Long cep;
	
	@NotNull
	private double numero;
	
	@NotNull
	private double latitude;
	
	@NotNull
	private double longitude;
	
	
	public Filial () {
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNomeFilial() {
		return nomeFilial;
	}

	
	public String getComplementacao() {
		return complementacao	;
	}

	public void setComplementacaoo(String complementacao) {
		this.complementacao = complementacao;
	}

	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public double getNumero() {
		return numero;
	}

	public void setNumero(double numero) {
		this.numero = numero;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	

	

	public Long getCnpjCentro() {
		return cnpjCentro;
	}

	public void setCnpjCentro(Long cnpjCentro) {
		this.cnpjCentro = cnpjCentro;
	}

	public void setComplementacao(String complementacao) {
		this.complementacao = complementacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	
	

	
	
}
