package br.ufg.inf.handler.terminal.state;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.entities.conta.ContaEspecial;
import br.ufg.inf.entities.pessoa.PessoaFisica;
import br.ufg.inf.handler.terminal.state.TerminalState;
import java.util.Calendar;

public class StateMachine {
	private TerminalState currentState = TerminalState.HOME;
	private Conta contaAtual;
	
	public void nextState() {
		if (currentState.getPrecisaDeConta()) {
			System.out.println("Selecionar conta");
			contaAtual = getConta();
		}
		currentState = currentState.handle(contaAtual);
	}
	
	private Conta getConta() {
		Calendar dtNasicmento = Calendar.getInstance();
		dtNasicmento.set(1995, 8, 15);
		PessoaFisica icaro = new PessoaFisica(0,"Icaro", "Rua A", "00000000000", dtNasicmento, "M");
		
		ContaEspecial ceIcaro = new ContaEspecial(icaro,1, 1_000.0, 100.0);
		return ceIcaro;
	}
}
