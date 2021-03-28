package br.ufg.inf.aula4.exception;

public class AlunoException extends Exception {
	
	public AlunoException(String message) {
		super(message);
	}
	
	public AlunoException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
