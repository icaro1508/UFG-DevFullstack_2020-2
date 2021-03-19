package br.ufg.inf;

import br.ufg.inf.exceptions.SaldoInsuficienteException;
import br.ufg.inf.handler.terminal.state.StateMachine;

public class Main {
	
	public static void main(String[] args) throws SaldoInsuficienteException {
		Main.startApplication();
	}
	
	public static void startApplication() {
		StateMachine stateMachine = new StateMachine();
		while (true) {
			stateMachine.nextState();
		}
	}
}
