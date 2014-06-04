package br.com.treinaweb.designPatterns.structural.adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ControleDePonto {

	public String registraEntrada(FuncionarioAdapter funcionario) {
		String format = new SimpleDateFormat("dd/MM/yyyy H:m").format(Calendar.getInstance().getTime());
		return "Entrada: " + funcionario.getNome() + " às " + format;
	}

	public String registraSaida(FuncionarioAdapter funcionario) {
		String format = new SimpleDateFormat("dd/MM/yyyy H:m").format(Calendar.getInstance().getTime());
		return "Saída: " + funcionario.getNome() + " às " + format;
	}

}
