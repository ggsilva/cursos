package br.com.treinaweb.designPatterns.creational.factoryMethod;

public class WriteFileLoggerCreate extends AbstractCreator {

	@Override
	public Logger createLogger() {
		return new WriteFileLogger();		
	}

}
