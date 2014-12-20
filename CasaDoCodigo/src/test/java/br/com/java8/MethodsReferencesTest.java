package br.com.java8;

import static java.util.Comparator.naturalOrder;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MethodsReferencesTest {

	@Test
	public void ordenandoUmaListaDeStrings() {
		List<Usuario> usuarios = getListaDeUsuarios();
		List<String> nomes = new ArrayList<String>();

		usuarios.forEach(u -> nomes.add(u.getNome()));
		
		nomes.sort(naturalOrder());
		
		assertEquals("[Alana Pereira, Guilherme Silva, Noah Gabriel]", nomes.toString());
	}

	private List<Usuario> getListaDeUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Guilherme Silva", 15));
		usuarios.add(new Usuario("Alana Pereira", 20));
		usuarios.add(new Usuario("Noah Gabriel", 10));
		return usuarios;
	}
}
