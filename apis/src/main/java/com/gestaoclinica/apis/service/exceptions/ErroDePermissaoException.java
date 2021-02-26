package com.gestaoclinica.apis.service.exceptions;

public class ErroDePermissaoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ErroDePermissaoException (String msg) {
		super (msg);
	}
}
