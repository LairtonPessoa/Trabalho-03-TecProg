package controller;

import java.util.ArrayList;

public class Jogada {
	private JogadorServidor jogadorVez;
	private String fraseDica;
	private String cartaVez;
	private ArrayList<String> cartasEscolhidas;
	private int pontuacao;
	private int id;

	public Jogada(int idJogadorVez,String fraseDica, String cartaVez, int pontuacao) {
		jogadorVez = new JogadorServidor(idJogadorVez);
		this.fraseDica = fraseDica;
		this.cartaVez = cartaVez;
		this.pontuacao = pontuacao;
		cartasEscolhidas = new ArrayList<String>();
	}

	public Jogada() {
		this.fraseDica = "";
		this.cartaVez = "";
		this.pontuacao = 0;
	}

	public void setJogadorVez(JogadorServidor jogadorVez) {
		this.jogadorVez = jogadorVez;
	}

	public void setFraseDica(String fraseDica) {
		this.fraseDica = fraseDica;
	}

	public void setCartaVez(String cartaVez) {
		this.cartaVez = cartaVez;
	}

	public void setCartasEscolhidas(ArrayList<String> cartasEscolhidas) {
		this.cartasEscolhidas = cartasEscolhidas;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getCartaEscolhida() {
		return cartaVez;
	}

	public String getFraseDica() {
		return fraseDica;
	}

	public JogadorServidor getJogadorVez() {
		return jogadorVez;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public int getId() {
		return id;
	}

}
