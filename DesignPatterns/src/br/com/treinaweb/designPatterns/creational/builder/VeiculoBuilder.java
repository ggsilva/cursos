package br.com.treinaweb.designPatterns.creational.builder;

public interface VeiculoBuilder {
	
	public String getVeiculoBuilder();
	
	public void builderEstrutura();
	public void builderMotor();
	public void builderRodas();
	public void bulderPortas();
	
	public Veiculo getVeiculo(String veiculo);
}
