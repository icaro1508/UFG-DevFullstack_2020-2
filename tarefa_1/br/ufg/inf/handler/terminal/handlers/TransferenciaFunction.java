package br.ufg.inf.handler.terminal.handlers;

import static br.ufg.inf.handler.terminal.state.TerminalState.HOME;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.handler.terminal.support.FinancialOperationFunction;
import br.ufg.inf.handler.terminal.state.TerminalState;
import java.util.Scanner;

public class TransferenciaFunction implements FinancialOperationFunction {
	
	private Conta getContaDestino() {
		System.out.println("Conta destino: ");
		Scanner scanner = new Scanner(System.in);
		String contaId = scanner.next();
		
		return null;
	}
	
	private Double getValorTransferencia() {
		System.out.println("Valor da transferencia: ");
		Scanner scanner = new Scanner(System.in);
		
		return scanner.nextDouble();
	}
	
	@Override
	public TerminalState apply(Conta conta) {
		Conta contaDestino = this.getContaDestino();
		Double valorTransferencia = this.getValorTransferencia();
		conta.transferir(valorTransferencia, contaDestino);
		
		return HOME;
	}
}
