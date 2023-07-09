package controller;

public class Jogada {
	private Jogador jogadorVez;
	private String fraseDica;
	private String cartaEscolhida;
	private int pontuacao;
	private int id;

	public Jogada(String jogadorVez, String fraseDica, String cartaEscolhida, int pontuacao) {
		this.jogadorVez.setNome(jogadorVez);
		this.fraseDica = fraseDica;
		this.cartaEscolhida = cartaEscolhida;
		this.pontuacao = pontuacao;
	}

	public Jogada() {
//		jogadorVez = new Jogador();
//		this.jogadorVez.setNome("");
		this.fraseDica = "";
		this.cartaEscolhida = "";
		this.pontuacao = 0;
	}

	public String getCartaEscolhida() {
		return cartaEscolhida;
	}

	public String getJogadorVez() {
		return jogadorVez.getNome();
	}

	public String getFraseDica() {
		return fraseDica;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public int getId() {
		return id;
	}

}
