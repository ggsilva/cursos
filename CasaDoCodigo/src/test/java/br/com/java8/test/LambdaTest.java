package br.com.java8.test;

import static br.com.java8.support.UsuarioSupport.getListaDeUsuarios;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import org.junit.Test;

import br.com.java8.Capitulo2;
import br.com.java8.Usuario;

public class LambdaTest {

	@Test
	public void imprimeUsuariosDaLista() {
		Capitulo2 c = new Capitulo2();
		c.addUsuario(new Usuario("Guilherme Silva", 15));
		c.addUsuario(new Usuario("Alana Pereira", 20));
		assertEquals("[Guilherme Silva, 15], [Alana Pereira, 20]", c.imprimeUsuarios());
	}

	@Test
	public void imprimeUsuariosUsandoMetodoDefault() {
		List<Usuario> usuarios = getListaDeUsuarios();
		
		StringBuilder builder = new StringBuilder();
		
		Consumer<Usuario> mostraMensagem = u -> builder.append("antes de imprimir os nomes" + "\n");
		Consumer<Usuario> imprimeNomes   = u -> builder.append(u.getNome() + "\n");
		
		usuarios.forEach(mostraMensagem.andThen(imprimeNomes));
		
		assertEquals( "antes de imprimir os nomes\n"
				    + "Guilherme Silva\n"
				    + "antes de imprimir os nomes\n"
				    + "Alana Pereira\n"
				    + "antes de imprimir os nomes\n"
				    + "Noah Gabriel\n", builder.toString());
	}

	@Test
	public void filtraUsuariosUtilizandoPredicate() {
		List<Usuario> usuarios = getListaDeUsuarios();
		
		Predicate<Usuario> p = u -> u.getPontos() > 10;
		usuarios.removeIf(p);
		
		assertEquals("[[Noah Gabriel, 10]]", usuarios.toString());
	}

	@Test
	public void ordenandoPorNomeUtilizandoComparatorELambda() {
		List<Usuario> usuarios = getListaDeUsuarios();

		Comparator<Usuario> comparator = (u1, u2) -> u1.getNome().compareTo(u2.getNome());	
		usuarios.sort(comparator);
		
		assertEquals("[[Alana Pereira, 20], "
				    + "[Guilherme Silva, 15], "
				    + "[Noah Gabriel, 10]]", usuarios.toString());
	}

	@Test
	public void ordenandoPorPontosUtilizandoComparatorComMetodoEstaticoELambda() {
		List<Usuario> usuarios = getListaDeUsuarios();

		Comparator<Usuario> comparator = comparing(u -> u.getPontos());	
		usuarios.sort(comparator);
		
		assertEquals("[[Noah Gabriel, 10], "
			        + "[Guilherme Silva, 15], "
			        + "[Alana Pereira, 20]]", usuarios.toString());
	}

	@Test
	public void ordenandoUmaListaDeStrings() {
		List<Usuario> usuarios = getListaDeUsuarios();
		List<String> nomes = new ArrayList<String>();

		usuarios.forEach(u -> nomes.add(u.getNome()));
		
		nomes.sort(naturalOrder());
		
		assertEquals("[Alana Pereira, Guilherme Silva, Noah Gabriel]", nomes.toString());
	}
	
	@Test
	public void ordenandoPorPontosComAutoboxing() {
		List<Usuario> usuarios = getListaDeUsuarios();

		Function<Usuario, Integer> extraiPontos = u -> u.getPontos();
		Comparator<Usuario> comparator = comparing(extraiPontos);	
		usuarios.sort(comparator);
		
		StringBuilder builder = new StringBuilder();
		usuarios.forEach(u -> builder.append(u + "\n"));
		
		assertEquals( "[Noah Gabriel, 10]\n"
			        + "[Guilherme Silva, 15]\n"
			        + "[Alana Pereira, 20]\n", builder.toString());
	}
	
	@Test
	public void ordenandoPorPontosUtilizandoInterfacesEquivalentesAoAutoboxing() {
		List<Usuario> usuarios = getListaDeUsuarios();

		ToIntFunction<Usuario> extraiPontos = u -> u.getPontos();
		Comparator<Usuario> comparator = comparingInt(extraiPontos);	
		usuarios.sort(comparator);
		
		StringBuilder builder = new StringBuilder();
		usuarios.forEach(u -> builder.append(u + "\n"));
		
		assertEquals( "[Noah Gabriel, 10]\n"
			        + "[Guilherme Silva, 15]\n"
			        + "[Alana Pereira, 20]\n", builder.toString());
	}

}
