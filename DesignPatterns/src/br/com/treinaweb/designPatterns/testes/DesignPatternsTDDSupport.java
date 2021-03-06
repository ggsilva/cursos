package br.com.treinaweb.designPatterns.testes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.treinaweb.designPatterns.structural.adapter.FuncionarioAdapter;

public class DesignPatternsTDDSupport {

	public static final String MSG_CAMINHO_1 = "Vá andando: Vá até o cruzamento da Av. Rebouças com a Av. Brigadeiro Faria Lima. A distância percorrida será de 500.0 metros. Vá de Carro: Vá até o cruzamento da Av. Brigadeiro Faria Lima com a Av. Cidade Jardim. A distância percorrida será de 1500.0 metros.";
	public static final String MSG_CAMINHO_2 = "Vá andando: Vá até o cruzamento da Av. Rebouças com a Av. Brigadeiro Faria Lima. A distância percorrida será de 500.0 metros. Vá de Carro: Vá até o cruzamento da Av. Brigadeiro Faria Lima com a Av. Cidade Jardim. A distância percorrida será de 1500.0 metros. Vá de Carro: Vire à direita na Marginal Pinheiros. A distância percorrida será de 500.0 metros.";

	public static String getMsgRegistro(FuncionarioAdapter funcionario, boolean isEntrada) {
		if(isEntrada)
			return "Entrada: " + funcionario.getNome() + " às " + getHoraRegistro();
		else
			return "Saída: " + funcionario.getNome() + " às " + getHoraRegistro();
	}

	private static String getHoraRegistro() {
		return new SimpleDateFormat("dd/MM/yyyy H:m").format(Calendar.getInstance().getTime());
	}

	public static String getMsgReciboTXT(String empresa, String favorecido, double valor) {
		return getCorpoTexto(empresa, favorecido, valor);
	}

	public static String getMsgReciboHTML(String empresa, String favorecido,double valor) {
		String retorno = "";
		retorno = "<html>\n";
		retorno += "\t<head>\n";
		retorno += "\t\t<title>Arquivo HTML</title>\n";
		retorno += "\t</head>\n";
		retorno += "\t<body>\n";
		retorno += "\t\t<p>\n";
		retorno += getCorpoTexto(empresa, favorecido, valor);
		retorno += "\t\t</p>\n";
		retorno += "\t</body>\n";
		retorno += "</html>";
		return retorno;
	}

	private static String getCorpoTexto(String empresa, String favorecido, double valor) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Recibo: ");
		buffer.append("\n");
		buffer.append("Empresa: " + empresa);
		buffer.append("\n");
		buffer.append("Cliente: " + favorecido);
		buffer.append("\n");
		buffer.append("Valor: "	  + valor);
		buffer.append("\n");
		return buffer.toString();
	}

}
