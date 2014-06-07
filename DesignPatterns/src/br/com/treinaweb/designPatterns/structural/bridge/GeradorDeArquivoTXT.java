package br.com.treinaweb.designPatterns.structural.bridge;

public class GeradorDeArquivoTXT implements GeradorDeArquivo {

	@Override
	public String gera(String texto) {
		return texto;
	}

}
