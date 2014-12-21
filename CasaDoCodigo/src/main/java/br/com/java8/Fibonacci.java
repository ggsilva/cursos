package br.com.java8;

import java.util.function.IntSupplier;

public class Fibonacci implements IntSupplier{

	int atual = 0;
	int proximo = 1;
	
	@Override
	public int getAsInt() {
		int retorno = atual;
		proximo += atual;
		atual = proximo - atual;
		return retorno;
	}

}
