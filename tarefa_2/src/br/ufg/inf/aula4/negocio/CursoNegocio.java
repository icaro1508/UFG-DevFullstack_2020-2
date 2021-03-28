package br.ufg.inf.aula4.negocio;

import br.ufg.inf.aula4.exception.CursoException;
import br.ufg.inf.aula4.model.dao.CursoDAO;
import br.ufg.inf.aula4.model.entities.Curso;
import br.ufg.inf.aula4.negocio.base.CRUDNegocio;
import java.util.List;

public class CursoNegocio implements CRUDNegocio<Curso, CursoException> {
	CursoDAO cursoDAO = new CursoDAO();
	
	@Override
	public Curso inserir(Curso novoCurso) throws CursoException {
		validar(novoCurso);
		return cursoDAO.inserir(novoCurso);
	}
	
	@Override
	public List<Curso> buscaTodos() throws CursoException {
		return cursoDAO.buscaTodos();
	}
	
	@Override
	public Curso buscaPorId(Integer id) throws CursoException {
		return cursoDAO.buscaPorId(id);
	}
	
	@Override
	public Curso alterar(Curso curso) throws CursoException {
		validar(curso);
		return cursoDAO.alterar(curso);
	}
	
	@Override
	public void excluir(Integer id) throws CursoException {
		cursoDAO.excluir(id);
	}
	
	private void validar(Curso curso) throws CursoException {
		if (curso.getNmCurso().isBlank() || curso.getNmCurso() == null) {
			throw new CursoException("Curso deve ter um nome");
		}
	}
	
}
