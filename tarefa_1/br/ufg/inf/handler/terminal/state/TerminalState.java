package br.ufg.inf.handler.terminal.state;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.handler.terminal.handlers.AbrirContaFunction;
import br.ufg.inf.handler.terminal.handlers.CadastroClienteFunction;
import br.ufg.inf.handler.terminal.handlers.DepositoFunction;
import br.ufg.inf.handler.terminal.handlers.HomeFunction;
import br.ufg.inf.handler.terminal.handlers.RelatoriosFunction;
import br.ufg.inf.handler.terminal.handlers.SaldoFunction;
import br.ufg.inf.handler.terminal.handlers.SaqueFunction;
import br.ufg.inf.handler.terminal.handlers.SelecionarContaFunction;
import br.ufg.inf.handler.terminal.handlers.TransferenciaFunction;
import br.ufg.inf.handler.terminal.handlers.relatorios.RelatorioSaldoContasFunction;
import br.ufg.inf.handler.terminal.handlers.relatorios.RelatorioTotalContasFunction;
import br.ufg.inf.handler.terminal.support.FinancialOperationFunction;

public enum TerminalState {
	HOME(new HomeFunction()),
	ABRIR_CONTA(new AbrirContaFunction()),
	SELECIONAR_CONTA(new SelecionarContaFunction()),
	CADASTRAR_CLIENTE(new CadastroClienteFunction()),
	RELATORIOS(new RelatoriosFunction()),
	SAIR(c -> {
		System.exit(0);
		return null;
	}),
	ALTERAR_CONTA(c -> SELECIONAR_CONTA, true),
	DEPOSITO(new DepositoFunction(), true),
	SAQUE(new SaqueFunction(), true),
	TRANSFERENCIA(new TransferenciaFunction(), true),
	SALDO(new SaldoFunction(), true),
	RETORNAR(c -> HOME),
	SALDO_CONTAS(new RelatorioSaldoContasFunction()),
	TOTAL_CONTAS(new RelatorioTotalContasFunction());
	
	private final FinancialOperationFunction handler;
	private final Boolean precisaDeConta;
	
	TerminalState(FinancialOperationFunction handler) {
		this.handler = handler;
		this.precisaDeConta = false;
	}
	
	TerminalState(FinancialOperationFunction handler, Boolean precisaDeConta) {
		this.handler = handler;
		this.precisaDeConta = precisaDeConta;
	}
	
	public TerminalState handle(Conta contaAtual) {
		System.out.println(this.handler.getClass().getCanonicalName());
		return this.handler.apply(contaAtual);
	}
	
	public Boolean getPrecisaDeConta() {
		return precisaDeConta;
	}
}