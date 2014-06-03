package br.com.treinaweb.designPatterns.creational.objectPool;

public class Funcionario {

	private String nome;

	public Funcionario(String nome) {
		this.setNome(nome);
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	
}
