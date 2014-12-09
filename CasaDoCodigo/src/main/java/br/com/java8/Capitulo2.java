package br.com.java8;

import java.util.ArrayList;
import java.util.List;

public class Capitulo2 {

	private List<Usuario> usuarios;
	
	public Capitulo2() {
		usuarios = new ArrayList<Usuario>();
	}
	
	public String imprimeUsuarios() {
		final StringBuilder impressao = new StringBuilder();
		usuarios.forEach(usuario -> impressao.append(usuario + ", "));
		return impressao.substring(0, impressao.length() - 2);
	}

	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

}
