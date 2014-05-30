package br.com.treinaweb.designPatterns.creational.abstractFactory;

public class MacOSJanela implements Janela {
	
	private String title;

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getOS() {
		return "MacOS";
	}

}
