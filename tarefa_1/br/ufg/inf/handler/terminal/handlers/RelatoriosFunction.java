package br.ufg.inf.handler.terminal.handlers;

import static br.ufg.inf.handler.terminal.state.TerminalState.SALDO_CONTAS;
import static br.ufg.inf.handler.terminal.state.TerminalState.SELECIONAR_CONTA;
import static br.ufg.inf.handler.terminal.state.TerminalState.TOTAL_CONTAS;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.handler.terminal.support.FinancialOperationFunction;
import br.ufg.inf.handler.terminal.state.TerminalState;
import java.util.Scanner;

public class RelatoriosFunction implements FinancialOperationFunction {
	
	private void printMenu() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. Saldo das Contas\n");
		builder.append("2. Total das Contas\n");
		System.out.println(builder);
	}
	@Override
	public TerminalState apply(Conta conta) {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		
		int nextState = scanner.nextInt();
		switch (nextState) {
			case 1:
				return SALDO_CONTAS;
			case 2:
				return TOTAL_CONTAS;
			default:
				System.out.println("Operação não suportada!");
				return SELECIONAR_CONTA;
		}
	}
}
