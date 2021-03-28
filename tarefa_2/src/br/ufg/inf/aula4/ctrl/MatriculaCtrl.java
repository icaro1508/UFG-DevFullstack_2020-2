package br.ufg.inf.aula4.ctrl;

import br.ufg.inf.aula4.ctrl.api.CRUDController;
import br.ufg.inf.aula4.exception.MatriculaException;
import br.ufg.inf.aula4.model.entities.Matricula;
import br.ufg.inf.aula4.negocio.MatriculaNegocio;
import java.util.List;

public class MatriculaCtrl implements CRUDController<Matricula> {
	
	private final MatriculaNegocio negocio = new MatriculaNegocio();
	
	@Override
	public Matricula inserir(Matricula novaMatricula) {
		try {
			return negocio.inserir(novaMatricula);
		} catch (MatriculaException e) {
			return null;
		}
	}
	
	@Override
	public List<Matricula> buscaTodos() {
		try {
			return negocio.buscaTodos();
		} catch (MatriculaException e) {
			return List.of();
		}
	}
	
	@Override
	public Matricula buscaPorId(Integer id) {
		try {
			return negocio.buscaPorId(id);
		} catch (MatriculaException e) {
			return null;
		}
	}
	
	@Override
	public Matricula alterar(Matricula matricula) {
		try {
			return negocio.alterar(matricula);
		} catch (MatriculaException e) {
			return null;
		}
	}
	
	@Override
	public void excluir(Integer id) {
		try {
			negocio.excluir(id);
		} catch (MatriculaException e) {
			e.printStackTrace();
		}
	}
	
}
