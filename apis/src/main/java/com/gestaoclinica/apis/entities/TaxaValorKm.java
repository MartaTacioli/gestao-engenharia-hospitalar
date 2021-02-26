package com.gestaoclinica.apis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "TB_VALOR_KM")
public class TaxaValorKm implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id 
	@NotNull
	private Long cnpj;
	
	@NotNull
	private double valorKm;


	
	public TaxaValorKm () {
		
	}


	public TaxaValorKm( @NotEmpty Long cnpj, @NotNull double valorKm) {
	
		this.cnpj = cnpj;
		this.valorKm = valorKm;
	}


	public Long getCnpj() {
		return cnpj;
	}


	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}


	public double getValorKm() {
		return valorKm;
	}


	public void setValorKm(double valorKm) {
		this.valorKm = valorKm;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	
}
