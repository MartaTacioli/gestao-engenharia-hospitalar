package com.gestaoclinica.apis.entities;

public interface EntregaDinamicaLista{
	Long id();
	Long cnpjTransportadora();
	Long cpfMotorista();
	String statusEntrega();
	Filial filial();
	double valorCorrida();
	boolean valorCorridaReajustado();
	double previsaoKilometragem();

}
