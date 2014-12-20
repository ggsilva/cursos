package br.com.java8.support;

import java.util.ArrayList;
import java.util.List;

import br.com.java8.Usuario;

public class UsuarioSupport {

	public static List<Usuario> getListaDeUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Guilherme Silva", 15));
		usuarios.add(new Usuario("Alana Pereira", 20));
		usuarios.add(new Usuario("Noah Gabriel", 10));
		return usuarios;
	}
}
