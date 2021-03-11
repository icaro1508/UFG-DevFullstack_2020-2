package br.ufg.inf.entities.conta;

import br.ufg.inf.entities.pessoa.Pessoa;
import br.ufg.inf.exceptions.SaldoInsuficienteException;

public abstract class Conta {
	private Pessoa cliente;
	private Integer nrConta;
	private Double saldo;
	
	public Conta(Pessoa cliente, Integer nrConta, Double saldo) {
		this.cliente = cliente;
		this.nrConta = nrConta;
		this.saldo = saldo;
	}
	
	public Pessoa getCliente() {
		return cliente;
	}
	
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	
	public Integer getNrConta() {
		return nrConta;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void sacar(Double valor) throws SaldoInsuficienteException{
		if (!this.temSaldo(valor)) {
			throw new SaldoInsuficienteException("Saldo insuficiente para realizar saque");
		}
		this.saldo -= valor;
	}
	
	protected void debitar(Double valor) {
		this.saldo += valor;
	}
	
	protected boolean temSaldo(Double saldoRequisitado) {
		return this.saldo >= saldoRequisitado;
	}
	
	public void depositar(Double deposito) {
		if (deposito < 0) {
			throw new IllegalArgumentException("Saldo a ser depositado deve ser positivo");
		}
		this.saldo += deposito;
	}
	
	public void transferir(Double valor, Conta contaDestino) throws SaldoInsuficienteException {
		if (!this.temSaldo(valor)) {
			throw new SaldoInsuficienteException("Saldo insuficiente para realizar a transferência");
		}
		contaDestino.depositar(valor);
		this.saldo -= valor;
	}
}
