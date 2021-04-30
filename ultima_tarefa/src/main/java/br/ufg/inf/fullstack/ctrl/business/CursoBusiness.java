package br.ufg.inf.fullstack.ctrl.business;

import br.ufg.inf.fullstack.ctrl.exception.CursoException;
import br.ufg.inf.fullstack.model.entities.Curso;
import br.ufg.inf.fullstack.model.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoBusiness {

	@Autowired
	private CursoRepository repository;
	
	public List<Curso> findAll(){
		return repository.findAll();
	}
	
	public Curso findById(Integer id) throws CursoException {
		Optional<Curso> retorno = repository.findById(id);
		if(retorno.isEmpty()) {
			throw new CursoException("0109");
		}
		return retorno.get();
	}
	
	public Curso insert(Curso curso) throws CursoException {
		this.validarCurso(curso);
		return repository.save(curso);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Curso update(Curso curso) throws CursoException {
		this.validarCurso(curso);
		Curso cursoUpd = repository.findById(curso.getIdCurso()).get();
		cursoUpd.setNmCurso(curso.getNmCurso());
		cursoUpd.setIdCurso(curso.getIdCurso());
		return repository.save(cursoUpd);
		
	}
	
	private void validarCurso(Curso curso) throws CursoException {
	
	}
	
}
