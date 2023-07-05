package negocio;

public class Jogador {

	private String nome;
	private int id;
	private int pontuacao;
	private boolean isJogadorDaVez;
	private Boolean jaJogou;
	private Carta cartaEscolhida;

	public Jogador(int id) {
		this.isJogadorDaVez=false;
		this.jaJogou = false;
		this.id = id;
		this.pontuacao=0;
	}
	
	public Boolean getJaJogou() {
		return jaJogou;
	}

	public void setJaJogou(Boolean jaJogou) {
		this.jaJogou = jaJogou;
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
