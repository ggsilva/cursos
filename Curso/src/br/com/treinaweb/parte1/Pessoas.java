package br.com.treinaweb.parte1;

import java.util.HashSet;
import java.util.Set;

public class Pessoas {
	private int    idPessoa     = 0;
	private int    idade 		= 0;
	private String primeiroNome = "";
	private String ultimoNome 	= "";
	private Set<Eventos> eventos = new HashSet<Eventos>();
	private Set<String> emails = new HashSet<String>();
	
	public Pessoas() {}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public Set<Eventos> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Eventos> eventos) {
		this.eventos = eventos;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}
}
