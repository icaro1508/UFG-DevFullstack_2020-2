package br.ufg.inf.aula4.exception;

public class CursoException extends Exception {
	
	public CursoException(String message) {
		super(message);
	}
	
	public CursoException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
