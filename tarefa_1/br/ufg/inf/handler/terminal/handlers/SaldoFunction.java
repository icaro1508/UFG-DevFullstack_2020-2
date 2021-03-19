package br.ufg.inf.handler.terminal.handlers;

import static br.ufg.inf.handler.terminal.state.TerminalState.HOME;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.entities.conta.ContaEspecial;
import br.ufg.inf.handler.terminal.support.FinancialOperationFunction;
import br.ufg.inf.handler.terminal.state.TerminalState;

public class SaldoFunction implements FinancialOperationFunction {
	@Override
	public TerminalState apply(Conta conta) {
		System.out.println("Saldo: " + conta.getSaldo());
		if (conta instanceof ContaEspecial) {
			System.out.println("Limite: " + ((ContaEspecial) conta).getLimite());
		}
		
		return HOME;
	}
}
