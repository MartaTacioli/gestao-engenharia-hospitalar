package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_TRANSPORTADORA")
public class Transportadora implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long cnpj;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String celular;
	@NotEmpty
	private String senha;

	@NotEmpty
	private String senhaConfirmacao;


	private String email;
	
	@NotNull
	private Long cep;
	@NotEmpty
	private String logradouro;
	@NotNull
	private int numero;
	@NotEmpty
	private String estado;
	@NotEmpty
	private String cidade;
	@NotEmpty
	private String bairro;
	@NotNull
	private int aprovado;
	@NotNull
	private int tipoDePreco;
	@JsonIgnore 
	@ManyToMany(mappedBy = "transportadora")	
	private Set<Motorista> motorista = new HashSet<>();

	 @ManyToMany
	    @JoinTable(name = "TB_TRANSPORTADORA_REGIAO", 
	    joinColumns = @JoinColumn(name = "transportadora_cnpj"),
	    inverseJoinColumns = @JoinColumn(name = "regiao_id")
	    )
		private Set<Regiao> regiao = new HashSet<>(); 
	 
	private String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

	/*
	
	@OneToMany (mappedBy = "corretor")
	@JsonIgnore
	private List<Proprietario> proprietarios = new ArrayList<>();
	



	@OneToOne(mappedBy = "corretor", cascade = CascadeType.ALL)
	@JsonIgnore
	private Login login;
	
	
	@OneToMany (mappedBy = "corretor")
	@JsonIgnore
	private List<Motorista> anuncios = new ArrayList<>();
	*/

	
	public Transportadora () {
		
	}
	
	

	public int getTipoDePreco() {
		return tipoDePreco;
	}


	public void setTipoDePreco(int tipoDePreco) {
		this.tipoDePreco = tipoDePreco;
	}


	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public int getAprovado() {
		return aprovado;
	}

	public void setAprovado(int aprovado) {
		this.aprovado = aprovado;
	}

	public Set<Motorista> getMotorista() {
		return motorista;
	}

	public void setMotorista(Set<Motorista> motorista) {
		this.motorista = motorista;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaConfirmacao() {
		return senhaConfirmacao;
	}

	public void setSenhaConfirmacao(String senhaConfirmacao) {
		this.senhaConfirmacao = senhaConfirmacao;
	}

	public Set<Regiao> getRegiao() {
		return regiao;
	}

	public void setRegiao(Set<Regiao> regiao) {
		this.regiao = regiao;
	}





	
	
}
