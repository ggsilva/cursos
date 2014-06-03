package br.com.treinaweb.designPatterns.creational.objectPool;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioPool implements Pool<Funcionario> {

	private List<Funcionario> funcionarios;
	
	public FuncionarioPool() {
		this.funcionarios = new ArrayList<Funcionario>();
		this.funcionarios.add(new Funcionario("Guilherme Silva"));
		this.funcionarios.add(new Funcionario("José Luiz da Silva"));
		this.funcionarios.add(new Funcionario("Rodrigo Gabriel"));
	}

	@Override
	public Funcionario acquire() {
		if(this.funcionarios.size() > 0)
			return funcionarios.remove(0);
		else
			return null;
	}

	@Override
	public void release(Funcionario funcionario) {
		this.funcionarios.add(funcionario);
	}

	@Override
	public int availables() {
		return this.funcionarios.size();
	}

}
