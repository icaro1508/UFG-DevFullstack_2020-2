package br.ufg.inf.repository.pessoa;

import br.ufg.inf.entities.pessoa.Pessoa;
import br.ufg.inf.repository.Repository;
import java.util.List;

public class PessoaInMemoryRepository implements Repository<String, Pessoa> {
	
	@Override
	public List<Pessoa> findAll() {
		return null;
	}
	
	@Override
	public Pessoa find(String id) {
		return null;
	}
	
	@Override
	public String create(Pessoa entity) {
		return null;
	}
	
	@Override
	public Pessoa delete(String id) {
		return null;
	}
	
}
