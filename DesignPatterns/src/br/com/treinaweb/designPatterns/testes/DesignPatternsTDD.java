package br.com.treinaweb.designPatterns.testes;

import static br.com.treinaweb.designPatterns.testes.DesignPatternsTDDSupport.getMsgReciboHTML;
import static br.com.treinaweb.designPatterns.testes.DesignPatternsTDDSupport.getMsgReciboTXT;
import static br.com.treinaweb.designPatterns.testes.DesignPatternsTDDSupport.getMsgRegistro;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import br.com.treinaweb.designPatterns.behavioral.Service;
import br.com.treinaweb.designPatterns.creational.abstractFactory.AbstractFactory;
import br.com.treinaweb.designPatterns.creational.abstractFactory.Janela;
import br.com.treinaweb.designPatterns.creational.abstractFactory.MSFactory;
import br.com.treinaweb.designPatterns.creational.abstractFactory.MacOSFactory;
import br.com.treinaweb.designPatterns.creational.builder.CarroBuilder;
import br.com.treinaweb.designPatterns.creational.builder.GeradorVeiculos;
import br.com.treinaweb.designPatterns.creational.builder.MotoBuilder;
import br.com.treinaweb.designPatterns.creational.builder.Veiculo;
import br.com.treinaweb.designPatterns.creational.builder.VeiculoBuilder;
import br.com.treinaweb.designPatterns.creational.factoryMethod.AbstractCreator;
import br.com.treinaweb.designPatterns.creational.factoryMethod.ConnectionLoggerCreate;
import br.com.treinaweb.designPatterns.creational.factoryMethod.Logger;
import br.com.treinaweb.designPatterns.creational.factoryMethod.ReadFileLoggerCreate;
import br.com.treinaweb.designPatterns.creational.factoryMethod.WriteFileLoggerCreate;
import br.com.treinaweb.designPatterns.creational.multiton.Camera;
import br.com.treinaweb.designPatterns.creational.objectPool.Funcionario;
import br.com.treinaweb.designPatterns.creational.objectPool.FuncionarioPool;
import br.com.treinaweb.designPatterns.creational.objectPool.Pool;
import br.com.treinaweb.designPatterns.creational.prototype.JanelaPrototype;
import br.com.treinaweb.designPatterns.creational.simpleFactory.Banco;
import br.com.treinaweb.designPatterns.creational.simpleFactory.BancoFactory;
import br.com.treinaweb.designPatterns.creational.singleton.ConfigManager;
import br.com.treinaweb.designPatterns.structural.adapter.ControleDePonto;
import br.com.treinaweb.designPatterns.structural.adapter.ControleDePontoAdapter;
import br.com.treinaweb.designPatterns.structural.adapter.FuncionarioAdapter;
import br.com.treinaweb.designPatterns.structural.bridge.GeradorDeArquivo;
import br.com.treinaweb.designPatterns.structural.bridge.GeradorDeArquivoHTML;
import br.com.treinaweb.designPatterns.structural.bridge.GeradorDeArquivoTXT;
import br.com.treinaweb.designPatterns.structural.bridge.Recibo;
import br.com.treinaweb.designPatterns.structural.composite.Trecho;
import br.com.treinaweb.designPatterns.structural.composite.TrechoAndando;
import br.com.treinaweb.designPatterns.structural.composite.TrechoDeCarro;
import br.com.treinaweb.designPatterns.structural.decorator.Emissor;
import br.com.treinaweb.designPatterns.structural.decorator.EmissorBasico;
import br.com.treinaweb.designPatterns.structural.decorator.EmissorComCriptografia;
import br.com.treinaweb.designPatterns.structural.decorator.EmissorComDescriptografia;

public class DesignPatternsTDD {

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
	
	@Test
	public void utilizaBuilder() {
		VeiculoBuilder veiculoBuilder;
		GeradorVeiculos gerador;
		Veiculo veiculo;
		
		veiculoBuilder = new CarroBuilder();
		gerador = new GeradorVeiculos(veiculoBuilder);
		veiculo = gerador.gerarVeiculo();
		assertEquals("Tipo VeiculoBuilder", veiculoBuilder.getVeiculoBuilder(), "Carro");
		assertEquals("Tipo Veiculo", veiculo.getVeiculo(), "Carro");
		
		veiculoBuilder = new MotoBuilder();
		gerador = new GeradorVeiculos(veiculoBuilder);
		veiculo = gerador.gerarVeiculo();
		assertEquals("Tipo VeiculoBuilder", veiculoBuilder.getVeiculoBuilder(), "Moto");
		assertEquals("Tipo Veiculo", veiculo.getVeiculo(), "Moto");
	}
	
	@Test
	public void utilizaPrototype() {
		JanelaPrototype janela1 = new JanelaPrototype();
		janela1.setTitulo("Janela 1");
		janela1.setAltura(400);
		janela1.setLargura(600);
		
		JanelaPrototype janela2 = janela1.clone();
		janela2.setTitulo("Janela 2");
		janela2.setAltura(600);
		janela2.setLargura(900);
		
		assertEquals("Titulo Janela 1", "Janela 1", janela1.getTitulo());
		assertEquals("Titulo Janela 2", "Janela 2", janela2.getTitulo());
		
		assertEquals("Altura Janela 1", 400, janela1.getAltura());
		assertEquals("Altura Janela 2", 600, janela2.getAltura());
		
		assertEquals("Largura Janela 1", 600, janela1.getLargura());
		assertEquals("Largura Janela 2", 900, janela2.getLargura());
		
	}
	
