package negocio;

public class Jogada {
	private String jogadorVez;
	private String fraseDica;
	private String cartaEscolhida;
	private int pontuacao;
	private int id;
	
	public Jogada(String jogadorVez, String fraseDica, String cartaEscolhida, int pontuacao) {
		super();
		this.jogadorVez = jogadorVez;
		this.fraseDica = fraseDica;
		this.cartaEscolhida = cartaEscolhida;
		this.pontuacao = pontuacao;
	}
	public String getCartaEscolhida() {
		return cartaEscolhida;
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
	public int getId() {
		return id;
	}
	
}
