package br.com.treinaweb.designPatterns.structural.adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ControleDePontoNovo {

	public String registra(FuncionarioAdapter funcionario, boolean isEntrada) {
		if(isEntrada)
			return "Nova Entrada: " + funcionario.getNome() + " às " + getHoraRegistro();
		else
			return "Nova Saída: " + funcionario.getNome() + " às " + getHoraRegistro();
	}

	private String getHoraRegistro() {
		return new SimpleDateFormat("dd/MM/yyyy H:m").format(Calendar.getInstance().getTime());
	}

}
