package br.ufg.inf.aula4.negocio;

import br.ufg.inf.aula4.exception.AlunoException;
import br.ufg.inf.aula4.exception.CursoException;
import br.ufg.inf.aula4.exception.PessoaExection;
import br.ufg.inf.aula4.model.dao.AlunoDAO;
import br.ufg.inf.aula4.model.dao.CursoDAO;
import br.ufg.inf.aula4.model.dao.PessoaDAO;
import br.ufg.inf.aula4.model.entities.Aluno;
import br.ufg.inf.aula4.negocio.base.CRUDNegocio;
import java.util.Date;
import java.util.List;

public class AlunoNegocio implements CRUDNegocio<Aluno, AlunoException> {
	
	AlunoDAO alunoDAO = new AlunoDAO();
	CursoDAO cursoDAO = new CursoDAO();
	PessoaDAO pessoaDAO = new PessoaDAO();
	
	@Override
	public Aluno inserir(Aluno novaAluno) throws AlunoException {
		validar(novaAluno);
		return alunoDAO.inserir(novaAluno);
	}
	
	@Override
	public List<Aluno> buscaTodos() throws AlunoException {
		List<Aluno> alunos = alunoDAO.buscaTodos();
		
		for (Aluno aluno : alunos) {
			buscarRelacionamentosAluno(aluno);
		}
		
		return alunos;
	}
	
	@Override
	public Aluno buscaPorId(Integer id) throws AlunoException {
		Aluno aluno = alunoDAO.buscaPorId(id);
		return buscarRelacionamentosAluno(aluno);
	}
	
	@Override
	public Aluno alterar(Aluno aluno) throws AlunoException {
		validar(aluno);
		return alunoDAO.alterar(aluno);
	}
	
	@Override
	public void excluir(Integer id) throws AlunoException {
		alunoDAO.excluir(id);
	}
	
	private void validar(Aluno aluno) throws AlunoException {
		if (aluno.getPessoa() == null) {
			throw new AlunoException("É necessário vincular uma pessoa a um aluno");
		}
		
		if (aluno.getCurso() == null) {
			throw new AlunoException("Aluno deve ser vinculado a um curso");
		}
	}
	
	private Aluno buscarRelacionamentosAluno(Aluno aluno) throws AlunoException {
		
		try {
			aluno.setCurso(cursoDAO.buscaPorId(aluno.getCurso().getIdCurso()));
			aluno.setPessoa(pessoaDAO.buscaPorId(aluno.getPessoa().getIdPessoa()));
			
			return aluno;
		} catch (CursoException | PessoaExection e) {
			throw new AlunoException("Falha ao buscar aluno", e);
		}
	}
	
}
