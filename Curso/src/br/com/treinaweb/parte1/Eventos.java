package br.com.treinaweb.parte1;

public class Eventos {
	private int    idevento = 0;
	private String evento 	= "";
	private String data   	= "";
	
	public Eventos() {}

	public int getIdevento() {
		return idevento;
	}

	public void setIdevento(int idEvento) {
		this.idevento = idEvento;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
