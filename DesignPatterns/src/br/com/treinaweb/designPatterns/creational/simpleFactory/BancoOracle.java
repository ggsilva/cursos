package br.com.treinaweb.designPatterns.creational.simpleFactory;

import java.util.List;

public class BancoOracle implements Banco {

	@Override
	public String getName() {
		return "Oracle";
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