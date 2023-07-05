package negocio;

import java.util.ArrayList;
import java.util.Random;

public class GerenciadorDeJogo {
	
	private ArrayList<Jogador> listaJogadores;

	public GerenciadorDeJogo() {

		// crio uma coneção com os jogadores
		if (jogadoresProntos()) {
			comecarJogo();
		}
	}

	private void comecarJogo() {
		sortCartas();
		sortJogadorDaVez();
		jogo();
	}

	private void jogo() {
		
		//Sempre enviar as informações de todas as alterações para os jogadores
		while (!isFimDoJogo()) {
			mostrarTelas(new Jogador(0));
			// Espero o jogador clicar na tela e enviar a carta e a dica
			exibirDica();
			// espero os jogadores clicarem na tela e enviarem a carta
			exibirCartasComDica();
			// espero os jogadores escolherem a carta
			exibirResultadosDaRodada();
		}
	}

	private boolean jogadoresProntos() {

		// se os jogadores estiverem prontos:
		return true;
		// se nao estiverem prontos:
		// return false;
	}

	private Jogador sortJogadorDaVez() {

		// usa a classe random para sortear um jogador da vez e retorna um jogador ou
		// entao um id
		Random aleatorio = new Random();
		int idJogadorDaVez = aleatorio.nextInt(4);

		if (listaJogadores.get(idJogadorDaVez).getJaJogou())
			return sortJogadorDaVez();
		return listaJogadores.get(idJogadorDaVez);
		
	}

	private void sortCartas() {
		
		Random aleatorio = new Random();
		//int idDaCarta = aleatorio.nextInt(24);
		//sorteio 6 cartas de forma que as cartas nao se repitam e atribuo elas ao jogador 1, depois ao 2...
		
	}

	private void mostrarTelas(Jogador jogadordavez) {
		// Seto a tela de escolher cartas do jogador da vez como visible
		// jogadorDaVez.tela.setVisible;
		// jogadordavez.PainelDica.setEnable;
		// jogador 1, jogador2, jogador3, jogador 4. set enable painelEspera;
	}

	private void exibirDica() {
		// seto a tela dos jogadores como a tela que aparece a dica e que tem as cartas
		// para eles escolherem
		// seto a tela do jogador da vez para esperar os outros jogadores
	}

	private void exibirCartasComDica() {
		// exibe a tela em que os jogadores vao escolher entre as 4 cartas com base na
		// dica
		// o jogador tem que ter uma excessão para nao poder escolher a própria carta

	}

	private void exibirResultadosDaRodada() {
		calcularPontos();
		// atualizar pontuaçao no painel de pontuação
		// exibe os resultados finais da rodada, a pontuação e quem era o jogador da vez
		// reseto alguns valores necessários, como jogador.jaJogou;
	}

	private void calcularPontos() {
		//determina quais jogadores acertaram ou erraram 
		// calcula os pontos com base nos acertos de cada jogador, de acordo com a regra específica

	}

	private boolean isFimDoJogo() {
		// ou o jogoNaoAcabou()
		for (Jogador jogador : listaJogadores) {
			if (jogador.getPontuacao() > 30) {
				return true;
			}
		}
		return false;
	}

}
