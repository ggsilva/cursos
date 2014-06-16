package br.com.treinaweb.designPatterns.structural.decorator;

public class EmissorComCriptografia extends EmissorDecorator {

	public EmissorComCriptografia(Emissor emissor) {
		super(emissor);
	}

	@Override
	public String envia(String mensagem) {
		return this.getEmissor().envia(criptografa(mensagem));
	}

	private String criptografa(String mensagem) {
		String mensagemCriptografada = "";
		for (int i = mensagem.length() - 1; i >= 0; i--)
			mensagemCriptografada += mensagem.charAt(i);
		return mensagemCriptografada;
	}

}
