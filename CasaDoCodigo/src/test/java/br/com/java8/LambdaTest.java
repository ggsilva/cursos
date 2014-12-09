package br.com.java8;

import static org.junit.Assert.*;

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

}
