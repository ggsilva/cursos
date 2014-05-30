package br.com.treinaweb.designPatterns.creational.factoryMethod;


public class ConnectionLoggerCreate extends AbstractCreator {

	@Override
	public Logger createLogger() {
		return new ConnectionLogger();		
	}

}
