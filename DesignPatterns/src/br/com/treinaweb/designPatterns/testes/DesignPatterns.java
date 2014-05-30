package br.com.treinaweb.designPatterns.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.treinaweb.designPatterns.creational.abstractFactory.AbstractFactory;
import br.com.treinaweb.designPatterns.creational.abstractFactory.Janela;
import br.com.treinaweb.designPatterns.creational.abstractFactory.MSFactory;
import br.com.treinaweb.designPatterns.creational.abstractFactory.MacOSFactory;
import br.com.treinaweb.designPatterns.creational.factoryMethod.AbstractCreator;
import br.com.treinaweb.designPatterns.creational.factoryMethod.ConnectionLoggerCreate;
import br.com.treinaweb.designPatterns.creational.factoryMethod.Logger;
import br.com.treinaweb.designPatterns.creational.factoryMethod.ReadFileLoggerCreate;
import br.com.treinaweb.designPatterns.creational.factoryMethod.WriteFileLoggerCreate;
import br.com.treinaweb.designPatterns.creational.simpleFactory.Banco;
import br.com.treinaweb.designPatterns.creational.simpleFactory.BancoFactory;

public class DesignPatterns {

	@Test
	public void utilizaSimpleFactory() {
		BancoFactory simpleFactory = new BancoFactory();
		Banco banco; 
		
		banco = simpleFactory.getBanco(BancoFactory.ORACLE);
		assertEquals("Nome Banco Oracle", "Oracle", banco.getName());
		
		banco = simpleFactory.getBanco(BancoFactory.MYSQL);		
		assertEquals("Nome Banco MySQL", "MySQL", banco.getName());
	}

	@Test
	public void utilizaFactoryMethod() {
		AbstractCreator creator;
		Logger logger;
		
		creator = new ConnectionLoggerCreate();
		logger = creator.createLogger();
		assertEquals("Mensagem Log Connection", "Erro na conexão com o banco de dados: MySQL", logger.log("MySQL"));;
		
		creator = new WriteFileLoggerCreate();
		logger = creator.createLogger();
		assertEquals("Mensagem Log WriteFile", "Erro na escrita do arquivo: FileWrite.txt", logger.log("FileWrite.txt"));;
		
		creator = new ReadFileLoggerCreate();
		logger = creator.createLogger();
		assertEquals("Mensagem Log ReadFile", "Erro na leitura do arquivo: FileRead.txt", logger.log("FileRead.txt"));;
	}
	
	@Test
	public void utilizaAbstractFactory() {
		AbstractFactory factory;
		Janela janela;
		
		factory = new MacOSFactory();
		janela = factory.createJanela();
		janela.setTitle("Janela " + janela.getOS());
		assertEquals("Titulo Janela MacOS", "Janela MacOS", janela.getTitle());
		
		factory = new MSFactory();
		janela = factory.createJanela();
		janela.setTitle("Janela " + janela.getOS());
		assertEquals("Titulo Janela MS", "Janela MS", janela.getTitle());
		
	}

}
