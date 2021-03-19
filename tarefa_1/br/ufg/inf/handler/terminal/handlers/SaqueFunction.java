package br.ufg.inf.handler.terminal.handlers;

import static br.ufg.inf.handler.terminal.state.TerminalState.HOME;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.handler.terminal.support.FinancialOperationFunction;
import br.ufg.inf.handler.terminal.state.TerminalState;
import java.util.Scanner;

public class SaqueFunction implements FinancialOperationFunction {
	private Double getValorSaque() {
		System.out.println("Valor do saque: ");
		Scanner scanner = new Scanner(System.in);
		
		return scanner.nextDouble();
	}
	
	@Override
	public TerminalState apply(Conta conta) {
		Double valorSaque = this.getValorSaque();
		conta.sacar(valorSaque);
		return HOME;
	}
}
