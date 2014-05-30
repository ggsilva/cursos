package br.com.treinaweb.designPatterns.testes;

import static org.junit.Assert.*;

import org.junit.Test;

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

}
