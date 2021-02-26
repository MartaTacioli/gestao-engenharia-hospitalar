package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "TB_MOTORISTA",
uniqueConstraints=
@UniqueConstraint(columnNames={"cpf"})
)
public class Motorista implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nomeCompleto;
	@NotNull
	@Id
	private Long cpf;
	@NotEmpty
	private String celular;
	@NotEmpty
	private String placa;
	@NotEmpty
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
	private Long numeroCnh;
	private String diretorioCnh;
	@NotNull
	private Boolean aprovado;
	 @ManyToMany
	    @JoinTable(name = "TB_MOTORISTA_REGIAO", 
	    joinColumns = @JoinColumn(name = "motorista_cpf"),
	    inverseJoinColumns = @JoinColumn(name = "regiao_id")
	    )
		private Set<Regiao> regiao = new HashSet<>();
	
	 @ManyToMany
	    @JoinTable(name = "TB_MOTORISTA_TIPO_VEICULO", 
	    joinColumns = @JoinColumn(name = "motorista_cpf"),
	    inverseJoinColumns = @JoinColumn(name = "tipoVeiculo_id")
	    )
		private Set<TipoVeiculo> tipoVeiculo = new HashSet<>();
	 @ManyToMany
	    @JoinTable(name = "TB_MOTORISTA_TRANSPORTADORA", 
	    joinColumns = @JoinColumn(name = "motorista_cpf"),
	    inverseJoinColumns = @JoinColumn(name = "transportadora_cnpj")
	    )
		private Set<Transportadora> transportadora = new HashSet<>();
/*

	@NotNull
	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	private Proprietario proprietario;
	
	
	@ManyToOne
	@JoinColumn(name = "corretor_id")
	private Corretor corretor;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "regiao_id")
	private Regiao regiao;

   
	
    @ManyToMany
    @JoinTable(name = "TB_CARACTERISTICAS_CONDOMINIO_ANUNCIO", 
    joinColumns = @JoinColumn(name = "anuncio_id"),
    inverseJoinColumns = @JoinColumn(name = "caracteristicas_condominio_id")
    )
	private Set<CaracteristicasCondominio> caracteristicasCondominio = new HashSet<>();
    */
	public Motorista() {
		
	}
	
	
	

	public Motorista(@NotEmpty String nomeCompleto, @NotEmpty Long cpf, @NotEmpty String celular, @NotEmpty String email,
		@NotEmpty Long cep, @NotEmpty String logradouro, @NotEmpty int numero, @NotEmpty String estado,
		@NotEmpty String cidade, @NotEmpty String bairro, @NotEmpty Long numeroCnh, String diretorioCnh) {
	super();
	this.nomeCompleto = nomeCompleto;
	this.cpf = cpf;
	this.celular = celular;
	this.email = email;
	this.cep = cep;
	this.logradouro = logradouro;
	this.numero = numero;
	this.estado = estado;
	this.cidade = cidade;
	this.bairro = bairro;
	this.numeroCnh = numeroCnh;
	this.diretorioCnh = diretorioCnh;
}

	
	



	public Set<Transportadora> getTransportadora() {
		return transportadora;
	}




	public String getPlaca() {
		return placa;
	}




	public void setPlaca(String placa) {
		this.placa = placa;
	}




	public void setTransportadora(Set<Transportadora> transportadora) {
		this.transportadora = transportadora;
	}




	public Set<TipoVeiculo> getTipoVeiculo() {
		return tipoVeiculo;
	}




	public void setTipoVeiculo(Set<TipoVeiculo> tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Long getCpf() {
		return cpf;
	}


	public void setCpf(Long cpf) {
		this.cpf = cpf;
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
	public Long getNumeroCnh() {
		return numeroCnh;
	}
	
	public void setNumeroCnh(Long numeroCnh) {
		this.numeroCnh = numeroCnh;
	}




	public String getDiretorioCnh() {
		return diretorioCnh;
	}
	public void setDiretorioCnh(String diretorioCnh) {
		this.diretorioCnh = diretorioCnh;
	}

	
	



	public Set<Regiao> getRegiao() {
		return regiao;
	}




	public void setRegiao(Set<Regiao> regiao) {
		this.regiao = regiao;
	}




	public Boolean getAprovado() {
		return aprovado;
	}




	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}
	
	

	
}
