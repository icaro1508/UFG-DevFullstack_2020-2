package br.ufg.inf.entities.pessoa;

public class PessoaJuridica extends Pessoa {
	
	private String atividade;
	private String cnpj;
	
	public PessoaJuridica(Integer id, String nome, String endereco, String cnpj, String atividade) {
		super(id, nome, endereco);
		this.cnpj = cnpj;
		this.atividade = atividade;
	}
	
	public String getAtividade() {
		return atividade;
	}
	
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
