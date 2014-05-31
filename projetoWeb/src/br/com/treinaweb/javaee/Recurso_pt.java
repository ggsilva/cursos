package br.com.treinaweb.javaee;

import java.util.ListResourceBundle;

public class Recurso_pt extends ListResourceBundle {
	
	static final private Object[][] contents = { {"login.apresentacao","Bem vindo"}
											   , {"login.usuario","Usuário:"}
											   , {"login.senha","Senha:"}
											   , {"login.correto","Login Correto"}
											   , {"login.incorreto","Login incorreto"}};

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
