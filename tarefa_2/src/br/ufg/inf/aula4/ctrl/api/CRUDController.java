package br.ufg.inf.aula4.ctrl.api;

import java.util.List;

public interface CRUDController<E> {
	E inserir(E entity);
	List<E> buscaTodos();
	E buscaPorId(Integer id);
	E alterar(E entity);
	void excluir(Integer id);
}
