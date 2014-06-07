package br.com.treinaweb.designPatterns.structural.bridge;

public class GeradorDeArquivoHTML implements GeradorDeArquivo {

	@Override
	public String gera(String texto) {
		String retorno = "";
		
		retorno = "<html>\n";
		retorno += "\t<head>\n";
		retorno += "\t\t<title>Arquivo HTML</title>\n";
		retorno += "\t</head>\n";
		retorno += "\t<body>\n";
		retorno += "\t\t<p>\n";
		retorno += texto;
		retorno += "\t\t</p>\n";
		retorno += "\t</body>\n";
		retorno += "</html>";
				
		return retorno;
	}

}
