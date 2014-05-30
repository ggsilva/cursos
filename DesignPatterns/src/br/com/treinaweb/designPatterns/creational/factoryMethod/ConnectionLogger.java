package br.com.treinaweb.designPatterns.creational.factoryMethod;


public class ConnectionLogger implements Logger {

	@Override
	public String log(String msgLog) {
		return "Erro na conexão com o banco de dados: " + msgLog;
	}

}
