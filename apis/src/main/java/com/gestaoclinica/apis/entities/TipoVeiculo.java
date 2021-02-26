package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "TB_TIPO_VEICULO")
public class TipoVeiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(unique = true)
	@NotEmpty
	private String tipoVeiculo;
	
	@JsonIgnore 
	@ManyToMany(mappedBy = "tipoVeiculo")	
	private Set<Motorista> motorista = new HashSet<>();


	public TipoVeiculo () {
		
	}


	public String getTipoVeiculo() {
		return tipoVeiculo;
	}


	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}


	public Set<Motorista> getMotorista() {
		return motorista;
	}


	public void setMotorista(Set<Motorista> motorista) {
		this.motorista = motorista;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}
	
	


	
	
}
