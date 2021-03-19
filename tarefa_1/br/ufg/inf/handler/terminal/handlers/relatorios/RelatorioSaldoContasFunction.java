package br.ufg.inf.handler.terminal.handlers.relatorios;

import static br.ufg.inf.handler.terminal.state.TerminalState.HOME;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.handler.terminal.support.FinancialOperationFunction;
import br.ufg.inf.handler.terminal.state.TerminalState;

public class RelatorioSaldoContasFunction implements FinancialOperationFunction {
	@Override
	public TerminalState apply(Conta conta) {
		return HOME;
	}
}
