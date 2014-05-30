package br.com.treinaweb.designPatterns.creational.simpleFactory;

import java.util.List;

public class BancoMySQL implements Banco {

	@Override
	public String getName() {
		return "MySQL";
	}

	@Override
	public boolean salvar() {
		return false;
	}

	@Override
	public boolean alterar() {
		return false;
	}

	@Override
	public List<?> buscar() {
		return null;
	}

	@Override
	public boolean excluir() {
		return false;
	}

}
