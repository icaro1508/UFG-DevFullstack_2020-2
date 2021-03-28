package br.ufg.inf.aula4.ctrl;

import br.ufg.inf.aula4.ctrl.api.CRUDController;
import br.ufg.inf.aula4.exception.AlunoException;
import br.ufg.inf.aula4.model.entities.Aluno;
import br.ufg.inf.aula4.negocio.AlunoNegocio;
import java.util.List;

public class AlunoCtrl implements CRUDController<Aluno> {
	
	private final AlunoNegocio negocio = new AlunoNegocio();
	
	public Aluno inserir(Aluno aluno) {
		try {
			aluno = negocio.inserir(aluno);
			System.out.println("Aluno cadastrada com sucesso: " + aluno);
		} catch (AlunoException e) {
			System.out.println("Erro ao tentar cadastrar aluno.");
			System.out.println(e.getMessage());
		}
		return aluno;
	}
	
	public List<Aluno> buscaTodos() {
		List<Aluno> alunos = null;
		try {
			alunos = negocio.buscaTodos();
		} catch (AlunoException e) {
			System.out.println("Erro tentar buscar as alunos cadastrados.");
			System.out.println(e.getMessage());
		}
		return alunos;
	}
	
	public Aluno buscaPorId(Integer id) {
		Aluno aluno = null;
		try {
			aluno = negocio.buscaPorId(id);
		} catch (AlunoException e) {
			System.out.println("Erro tentar buscar aluno do ID: " + id + ".");
			System.out.println(e.getMessage());
		}
		return aluno;
	}
	
	public Aluno alterar(Aluno aluno) {
		try {
			aluno = negocio.alterar(aluno);
			System.out.println("Aluno alterado com sucesso: " + aluno);
		} catch (AlunoException e) {
			System.out.println("Erro ao tentar alterar aluno com ID: " + aluno.getIdAluno() + ".");
			System.out.println(e.getMessage());
		}
		return aluno;
	}
	
	public void excluir(Integer id) {
		try {
			negocio.excluir(id);
			System.out.println("Aluno excluído com sucesso.");
		} catch (AlunoException e) {
			System.out.println("Erro ao tentar excluir o aluno");
			System.out.println(e.getMessage());
		}
	}
	
}