	@Test
	public void utilizaSingleton() {
		String serverName = ConfigManager.getInstance().getServerName();

		assertEquals("Name Server", "Server", serverName);
		
		serverName = ConfigManager.getInstance("ServerName2").getServerName();

		assertEquals("Name Server", "Server", serverName);
		
	}
	 
	@Test
	public void utilizaMultiton() {
		final Camera cam1 = Camera.getInstance(1234);
		assertEquals("Localização da Câmera", "Left Store", cam1.getLocation());
		
		final Camera cam2 = Camera.getInstance(4321);
		assertEquals("Localização da Câmera", "Right Store", cam2.getLocation());
	}
	 
	@Test
	public void utilizaObjectPool() {
		Pool<Funcionario> funcionarioPool = new FuncionarioPool();
		
		assertEquals("Quantidade Funcionários", 3, funcionarioPool.availables());
		
		assertEquals("Primeiro Funcionário", "Guilherme Silva", funcionarioPool.acquire().getNome());
		assertEquals("Primeiro Funcionário", "José Luiz da Silva", funcionarioPool.acquire().getNome());
		assertEquals("Primeiro Funcionário", "Rodrigo Gabriel", funcionarioPool.acquire().getNome());
		
		assertEquals("Quantidade Funcionários", 0, funcionarioPool.availables());
	}
	 
	@Test
	public void utilizaAdapter() {
		final FuncionarioAdapter funcionario = new FuncionarioAdapter("Guilherme Silva");
		ControleDePonto controleDePonto;
		final boolean isEntrada = true;
		final boolean isSaida = false;		
		
		controleDePonto = new ControleDePonto();
		
		assertEquals("Hora de Entrada Antiga", getMsgRegistro(funcionario, isEntrada), controleDePonto.registraEntrada(funcionario));
		assertEquals("Hora de Saída Antiga", getMsgRegistro(funcionario, isSaida), controleDePonto.registraSaida(funcionario));
		
		controleDePonto = new ControleDePontoAdapter();
		
		assertEquals("Hora de Entrada Antiga", "Nova " + getMsgRegistro(funcionario, isEntrada), controleDePonto.registraEntrada(funcionario));
		assertEquals("Hora de Saída Antiga", "Nova " + getMsgRegistro(funcionario, isSaida), controleDePonto.registraSaida(funcionario));
		
	}
	 
	@Test
	public void utilizaBridge() {
		Recibo recibo;
		GeradorDeArquivo geradorDeArquivo;
		final String empresa = "MeCaso";
		final String favorecido = "Guilherme Silva";
		final double valor = Math.pow(10, 6);
		
		geradorDeArquivo = new GeradorDeArquivoTXT();		
		recibo = new Recibo(empresa, favorecido, valor, geradorDeArquivo);
		assertEquals("Arquivo Texto", getMsgReciboTXT(empresa, favorecido, valor), recibo.gerarArquivo());

		geradorDeArquivo = new GeradorDeArquivoHTML();		
		recibo = new Recibo(empresa, favorecido, valor, geradorDeArquivo);
		assertEquals("Arquivo HTML", getMsgReciboHTML(empresa, favorecido, valor), recibo.gerarArquivo());
	}
	 
	@Test
	public void utilizaComposite() {
		Trecho trecho1 = new TrechoAndando("Vá até o cruzamento da Av. Rebouças com a Av. Brigadeiro Faria Lima.", 500);
		Trecho trecho2 = new TrechoDeCarro("Vá até o cruzamento da Av. Brigadeiro Faria Lima com a Av. Cidade Jardim.", 1500);
		Trecho trecho3 = new TrechoDeCarro("Vire à direita na Marginal Pinheiros.", 500);
		
		Caminho caminho1 = new Caminho();
		caminho1.adiciona(trecho1);
		caminho1.adiciona(trecho2);
		assertEquals("Impressão Caminho 1", DesignPatternsTDDSupport.MSG_CAMINHO_1, caminho1.imprime());
		
		Caminho caminho2 = new Caminho();
		caminho2.adiciona(caminho1);
		caminho2.adiciona(trecho3);
		assertEquals("Impressão Caminho 1", DesignPatternsTDDSupport.MSG_CAMINHO_2, caminho2.imprime());
	}
	 
	@Test
	public void utilizaDecorator() {
		final String mensagem = "Mensagem Padrão.";
		Emissor emissor;
		
		emissor = new EmissorBasico();
		assertEquals("Mensagem Basica enviada", "Enviando uma Mensagem: Mensagem Padrão.", emissor.envia(mensagem));
		
		emissor = new EmissorComCriptografia(new EmissorBasico());
		assertEquals("Mensagem Basica enviada", "Enviando uma Mensagem: .oãrdaP megasneM", emissor.envia(mensagem));
		
		emissor = new EmissorComDescriptografia(new EmissorComCriptografia(new EmissorBasico()));
		assertEquals("Mensagem Basica enviada", "Enviando uma Mensagem: Mensagem Padrão.", emissor.envia(mensagem));
	}
	 
	@Test
	public void testaService(){
		try {
			System.out.println(Service.getCotacao());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
