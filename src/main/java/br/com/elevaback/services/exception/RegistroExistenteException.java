package br.com.elevaback.services.exception;

public class RegistroExistenteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RegistroExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public RegistroExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
