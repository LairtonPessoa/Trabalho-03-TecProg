package negocio;

public class Jogador {

	private boolean isJogadorDaVez;
	private int id;
	private String nome;
	private int pontuacao;
	private Carta cartaEscolhida;

	public Jogador(int id) {
		this.isJogadorDaVez=false;
		this.id = id;
		this.pontuacao=0;
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


	
}
