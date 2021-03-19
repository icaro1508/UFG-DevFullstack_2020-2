package br.ufg.inf.handler.terminal.support;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.handler.terminal.state.TerminalState;
import java.util.function.Function;

@FunctionalInterface
public interface FinancialOperationFunction extends Function<Conta, TerminalState> {
}
