package br.com.treinaweb.designPatterns.structural.decorator;

public class EmissorBasico implements Emissor {

	@Override
	public String envia(String mensagem) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Enviando uma Mensagem: ");
		buffer.append(mensagem);
		return buffer.toString();
	}

}
