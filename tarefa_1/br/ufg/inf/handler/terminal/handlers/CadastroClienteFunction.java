package br.ufg.inf.handler.terminal.handlers;

import static br.ufg.inf.handler.terminal.state.TerminalState.HOME;

import br.ufg.inf.entities.conta.Conta;
import br.ufg.inf.entities.pessoa.Pessoa;
import br.ufg.inf.entities.pessoa.PessoaFisica;
import br.ufg.inf.entities.pessoa.PessoaJuridica;
import br.ufg.inf.handler.terminal.support.FinancialOperationFunction;
import br.ufg.inf.handler.terminal.state.TerminalState;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CadastroClienteFunction implements FinancialOperationFunction {
	@Override
	public TerminalState apply(Conta conta) {
		cadastrarCliente();
		return HOME;
	}
	
	private void cadastrarCliente() {
		Scanner scanner = new Scanner(System.in);
		printTiposPessoa();
		int tipoPessoa = scanner.nextInt();
		switch (tipoPessoa) {
			case 1:
				cadastrarPessoaFisica();
				return;
			case 2:
				cadastrarPessoaJuridica();
				return;
			default:
				System.out.println("Tipo de conta inválido!");
				cadastrarCliente();
		}
	}
	
	private void printTiposPessoa() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. Pessoa Física\n");
		builder.append("2. Pessoa Jurídica\n");
		System.out.println(builder);
	}
	
	private Integer proximoPessoaId() {
		return 1;
	}
	
	private PessoaJuridica cadastrarPessoaJuridica() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome: ");
		String nome = scanner.next();
		System.out.println("Endereço: ");
		String endereco = scanner.next();
		System.out.println("CNPJ: ");
		String cnpj = scanner.next();
		System.out.println("Atividade:");
		String atividade = scanner.next();
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica(proximoPessoaId(), nome, endereco, cnpj, atividade);
		salvarPessoa(pessoaJuridica);
		return pessoaJuridica;
	}
	
	private PessoaFisica cadastrarPessoaFisica() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome:");
		String nome = scanner.next();
		System.out.println("Endereço:");
		String endereco = scanner.next();
		System.out.println("CPF:");
		String cpf = scanner.next();
		Calendar dataNascimento = buscaDataNascimento();
		System.out.println("Gênero:");
		String genero = scanner.next();
		
		PessoaFisica pessoaFisica = new PessoaFisica(proximoPessoaId(), nome, endereco, cpf, dataNascimento, genero);
		salvarPessoa(pessoaFisica);
		return pessoaFisica;
	}
	
	private Calendar buscaDataNascimento() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Data Nascimento (dd/mm/aaaa):");

		int tentativas = 0;
		while (tentativas < 5) {
			try {
				SimpleDateFormat formattter = new SimpleDateFormat("dd/MM/yyyy");
				Date dtNascimento = formattter.parse(scanner.next());
				Calendar dtNascimentoCalendar = Calendar.getInstance();
				dtNascimentoCalendar.setTime(dtNascimento);
				return dtNascimentoCalendar;
			} catch (ParseException e) {
				System.out.println("Formato inválido! esperado dd/mm/aaaa, tente novamente!");
			} finally {
				tentativas++;
			}
		}
		
		throw new IllegalArgumentException("Tentativas esgotadas");
	}
	
	private void salvarPessoa(Pessoa novoCliente) {
	
	}
}
