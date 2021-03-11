package br.ufg.inf.entities.conta;

import br.ufg.inf.entities.pessoa.Pessoa;

public class ContaPoupanca extends Conta{
	
	private Double txCorrecao;
	
	public ContaPoupanca(Pessoa cliente, Integer nrConta, Double saldo, Double txCorrecao) {
		super(cliente, nrConta, saldo);
		this.txCorrecao = txCorrecao;
	}
	
	public Double getTxCorrecao() {
		return txCorrecao;
	}
	
	public void setTxCorrecao(Double txCorrecao) {
		this.txCorrecao = txCorrecao;
	}
	
	public void atualizaSaldoRendimento() {
		this.depositar(this.getSaldo() * this.txCorrecao);
	}
}
