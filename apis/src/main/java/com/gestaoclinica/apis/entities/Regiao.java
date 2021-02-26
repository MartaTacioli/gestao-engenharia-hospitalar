package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "TB_REGIAO",
uniqueConstraints=
@UniqueConstraint(columnNames={"estado","cidade", "zona", "cepDe", "cepPara"})
)
public class Regiao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@NotEmpty
	private String estado;
	@NotEmpty
	private String cidade;

	@NotEmpty
	private String zona;
	
	@NotEmpty
	private String cepDe;
	
	@NotEmpty
	private String cepPara;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "regiao")	
	private Set<Transportadora> transportadora = new HashSet<>();
	
	@JsonIgnore 
	@ManyToMany(mappedBy = "tipoVeiculo")	
	private Set<Motorista> motorista = new HashSet<>();
	
	public Regiao () {
	}
	
	






	public Regiao(@NotEmpty String estado, @NotEmpty String cidade, @NotEmpty String zona, @NotEmpty String cepDe,
			@NotEmpty String cepPara, Set<Transportadora> transportadora, Set<Motorista> motorista) {
		super();
		this.estado = estado;
		this.cidade = cidade;
		this.zona = zona;
		this.cepDe = cepDe;
		this.cepPara = cepPara;
		this.transportadora = transportadora;
		this.motorista = motorista;
	}








	public String getEstado() {
		return estado;
	}








	public void setEstado(String estado) {
		this.estado = estado;
	}








	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getZona() {
		return zona;
	}


	public void setZona(String zona) {
		this.zona = zona;
	}


	public String getCepDe() {
		return cepDe;
	}


	public void setCepDe(String cepDe) {
		this.cepDe = cepDe;
	}


	public String getCepPara() {
		return cepPara;
	}


	public void setCepPara(String cepPara) {
		this.cepPara = cepPara;
	}


	public Set<Transportadora> getTransportadora() {
		return transportadora;
	}


	public void setTransportadora(Set<Transportadora> transportadora) {
		this.transportadora = transportadora;
	}




	public Set<Motorista> getMotorista() {
		return motorista;
	}




	public void setMotorista(Set<Motorista> motorista) {
		this.motorista = motorista;
	}
	
	
	

	
	
	
	
}
