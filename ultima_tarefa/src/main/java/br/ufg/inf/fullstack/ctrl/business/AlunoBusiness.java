package br.ufg.inf.fullstack.ctrl.business;

import br.ufg.inf.fullstack.ctrl.exception.AlunoException;
import br.ufg.inf.fullstack.model.entities.Aluno;
import br.ufg.inf.fullstack.model.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoBusiness {

	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> findAll(){
		return repository.findAll();
	}
	
	public Aluno findById(Integer id) throws AlunoException {
		Optional<Aluno> retorno = repository.findById(id);
		if(retorno.isEmpty()) {
			throw new AlunoException("0109");
		}
		return retorno.get();
	}
	
	public List<Aluno> findByNmAluno(String str){
		return repository.findByNmAluno(str);
	}
	
	public Aluno insert(Aluno aluno) throws AlunoException {
		this.validarAluno(aluno);
		return repository.save(aluno);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Aluno update(Aluno aluno) throws AlunoException {
		this.validarAluno(aluno);
		Aluno alunoUpd = repository.findById(aluno.getIdAluno()).get();
		alunoUpd.setAtivo(aluno.getAtivo());
		alunoUpd.setCurso(aluno.getCurso());
		alunoUpd.setDtInicio(aluno.getDtInicio());
		alunoUpd.setIdAluno(aluno.getIdAluno());
		alunoUpd.setPessoa(aluno.getPessoa());
		return repository.save(alunoUpd);
		
	}
	
	private void validarAluno(Aluno aluno) throws AlunoException {

	}
	
}
