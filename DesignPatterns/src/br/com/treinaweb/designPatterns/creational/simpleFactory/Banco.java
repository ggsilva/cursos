package br.com.treinaweb.designPatterns.creational.simpleFactory;

import java.util.List;

public interface Banco {
	public String getName();
	public boolean salvar();
	public boolean alterar();
	public List<?> buscar();
	public boolean excluir();
}