package br.com.treinaweb.designPatterns.structural.decorator;

public class EmissorComDescriptografia extends EmissorDecorator {

	public EmissorComDescriptografia(Emissor emissor) {
		super(emissor);
	}

	@Override
	public String envia(String mensagem) {
		return this.getEmissor().envia(descriptografa(mensagem));
	}

	private String descriptografa(String mensagem) {
		String mensagemCriptografada = "";
		for (int i = mensagem.length() - 1; i >= 0; i--)
			mensagemCriptografada += mensagem.charAt(i);
		return mensagemCriptografada;
	}
}
