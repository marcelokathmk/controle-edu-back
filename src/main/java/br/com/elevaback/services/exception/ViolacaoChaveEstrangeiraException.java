package br.com.elevaback.services.exception;

public class ViolacaoChaveEstrangeiraException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ViolacaoChaveEstrangeiraException(String mensagem) {
		super(mensagem);
	}
	
	public ViolacaoChaveEstrangeiraException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
