package br.com.treinaweb.designPatterns.structural.adapter;

public class ControleDePontoAdapter extends ControleDePonto {
	
	private static final boolean REGISTRO_ENTRADA = true;
	private static final boolean REGISTRO_SAIDA   = false;
	private ControleDePontoNovo controleDePontoNovo;
	
	public ControleDePontoAdapter() {
		controleDePontoNovo = new ControleDePontoNovo();
	}

	@Override
	public String registraEntrada(FuncionarioAdapter funcionario) {
		return controleDePontoNovo.registra(funcionario, REGISTRO_ENTRADA);
	}
	
	@Override
	public String registraSaida(FuncionarioAdapter funcionario) {
		return controleDePontoNovo.registra(funcionario, REGISTRO_SAIDA);
	}
	
}
