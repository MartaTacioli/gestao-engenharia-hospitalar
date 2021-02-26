package com.gestaoclinica.apis.jwt;

import java.io.Serializable;

public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	private Long cnpj;
	private String senha;
	

//need default constructor for JSON Parsing
	public JwtRequest() {
	}

	public JwtRequest(Long cnpj, String senha) {
		this.setCnpj(cnpj);
		this.setSenha(senha);
	}



	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	
}
