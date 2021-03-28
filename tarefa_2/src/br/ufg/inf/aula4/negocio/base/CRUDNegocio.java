package br.ufg.inf.aula4.negocio.base;

import java.util.List;

public interface CRUDNegocio<Entity, FailureException extends Exception> {
	Entity inserir(Entity entity) throws FailureException;
	List<Entity> buscaTodos() throws FailureException;
	Entity buscaPorId(Integer id) throws FailureException;
	Entity alterar(Entity entity) throws FailureException;
	void excluir(Integer id) throws FailureException;
}
