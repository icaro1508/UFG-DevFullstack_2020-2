package br.ufg.inf.fullstack.model.repositories;

import br.ufg.inf.fullstack.model.entities.Curso;
import br.ufg.inf.fullstack.model.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

	@Query("SELECT d FROM Disciplina d WHERE d.nmDisciplina LIKE %:name%")
	public List<Curso> findByNmDisciplina(@Param("name") String name);
}
