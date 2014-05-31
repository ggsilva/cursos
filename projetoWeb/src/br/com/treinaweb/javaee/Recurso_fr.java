package br.com.treinaweb.javaee;

import java.util.ListResourceBundle;

public class Recurso_fr extends ListResourceBundle {
	
	static final private Object[][] contents = { {"login.apresentacao","Bienvenue"}
											   , {"login.usuario","Utilisateur:"}
											   , {"login.senha","Mot de passe:"}
											   , {"login.correto","Ouverture correcte"}
											   , {"login.incorreto","Ouverture incorrecte"}};

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
