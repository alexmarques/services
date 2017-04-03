package br.com.questao01.exception;

@SuppressWarnings("serial")
public class CEPInvalidoException extends RuntimeException {
	
	private String message;

	public CEPInvalidoException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}