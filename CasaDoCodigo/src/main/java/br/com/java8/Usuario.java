package br.com.java8;

public class Usuario {

	private String nome;
	private int pontos;
	private boolean moderador;

	public Usuario(String nome, int pontos) {
		this.setNome(nome);
		this.setPontos(pontos);
		this.moderador = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public boolean isModerador() {
		return this.moderador;
	}
	
	public void tornaModerador(){
		moderador = true;
	}
	
	@Override
	public String toString() {
		return String.format("[%s, %d]", getNome(), getPontos());
	}
}
