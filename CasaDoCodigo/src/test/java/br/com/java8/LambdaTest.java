package br.com.java8;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import br.com.java8.Capitulo2;
import br.com.java8.Usuario;

public class LambdaTest {

	@Test
	public void imprimeUsuariosDaLista() {
		Capitulo2 c = new Capitulo2();
		c.addUsuario(new Usuario("Guilherme Silva", 20));
		c.addUsuario(new Usuario("Alana Pereira", 15));
		assertEquals("[Guilherme Silva, 20], [Alana Pereira, 15]", c.imprimeUsuarios());
	}

	@Test
	public void imprimeUsuariosUsandoMetodoDefault() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Guilherme Silva", 20));
		usuarios.add(new Usuario("Alana Pereira", 15));
		usuarios.add(new Usuario("Noah Gabriel", 35));
		
		StringBuilder builder = new StringBuilder();
		
		String mensagem = "antes de imprimir os nomes";
		Consumer<Usuario> mostraMensagem = u -> builder.append(mensagem    + "\n");
		Consumer<Usuario> imprimeNomes   = u -> builder.append(u.getNome() + "\n");
		
		usuarios.forEach(mostraMensagem.andThen(imprimeNomes));
		
		assertEquals( "antes de imprimir os nomes\n"
				    + "Guilherme Silva\n"
				    + "antes de imprimir os nomes\n"
				    + "Alana Pereira\n"
				    + "antes de imprimir os nomes\n"
				    + "Noah Gabriel\n", builder.toString());
	}

}
