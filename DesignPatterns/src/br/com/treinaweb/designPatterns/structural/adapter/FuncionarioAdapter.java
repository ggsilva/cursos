package br.com.treinaweb.designPatterns.structural.adapter;

public class FuncionarioAdapter {

	private String nome;

	public FuncionarioAdapter(String nome) {
		setNome(nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
