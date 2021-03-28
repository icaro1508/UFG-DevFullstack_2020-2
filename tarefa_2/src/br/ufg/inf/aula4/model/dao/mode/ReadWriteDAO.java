package br.ufg.inf.aula4.model.dao.mode;

import java.util.List;

public interface ReadWriteDAO<Entity, FailException extends Exception> {
	Entity inserir(Entity entity) throws FailException;
	List<Entity> buscaTodos()  throws FailException;
	Entity buscaPorId(Integer id)  throws FailException;
	Entity alterar(Entity entity)  throws FailException;
	void excluir(Integer id)  throws FailException;
}
