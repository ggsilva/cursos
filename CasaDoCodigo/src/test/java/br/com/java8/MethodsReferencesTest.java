package br.com.java8;

import static br.com.java8.support.UsuarioSupport.getListaDeUsuarios;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.nullsLast;
import static java.util.Comparator.nullsFirst;
import static org.junit.Assert.*;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;

import br.com.java8.Usuario;

public class MethodsReferencesTest {

	@Test
	public void tornaUsuariosModeradores() {
		List<Usuario> usuarios = getListaDeUsuarios();
		usuarios.forEach(u -> assertFalse(u.isModerador()));
		
		usuarios.forEach(Usuario::tornaModerador);
		usuarios.forEach(u -> assertTrue(u.isModerador()));
	}

	@Test
	public void ordenandoPorPontos() {
		List<Usuario> usuarios = getListaDeUsuarios();

		usuarios.sort(comparingInt(Usuario::getPontos));
		
		assertEquals("[[Noah Gabriel, 10], "
			        + "[Guilherme Silva, 15], "
			        + "[Alana Pereira, 20]]", usuarios.toString());
	}
	
	@Test
	public void ordenandoPorNomeComAutoboxing() {
		List<Usuario> usuarios = getListaDeUsuarios();
		
		Function< Usuario, String> byName = Usuario::getNome;
		usuarios.sort(comparing(byName));
		
		assertEquals("[[Alana Pereira, 20], "
				    + "[Guilherme Silva, 15], "
				    + "[Noah Gabriel, 10]]", usuarios.toString());
	}
	
	@Test
	public void ordenandoPorPontoEPorNome() {
		List<Usuario> usuarios = getListaDeUsuarios();
		usuarios.add(new Usuario("Sarah Gabriely", 10));
		
		usuarios.sort(comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome));

		assertEquals("[[Noah Gabriel, 10], "
			        + "[Sarah Gabriely, 10], "
			        + "[Guilherme Silva, 15], "
			        + "[Alana Pereira, 20]]", usuarios.toString());
	}
	
	@Test
	public void ordenandoPorNomeDeixandoONuloPorUltimo() {
		List<Usuario> usuarios = getListaDeUsuarios();
		usuarios.add(null);
		
		usuarios.sort(nullsLast(comparing(Usuario::getNome)));

		assertEquals("[[Alana Pereira, 20], "
			        + "[Guilherme Silva, 15], "
			        + "[Noah Gabriel, 10], "
			        + "null]", usuarios.toString());
	}
	
	@Test
	public void ordenandoPorNomeDeixandoONuloPorPrimeiro() {
		List<Usuario> usuarios = getListaDeUsuarios();
		usuarios.add(null);
		
		usuarios.sort(nullsFirst(comparing(Usuario::getNome)));

		assertEquals( "[null, "
			        + "[Alana Pereira, 20], "
			        + "[Guilherme Silva, 15], "
			        + "[Noah Gabriel, 10]]", usuarios.toString());
	}

	@Test
	public void ordenandoPorPontosEmOrdemDecrescente() {
		List<Usuario> usuarios = getListaDeUsuarios();

		usuarios.sort(comparingInt(Usuario::getPontos).reversed());
		
		assertEquals("[[Alana Pereira, 20], "
			        + "[Guilherme Silva, 15], "
			        + "[Noah Gabriel, 10]]", usuarios.toString());
	}

	@Test
	public void tornandoUsuarioModeradorRefenciandoMetodoDeInstancia() {
		Usuario noah = new Usuario("Noah Gabriel", 10);

		assertFalse(noah.isModerador());
		
		Runnable bloco = noah::tornaModerador;
		bloco.run();
		
		assertTrue(noah.isModerador());
	}

	@Test
	public void tornandoUsuarioModeradorRefenciandoMetodoDeInstanciaUtilizandoLambda() {
		Usuario noah = new Usuario("Noah Gabriel", 10);

		assertFalse(noah.isModerador());
		
		Runnable bloco = () -> noah.tornaModerador();
		bloco.run();
		
		assertTrue(noah.isModerador());
	}

	@Test
	public void tornandoUsuarioModeradorAtravesDoMetodoAcceptDaInterfaceConsumer() {
		Usuario noah = new Usuario("Noah Gabriel", 10);

		assertFalse(noah.isModerador());

		Consumer<Usuario> consumer = Usuario::tornaModerador;
		consumer.accept(noah);
		
		assertTrue(noah.isModerador());
	}

	@Test
	public void imprimindoUsuariosReferenciandoOAppendDoStringBuilder() {
		List<Usuario> usuarios = getListaDeUsuarios();
		StringBuilder builder = new StringBuilder();

		usuarios.forEach(builder::append);
		
		assertEquals( "[Guilherme Silva, 15]"
			        + "[Alana Pereira, 20]"
			        + "[Noah Gabriel, 10]", builder.toString());
	}
}
