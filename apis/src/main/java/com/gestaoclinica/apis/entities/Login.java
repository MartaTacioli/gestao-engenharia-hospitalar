package com.gestaoclinica.apis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "TB_LOGIN")

public class Login implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	
	private String senha;

	private int aprovado;
	
 

	@JsonIgnore
	@OneToOne
	@MapsId
	private Transportadora transportadora;
	
	

	
	/*public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuths;
		if (this.aprovado == 10) {
			grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN");
		} else if (this.aprovado == 3 ){
			grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList("FORBIDEN");
		} else {
			grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList("USER");
		}
		return grantedAuths;
        }
       
	public void setAuthorities() {
		if (this.aprovado == 10) {
			this.grantedAuths = (new SimpleGrantedAuthority("ROLE_USER"));
		} else if (this.aprovado == 3 ){
			this.grantedAuths = (new SimpleGrantedAuthority("ROLE_USER"));
		} else {
			this.grantedAuths = (new SimpleGrantedAuthority("ROLE_USER"));
		}
        } */
	

	public Login () {
		
	}
	
	public Login(String senha, int aprovado, Transportadora transportadora) {
		super();
		this.senha = senha;
		this.aprovado = aprovado;
		this.transportadora = transportadora;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	public int getAprovado() {
		return aprovado;
	}

	public void setAprovado(int aprovado) {
		this.aprovado = aprovado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Login other = (Login) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

}
