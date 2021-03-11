package br.ufg.inf;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.entities.conta.ContaEspecial;
import br.ufg.inf.entities.conta.ContaPoupanca;
import br.ufg.inf.entities.pessoa.PessoaFisica;
import br.ufg.inf.entities.pessoa.PessoaJuridica;
import br.ufg.inf.exceptions.SaldoInsuficienteException;
import java.util.Calendar;

public class Main {
	
	public static void main(String[] args) throws SaldoInsuficienteException {
		Calendar dtNasicmento = Calendar.getInstance();
		dtNasicmento.set(1995, 8, 15);
		PessoaFisica icaro = new PessoaFisica(0,"Icaro", "Rua A", "00000000000", dtNasicmento, "M");
		PessoaJuridica outback = new PessoaJuridica(1,"Outback", "Rua B", "00000000000000", "Restaurante");
		
		ContaEspecial ceIcaro = new ContaEspecial(icaro,1, 1_000.0, 100.0);
		ContaPoupanca cpIcaro = new ContaPoupanca(icaro, 2, 1_000.0, 0.05);
		
		ContaEspecial ceOutback = new ContaEspecial(outback, 3, 1_000_000.0, 10_000.0);
		
		ceIcaro.transferir(100.0, ceOutback);
		System.out.println("Saldo Outback: " + ceOutback.getSaldo());
		System.out.println("Saldo Icaro: " + ceIcaro.getSaldo());
		
		ceIcaro.transferir(1_000.0, cpIcaro);
		System.out.println("Saldo Icaro: " + ceIcaro.getSaldo());
		System.out.println("Saldo Icaro Poupanca: " + cpIcaro.getSaldo());
		
		System.out.println("Idade Icaro: " + icaro.getIdade());
		
		ceIcaro.transferir(1_000_000.0, ceOutback);
		
	}
}
