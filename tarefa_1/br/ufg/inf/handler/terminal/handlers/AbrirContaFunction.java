package br.ufg.inf.handler.terminal.handlers;

import static br.ufg.inf.handler.terminal.state.TerminalState.HOME;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.entities.conta.ContaEspecial;
import br.ufg.inf.entities.conta.ContaPoupanca;
import br.ufg.inf.entities.pessoa.Pessoa;
import br.ufg.inf.handler.terminal.support.FinancialOperationFunction;
import br.ufg.inf.handler.terminal.state.TerminalState;
import java.util.Scanner;

public class AbrirContaFunction implements FinancialOperationFunction {
	@Override
	public TerminalState apply(Conta conta) {
		abrirConta();
		return HOME;
	}
	
	private void abrirConta() {
		Scanner scanner = new Scanner(System.in);
		printTiposConta();
		int tipoConta = scanner.nextInt();
		switch (tipoConta) {
			case 1:
				abrirContaEspecial();
				return;
			case 2:
				abrirContaPoupanca();
				return;
			default:
				System.out.println("Tipo de conta inválido!");
				abrirConta();
		}
	}
	
	private void printTiposConta() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. Conta Especial\n");
		builder.append("2. Conta Poupança\n");
		System.out.println(builder);
	}
	
	private Pessoa buscarPessoa() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Identificador Pessoa: ");
		return null;
	}
	
	private Integer proximoNumConta() {
		return 1;
	}
	
	private ContaPoupanca abrirContaPoupanca() {
		ContaPoupanca contaPoupanca = new ContaPoupanca(buscarPessoa(), proximoNumConta(), 0.0, 0.05);
		salvarConta(contaPoupanca);
		return contaPoupanca;
	}
	
	private ContaEspecial abrirContaEspecial() {
		ContaEspecial contaEspecial = new ContaEspecial(buscarPessoa(), proximoNumConta(), 0.0, 500.0);
		salvarConta(contaEspecial);
		return contaEspecial;
	}
	
	private void salvarConta(Conta novaConta) {
	
	}
}
