package negocio;

public class Jogada {
	private String cartaEscolhidaJogadorVez;
	private String jogadorVez;
	private String fraseDica;
	private String cartaEscolhida;
	private int pontuacao;
	private int id;
	
	public Jogada(String cartaEscolhidaJogadorVez, String jogadorVez, String fraseDica, String cartaEscolhida, int pontuacao) {
		super();
		this.cartaEscolhidaJogadorVez = cartaEscolhidaJogadorVez;
		this.jogadorVez = jogadorVez;
		this.fraseDica = fraseDica;
		this.cartaEscolhida = cartaEscolhida;
		this.pontuacao = pontuacao;
	}
	public String getCartaEscolhida() {
		return cartaEscolhidaJogadorVez;
	}
	public String getJogadorVez() {
		return jogadorVez;
	}
	public String getFraseDica() {
		return fraseDica;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public String getCartaEscolhidaJogadorVez() {
		return cartaEscolhidaJogadorVez;
	}
	public int getId() {
		return id;
	}
	
}
