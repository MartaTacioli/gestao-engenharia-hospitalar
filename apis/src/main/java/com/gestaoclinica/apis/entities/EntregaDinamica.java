package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "TB_ENTREGA_DINAMICA")
public class EntregaDinamica implements Serializable{
	private static long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@NotNull
	private Long cnpjTransportadora;
	private Long cpfMotorista;
	@NotNull
	private String statusEntrega;
	@NotEmpty
	private String filial;
	@NotNull
	private double valorCorrida;
	@NotNull
	private boolean valorCorridaReajustado;
	@NotNull	
	private double previsaoKilometragem;

	private String dataSaida ;
	private String dataPrevisaoEntregaFinalizada;
	
	private String dataPrevisaoChegadaMotorista;
	@NotNull
	private String dataEntregaFinalizada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());	
	
	private String dataChegadaMotorista;	
	
	 @ManyToMany
	    @JoinTable(name = "TB_ENTREGA_DINAMICA_NOTAS", 
	    joinColumns = @JoinColumn(name = "entregaDinamica_id"),
	    inverseJoinColumns = @JoinColumn(name = "notas_id")
	    )
		private Set<Notas> notas = new HashSet<>();

	public EntregaDinamica() {
	
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCnpjTransportadora() {
		return cnpjTransportadora;
	}

	public void setCnpjTransportadora(Long cnpjTransportadora) {
		this.cnpjTransportadora = cnpjTransportadora;
	}

	public Long getCpfMotorista() {
		return cpfMotorista;
	}

	public void setCpfMotorista(Long cpfMotorista) {
		this.cpfMotorista = cpfMotorista;
	}

	public String getStatusEntrega() {
		return statusEntrega;
	}
	

	public boolean isValorCorridaReajustado() {
		return valorCorridaReajustado;
	}

	public void setValorCorridaReajustado(boolean valorCorridaReajustado) {
		this.valorCorridaReajustado = valorCorridaReajustado;
	}

	public void setStatusEntrega(String statusEntrega) {
		this.statusEntrega = statusEntrega;
	}



	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public double getValorCorrida() {
		return valorCorrida;
	}

	public void setValorCorrida(double valorCorrida) {
		this.valorCorrida = valorCorrida;
	}

	public double getPrevisaoKilometragem() {
		return previsaoKilometragem;
	}

	public void setPrevisaoKilometragem(double previsaoKilometragem) {
		this.previsaoKilometragem = previsaoKilometragem;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getDataPrevisaoEntregaFinalizada() {
		return dataPrevisaoEntregaFinalizada;
	}

	public void setDataPrevisaoEntregaFinalizada(String dataPrevisaoEntregaFinalizada) {
		this.dataPrevisaoEntregaFinalizada = dataPrevisaoEntregaFinalizada;
	}

	public String getDataPrevisaoChegadaMotorista() {
		return dataPrevisaoChegadaMotorista;
	}

	public void setDataPrevisaoChegadaMotorista(String dataPrevisaoChegadaMotorista) {
		this.dataPrevisaoChegadaMotorista = dataPrevisaoChegadaMotorista;
	}

	public String getDataEntregaFinalizada() {
		return dataEntregaFinalizada;
	}

	public void setDataEntregaFinalizada(String dataEntregaFinalizada) {
		this.dataEntregaFinalizada = dataEntregaFinalizada;
	}

	public String getDataChegadaMotorista() {
		return dataChegadaMotorista;
	}

	public void setDataChegadaMotorista(String dataChegadaMotorista) {
		this.dataChegadaMotorista = dataChegadaMotorista;
	}

	public Set<Notas> getNotas() {
		return notas;
	}

	public void setNotas(Set<Notas> notas) {
		this.notas = notas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

	
}
