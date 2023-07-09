package controller;

public class Jogada {
	private Jogador jogadorVez;
	private String fraseDica;
	private String cartaEscolhida;
	private int pontuacao;
	private int id;

	public Jogada(int idJogadorVez ,String fraseDica, String cartaEscolhida, int pontuacao) {
		jogadorVez = new Jogador(idJogadorVez);
		this.fraseDica = fraseDica;
		this.cartaEscolhida = cartaEscolhida;
		this.pontuacao = pontuacao;
	}

	public Jogada() {

		this.fraseDica = "";
		this.cartaEscolhida = "";
		this.pontuacao = 0;
	}

	public String getCartaEscolhida() {
		return cartaEscolhida;
	}

	public String getFraseDica() {
		return fraseDica;
	}

	public Jogador getJogadorVez() {
		return jogadorVez;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public int getId() {
		return id;
	}

}
