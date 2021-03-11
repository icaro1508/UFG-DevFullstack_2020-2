package br.ufg.inf.entities.conta;

import br.ufg.inf.entities.pessoa.Pessoa;
import br.ufg.inf.exceptions.SaldoInsuficienteException;

public class ContaEspecial extends Conta {
	
	private Double limite;
	
	public ContaEspecial(Pessoa cliente, Integer nrConta, Double saldo, Double limite) {
		super(cliente, nrConta, saldo);
		this.limite = limite;
	}
	
	public Double getLimite() {
		return limite;
	}
	
	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	@Override
	protected boolean temSaldo(Double saldoRequisitado) {
		Double saldoFinal = this.getSaldo() - saldoRequisitado;
		if (saldoFinal < -limite) {
			return false;
		}
		return true;
	}
	
}
