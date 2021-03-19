package br.ufg.inf.handler.terminal.handlers;

import static br.ufg.inf.handler.terminal.state.TerminalState.ABRIR_CONTA;
import static br.ufg.inf.handler.terminal.state.TerminalState.CADASTRAR_CLIENTE;
import static br.ufg.inf.handler.terminal.state.TerminalState.HOME;
import static br.ufg.inf.handler.terminal.state.TerminalState.RELATORIOS;
import static br.ufg.inf.handler.terminal.state.TerminalState.SAIR;
import static br.ufg.inf.handler.terminal.state.TerminalState.SELECIONAR_CONTA;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.handler.terminal.support.FinancialOperationFunction;
import br.ufg.inf.handler.terminal.state.TerminalState;
import java.util.Scanner;

public class HomeFunction implements FinancialOperationFunction {
	
	private void printMenu() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. Abrir Nova Conta\n");
		builder.append("2. Selecionar Conta\n");
		builder.append("3. Cadastrar Cliente\n");
		builder.append("4. Relatórios\n");
		builder.append("5. Sair\n");
		System.out.println(builder);
	}
	@Override
	public TerminalState apply(Conta conta) {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		
		int nextState = scanner.nextInt();
		switch (nextState) {
			case 1:
				return ABRIR_CONTA;
			case 2:
				return SELECIONAR_CONTA;
			case 3:
				return CADASTRAR_CLIENTE;
			case 4:
				return RELATORIOS;
			case 5:
				return SAIR;
			default:
				return HOME;
		}
	}
}
