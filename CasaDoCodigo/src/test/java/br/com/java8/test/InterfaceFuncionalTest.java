package br.com.java8.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.java8.Validador;

public class InterfaceFuncionalTest {

	@Test
	public void imprimeUsuariosDaListaUsandoInferfaceFuncionalPropria() {
		Validador<String> validadorCEP = new Validador<String>() {
			@Override
			public boolean valida(String valor) {
				return valor.matches("[0-9]{5}-[0-9]{3}");
			}
		};
		assertTrue(validadorCEP.valida("87030-240"));
	}

	@Test
	public void imprimeUsuariosDaListaUsandoInferfaceFuncionalPropria_usandoLambda() {
		Validador<String> validadorCEP = valor -> {
			return valor.matches("[0-9]{5}-[0-9]{3}");
		};

		assertTrue(validadorCEP.valida("87030-240"));
	}

	@Test
	public void imprimeUsuariosDaListaUsandoInferfaceFuncionalPropria_usandoLambdaReduzido() {
		Validador<String> validadorCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");

		assertTrue(validadorCEP.valida("87030-240"));
	}
}
