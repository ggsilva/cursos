package br.com.treinaweb.designPatterns.creational.factoryMethod;

public class ReadFileLogger implements Logger {

	@Override
	public String log(String msgLog) {
		return "Erro na leitura do arquivo: " + msgLog;
	}

}
