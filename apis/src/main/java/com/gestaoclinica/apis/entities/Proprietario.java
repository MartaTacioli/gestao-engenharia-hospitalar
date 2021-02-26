package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="TB_PROPRIETARIO")
public class Proprietario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long cpf;
	
	@NotEmpty
	private String nome;
	@NotEmpty
	private String telefone;
	@NotEmpty
	private String email;

	private String endereco;
	private String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	
	/*
	@ManyToOne
	@JoinColumn(name = "corretor_id")
	private Transportadora corretor;

	@OneToMany (mappedBy = "proprietario")
	@JsonIgnore
	private List<Motorista> anuncios = new ArrayList<>();
	*/
	
	private String nomeAutorizadorDeAnuncio;
	
	public Proprietario() {
		
	}
	
	public Proprietario(Long cpf, String nome, String telefone, String email, String endereco, Transportadora corretor, String nomeAutorizadorDeAnuncio) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		
		
		
	}
	

	public String getNomeAutorizadorDeAnuncio() {
		return nomeAutorizadorDeAnuncio;
	}

	public void setNomeAutorizadorDeAnuncio(String nomeAutorizadorDeAnuncio) {
		this.nomeAutorizadorDeAnuncio = nomeAutorizadorDeAnuncio;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}
	/*
	public void setAnuncios(List<Motorista> anuncios) {
		this.anuncios = anuncios;
	}
	*/

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
/*
	public Transportadora getCorretor() {
		return corretor;
	}


	public void setCorretor(Transportadora corretor) {
		this.corretor = corretor;
	}
	*/
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/*
	public List<Motorista> getAnuncios(){
		return anuncios;
	}
	
	*/


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proprietario other = (Proprietario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
