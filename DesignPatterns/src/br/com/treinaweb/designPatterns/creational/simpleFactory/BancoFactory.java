package br.com.treinaweb.designPatterns.creational.simpleFactory;

public class BancoFactory {
	
	public static final int ORACLE = 0;
	public static final int MYSQL  = 1;

	public Banco getBanco(int tipoBanco){
		if(tipoBanco == BancoFactory.ORACLE)
			return new BancoOracle();
		else if(tipoBanco == BancoFactory.MYSQL)
			return new BancoMySQL();
		else
			throw new IllegalArgumentException("Banco Não Suportado");
	}

}
