package com.gestaoclinica.apis.entities;

import javax.validation.constraints.Email;

import com.sun.istack.NotNull;

public class EnviarEmail {


	@NotNull
	private String name;
	
	@NotNull
	private String nomeMotorista;
	
	@NotNull
	private String cnhMotorista;
	
	@NotNull
	private int tipoEmail;
	
	
	@NotNull
	private String telefoneMotorista;
	
	@NotNull
	@Email
	private String email;
	
	private String mensagem;
	@NotNull
	@Email
	private Long cnpj;
	@NotNull
	private String mensagemCadastroMotorista;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getMensagemCadastroMotorista() {
		return mensagemCadastroMotorista;
	}


	public Long getCnpj() {
		return cnpj;
	}


	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}


	public void setMensagemCadastroMotorista(String mensagemCadastroMotorista) {
		this.mensagemCadastroMotorista = mensagemCadastroMotorista;
	}


	public String getNomeMotorista() {
		return nomeMotorista;
	}


	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}


	public String getCnhMotorista() {
		return cnhMotorista;
	}


	public void setCnhMotorista(String cnhMotorista) {
		this.cnhMotorista = cnhMotorista;
	}


	public String getTelefoneMotorista() {
		return telefoneMotorista;
	}


	public void setTelefoneMotorista(String telefoneMotorista) {
		this.telefoneMotorista = telefoneMotorista;
	}


	public int getTipoEmail() {
		return tipoEmail;
	}


	public void setTipoEmail(int tipoEmail) {
		this.tipoEmail = tipoEmail;
	}
	
	
	
	
}
