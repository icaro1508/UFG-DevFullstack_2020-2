package br.ufg.inf.entities.pessoa;

import java.util.Calendar;

public class PessoaFisica extends Pessoa {
	private String cpf;
	private Calendar dtNascimento;
	private String genero;
	
	public PessoaFisica(Integer id, String nome, String endereco, String cpf, Calendar dtNascimento, String genero) {
		super(id, nome, endereco);
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.genero = genero;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Calendar getDtNascimento() {
		return dtNascimento;
	}
	
	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public int getIdade() {
		Calendar agora = Calendar.getInstance();
		int idade = agora.get(Calendar.YEAR) - dtNascimento.get(Calendar.YEAR);
		if (agora.get(Calendar.DAY_OF_YEAR) - this.dtNascimento.get(Calendar.DAY_OF_YEAR) < 0) {
			idade--;
		}
		
		if (idade < 0) {
			throw new IllegalStateException("Data de nascimento no futuro");
		}
		
		return idade;
	}
	
}
