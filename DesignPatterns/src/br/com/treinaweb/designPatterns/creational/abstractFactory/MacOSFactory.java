package br.com.treinaweb.designPatterns.creational.abstractFactory;

public class MacOSFactory implements AbstractFactory {

	@Override
	public Janela createJanela() {
		return new MacOSJanela();
	}

}
