
package br.com.treinaweb.designPatterns.creational.prototype;
public class JanelaPrototype implements Cloneable {
	private String titulo;
	private int altura;
	private int largura;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	@Override
	public JanelaPrototype clone(){
		try {
			return (JanelaPrototype) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalArgumentException("Clone não suportado");
		}
	}
	
}
