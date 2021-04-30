package br.ufg.inf.fullstack.model.repositories;

import br.ufg.inf.fullstack.model.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

	@Query("SELECT a FROM Aluno a WHERE a.pessoa.nmPessoa LIKE %:name%")
	public List<Aluno> findByNmAluno(@Param("name") String name);
}
