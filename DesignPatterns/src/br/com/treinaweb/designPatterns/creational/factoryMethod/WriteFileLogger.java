package br.com.treinaweb.designPatterns.creational.factoryMethod;

public class WriteFileLogger implements Logger {

	@Override
	public String log(String msgLog) {
		return "Erro na escrita do arquivo: " + msgLog;
	}

}
