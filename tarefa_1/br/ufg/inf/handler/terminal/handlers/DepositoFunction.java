package br.ufg.inf.handler.terminal.handlers;

import static br.ufg.inf.handler.terminal.state.TerminalState.HOME;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.handler.terminal.support.FinancialOperationFunction;
import br.ufg.inf.handler.terminal.state.TerminalState;
import java.util.Scanner;

public class DepositoFunction implements FinancialOperationFunction {
	private Double getValorDeposito() {
		System.out.println("Valor do deposito: ");
		Scanner scanner = new Scanner(System.in);
		
		return scanner.nextDouble();
	}
	
	@Override
	public TerminalState apply(Conta conta) {
		Double valorDeposito = this.getValorDeposito();
		conta.depositar(valorDeposito);
		return HOME;
	}
}
