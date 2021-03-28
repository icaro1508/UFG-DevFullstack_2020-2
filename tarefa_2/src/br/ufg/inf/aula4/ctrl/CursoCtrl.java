package br.ufg.inf.aula4.ctrl;

import br.ufg.inf.aula4.exception.CursoException;
import br.ufg.inf.aula4.model.entities.Curso;
import br.ufg.inf.aula4.negocio.CursoNegocio;
import java.util.List;

public class CursoCtrl {
	private final CursoNegocio negocio = new CursoNegocio();
	public Curso inserir(Curso curso) {
		try {
			curso = negocio.inserir(curso);
			System.out.println("Curso cadastrada com sucesso: " + curso);
		} catch (CursoException e) {
			System.out.println("Erro ao tentar cadastrar curso.");
			System.out.println(e.getMessage());
		}
		return curso;
	}
	
	public List<Curso> buscaTodos() {
		List<Curso> cursos = null;
		try {
			cursos = negocio.buscaTodos();
		} catch (CursoException e) {
			e.printStackTrace();
		}
		return cursos;
	}
	
	public Curso buscaPorId(Integer id) {
		Curso curso = null;
		try {
			curso = negocio.buscaPorId(id);
		} catch (CursoException e) {
			System.out.println("Erro tentar buscar curso do ID: " + id + ".");
			System.out.println(e.getMessage());
		}
		return curso;
	}
	
	public Curso alterar(Curso curso) {
		try {
			curso = negocio.alterar(curso);
			System.out.println("Curso alterado com sucesso: " + curso);
		} catch (CursoException e) {
			System.out.println("Erro ao tentar alterar curso com ID: " + curso.getIdCurso() + ".");
			System.out.println(e.getMessage());
		}
		return curso;
	}
	
	public void excluir(Integer id) {
		try {
			negocio.excluir(id);
			System.out.println("Curso excluído com sucesso.");
		} catch (CursoException e) {
			System.out.println("Erro ao tentar excluir o curso");
			System.out.println(e.getMessage());
		}
	}
}
