package br.com.treinaweb.designPatterns.creational.abstractFactory;

public class MSFactory implements AbstractFactory {

	@Override
	public Janela createJanela() {
		return new MSJanela();
	}

}
