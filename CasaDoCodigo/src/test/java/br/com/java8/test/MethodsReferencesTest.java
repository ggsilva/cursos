package br.com.java8.test;

import static br.com.java8.support.UsuarioSupport.getListaDeUsuarios;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.java8.Usuario;

public class MethodsReferencesTest {

	@Test
	public void tornaUsuariosModeradores() {
		List<Usuario> usuarios = getListaDeUsuarios();
		StringBuilder builder = new StringBuilder();
		usuarios.forEach(u -> builder.append(getUsuarioComStatusModerador(u)));
		
		assertEquals( "[Guilherme Silva, 15], false\n"
			        + "[Alana Pereira, 20], false\n"
			        + "[Noah Gabriel, 10], false\n", builder.toString());
		
		usuarios.forEach(Usuario::tornaModerador);

		builder.setLength(0);
		usuarios.forEach(u -> builder.append(getUsuarioComStatusModerador(u)));
		
		assertEquals( "[Guilherme Silva, 15], true\n"
			        + "[Alana Pereira, 20], true\n"
			        + "[Noah Gabriel, 10], true\n", builder.toString());
	}

	private String getUsuarioComStatusModerador(Usuario u) {
		return u + ", " + u.isModerador() + "\n";
	}

}
