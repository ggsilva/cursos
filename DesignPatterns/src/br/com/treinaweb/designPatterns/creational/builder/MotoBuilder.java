package br.com.treinaweb.designPatterns.creational.builder;

public class MotoBuilder implements VeiculoBuilder {

	@Override
	public String getVeiculoBuilder() {
		return "Moto";
	}

	@Override
	public void builderEstrutura() {
	}

	@Override
	public void builderMotor() {
	}

	@Override
	public void builderRodas() {
	}

	@Override
	public void bulderPortas() {
	}

	@Override
	public Veiculo getVeiculo(String veiculo) {
		return new Veiculo(getVeiculoBuilder());
	}

}
