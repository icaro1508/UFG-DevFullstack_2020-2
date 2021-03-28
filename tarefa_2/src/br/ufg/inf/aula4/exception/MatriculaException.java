package br.ufg.inf.aula4.exception;

public class MatriculaException extends Exception {
	
	public MatriculaException(String message) {
		super(message);
	}
	
	public MatriculaException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
