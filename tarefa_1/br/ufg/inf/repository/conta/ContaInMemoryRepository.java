package br.ufg.inf.repository.conta;

import br.ufg.inf.repository.Repository;
import java.util.List;

public class ContaInMemoryRepository<Conta> implements Repository<String, Conta> {
	
	@Override
	public List<Conta> findAll() {
		return null;
	}
	
	@Override
	public Conta find(String id) {
		return null;
	}
	
	@Override
	public String create(Conta entity) {
		return null;
	}
	
	@Override
	public Conta delete(String id) {
		return null;
	}
	
}
