package br.ufg.inf.aula4.negocio;

import br.ufg.inf.aula4.exception.AlunoException;
import br.ufg.inf.aula4.exception.MatriculaException;
import br.ufg.inf.aula4.exception.OfertaExection;
import br.ufg.inf.aula4.model.dao.AlunoDAO;
import br.ufg.inf.aula4.model.dao.MatriculaDAO;
import br.ufg.inf.aula4.model.dao.OfertaDAO;
import br.ufg.inf.aula4.model.entities.Matricula;
import br.ufg.inf.aula4.negocio.base.CRUDNegocio;
import java.util.List;

public class MatriculaNegocio implements CRUDNegocio<Matricula, MatriculaException> {
	MatriculaDAO matriculaDAO = new MatriculaDAO();
	AlunoDAO alunoDAO = new AlunoDAO();
	OfertaDAO ofertaDAO = new OfertaDAO();
	
	@Override
	public Matricula inserir(Matricula novaMatricula) throws MatriculaException {
		validar(novaMatricula);
		return matriculaDAO.inserir(novaMatricula);
	}
	
	@Override
	public List<Matricula> buscaTodos() throws MatriculaException {
		List<Matricula> matriculas = matriculaDAO.buscaTodos();
		
		for (Matricula matricula: matriculas) {
			try {
				matricula.setAluno(alunoDAO.buscaPorId(matricula.getAluno().getIdAluno()));
				matricula.setOferta(ofertaDAO.buscaPorId(matricula.getOferta().getIdOferta()));
			} catch (AlunoException | OfertaExection e) {
				throw new MatriculaException("Falha ao buscar matrícula", e);
			}
		}
		
		return matriculas;
	}
	
	@Override
	public Matricula buscaPorId(Integer id) throws MatriculaException {
		try {
			Matricula matricula = matriculaDAO.buscaPorId(id);
			matricula.setAluno(alunoDAO.buscaPorId(matricula.getAluno().getIdAluno()));
			matricula.setOferta(ofertaDAO.buscaPorId(matricula.getOferta().getIdOferta()));
			return matricula;
		} catch (AlunoException | OfertaExection e) {
			throw new MatriculaException("Falha ao buscar matrícula", e);
		}
	}
	
	@Override
	public Matricula alterar(Matricula matricula) throws MatriculaException {
		validar(matricula);
		return matriculaDAO.alterar(matricula);
	}
	
	@Override
	public void excluir(Integer id) throws MatriculaException {
		matriculaDAO.excluir(id);
	}
	
	private void validar(Matricula matricula) throws MatriculaException {
		if (matricula.getAluno() == null || matricula.getAluno().getIdAluno() == null) {
			throw new MatriculaException("Matricula inválida, aluno é obrigatório");
		}
		
		if(matricula.getOferta() == null || matricula.getOferta().getIdOferta() == null) {
			throw new MatriculaException("Matricula inválida, oferta é obrigatória");
		}
	}
	
}
