package controller;

import java.util.ArrayList;

public class Jogador {

	private String nome;
	private int id;
	private int pontuacao;
	private boolean isJogadorDaVez;
	private boolean jaJogouNaRodada;
	private ArrayList<Carta> listaCartas;

	private Carta cartaEscolhida;

	public Jogador(int id, String nome) {
		this.isJogadorDaVez=false;
		this.jaJogouNaRodada = false;
		this.id = id;
		this.pontuacao=0;
	}
	
	public Boolean getJaJogouNaRodada() {
		return jaJogouNaRodada;
	}

	public void setJaJogouNaRodada(Boolean jaJogou) {
		this.jaJogouNaRodada = jaJogou;
	}

	public boolean isJogadorDaVez() {
		return isJogadorDaVez;
	}

	public void setJogadorDaVez(boolean isJogadorDaVez) {
		this.isJogadorDaVez = isJogadorDaVez;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getId() {
		return id;
	}
	public Carta getCartaEscolhida() {
		return cartaEscolhida;
	}

	public void setCartaEscolhida(Carta cartaEscolhida) {
		this.cartaEscolhida = cartaEscolhida;
	}
	
	public ArrayList<Carta> getListaCartas() {
		return listaCartas;
	}


	
}
