package br.com.treinaweb.designPatterns.testes;

import java.util.ArrayList;
import java.util.List;

import br.com.treinaweb.designPatterns.structural.composite.Trecho;

public class Caminho implements Trecho {
	private List<Trecho> trechos;
	
	public Caminho() {
		this.trechos = new ArrayList<Trecho>();
	}

	public void adiciona(Trecho trecho) {
		this.trechos.add(trecho);
	}

	@Override
	public String imprime() {
		StringBuffer retorno = new StringBuffer();
		
		for(Trecho trecho : this.trechos){
			retorno.append(trecho.imprime() + " ");
		}
		
		return retorno.toString().trim();
	}
}
