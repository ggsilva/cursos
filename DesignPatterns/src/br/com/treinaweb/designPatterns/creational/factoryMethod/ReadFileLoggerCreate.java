package br.com.treinaweb.designPatterns.creational.factoryMethod;

public class ReadFileLoggerCreate extends AbstractCreator {

	@Override
	public Logger createLogger() {
		return new ReadFileLogger();		
	}

}
