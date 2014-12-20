package br.com.java8;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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

	private List<Usuario> getListaDeUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Guilherme Silva", 15));
		usuarios.add(new Usuario("Alana Pereira", 20));
		usuarios.add(new Usuario("Noah Gabriel", 10));
		return usuarios;
	}
}
