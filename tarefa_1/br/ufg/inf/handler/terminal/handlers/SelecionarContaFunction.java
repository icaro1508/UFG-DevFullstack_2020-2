package br.ufg.inf.handler.terminal.handlers;

import static br.ufg.inf.handler.terminal.state.TerminalState.ALTERAR_CONTA;
import static br.ufg.inf.handler.terminal.state.TerminalState.DEPOSITO;
import static br.ufg.inf.handler.terminal.state.TerminalState.RETORNAR;
import static br.ufg.inf.handler.terminal.state.TerminalState.SALDO;
import static br.ufg.inf.handler.terminal.state.TerminalState.SAQUE;
import static br.ufg.inf.handler.terminal.state.TerminalState.SELECIONAR_CONTA;
import static br.ufg.inf.handler.terminal.state.TerminalState.TRANSFERENCIA;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.handler.terminal.support.FinancialOperationFunction;
import br.ufg.inf.handler.terminal.state.TerminalState;
import java.util.Scanner;

public class SelecionarContaFunction implements FinancialOperationFunction {
	
	private void printMenu() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. Alterar Conta\n");
		builder.append("2. Deposito\n");
		builder.append("3. Saque\n");
		builder.append("4. Transferência\n");
		builder.append("5. Saldo\n");
		builder.append("6. Retornar\n");
		System.out.println(builder);
	}
	
	@Override
	public TerminalState apply(Conta conta) {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		
		int nextState = scanner.nextInt();
		switch (nextState) {
			case 1:
				return ALTERAR_CONTA;
			case 2:
				return DEPOSITO;
			case 3:
				return SAQUE;
			case 4:
				return TRANSFERENCIA;
			case 5:
				return SALDO;
			case 6:
				return RETORNAR;
			default:
				System.out.println("Operação não suportada!");
				return SELECIONAR_CONTA;
		}
	}
}
