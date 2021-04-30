package br.ufg.inf.fullstack.model.repositories;

import br.ufg.inf.fullstack.model.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{

	@Query("SELECT m FROM Matricula m WHERE m.idMatricula = :idMatricula")
	public List<Matricula> findByIdMatricula(@Param("idMatricula") Integer id);
}
