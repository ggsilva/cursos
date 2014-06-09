package br.com.treinaweb.designPatterns.structural.composite;

public class TrechoAndando implements Trecho {

	private String direcao;
	private double distancia;

	public TrechoAndando(String direcao, double distancia) {
		this.direcao = direcao;
		this.distancia = distancia;
	}

	@Override
	public String imprime() {
		StringBuffer retorno = new StringBuffer();
		
		retorno.append("Vá andando: ");
		retorno.append(this.direcao + " ");
		retorno.append("A distância percorrida será de " + this.distancia + " metros.");
		
		return retorno.toString();
	}

}
