package br.com.treinaweb.designPatterns.structural.decorator;

public abstract class EmissorDecorator implements Emissor{
	private Emissor emissor;

	public EmissorDecorator(Emissor emissor) {
		this.emissor = emissor;
	}
	
	public abstract String envia(String mensagem);

	public Emissor getEmissor() {
		return emissor;
	}
}
