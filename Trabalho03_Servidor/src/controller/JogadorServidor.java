package controller;

import java.net.Socket;
import java.util.ArrayList;

public class JogadorServidor {

	private int id;
	private int pontuacao;
	private boolean isJogadorDaVez;
	private boolean jaJogouNaRodada;
	private ArrayList<Carta> listaCartas;
	private Socket socket;

	private Carta cartaEscolhida;

	public JogadorServidor(int id) {
		this.isJogadorDaVez=false;
		this.id = id;
		this.jaJogouNaRodada = false;
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

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	
}
