package br.ufg.inf.repository;

import java.util.List;

public interface Repository<K, V> {
	List<V> findAll();
	V find(K id);
	K create(V entity);
	V delete(K id);
}
