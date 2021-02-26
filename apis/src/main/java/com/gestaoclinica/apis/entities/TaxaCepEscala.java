package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "TB_CEP_ESCALA")
public class TaxaCepEscala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull
	private Long cnpj;
	
	@NotNull
	private Long cepDe;
	
	@NotNull
	private double valor;
	@NotNull
	private Long cepAte;
	
	@NotNull
	private String validadeDe = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	
	@NotNull
	private String validadeAte = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	
	@NotNull
	private int escala;

	

	public TaxaCepEscala () {
		
	}
	
	


	public double getValor() {
		return valor;
	}




	public void setValor(double valor) {
		this.valor = valor;
	}




	public TaxaCepEscala(@NotEmpty Long cnpj, @NotNull Long cepDe, @NotNull Long cepAte, @NotNull String validadeDe,
			@NotNull String validadeAte, @NotNull int escala) {
		super();
		this.cnpj = cnpj;
		this.cepDe = cepDe;
		this.cepAte = cepAte;
		this.validadeDe = validadeDe;
		this.validadeAte = validadeAte;
		this.escala = escala;
	}





	public Long getCnpj() {
		return cnpj;
	}



	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}



	public Long getCepDe() {
		return cepDe;
	}



	public void setCepDe(Long cepDe) {
		this.cepDe = cepDe;
	}



	public Long getCepAte() {
		return cepAte;
	}



	public void setCepAte(Long cepAte) {
		this.cepAte = cepAte;
	}



	public String getValidadeDe() {
		return validadeDe;
	}



	public void setValidadeDe(String validadeDe) {
		this.validadeDe = validadeDe;
	}



	public String getValidadeAte() {
		return validadeAte;
	}



	public void setValidadeAte(String validadeAte) {
		this.validadeAte = validadeAte;
	}



	public int getEscala() {
		return escala;
	}



	public void setEscala(int escala) {
		this.escala = escala;
	}




	public Long getId() {
		return Id;
	}




	public void setId(Long id) {
		Id = id;
	}





	







	
	
}
