package br.com.treinaweb.designPatterns.creational.builder;

public class GeradorVeiculos {
	
	private VeiculoBuilder veiculoBuilder;

	public GeradorVeiculos(VeiculoBuilder veiculoBuilder) {
		this.veiculoBuilder = veiculoBuilder;
	}
	
	public Veiculo gerarVeiculo(){
		
		this.veiculoBuilder.builderEstrutura();
		this.veiculoBuilder.builderMotor();
		this.veiculoBuilder.builderRodas();
		this.veiculoBuilder.bulderPortas();
		
		return veiculoBuilder.getVeiculo(this.veiculoBuilder.getVeiculoBuilder());
	}

}
