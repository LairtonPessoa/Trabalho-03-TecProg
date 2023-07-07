package negocio;

import java.util.ArrayList;
import java.util.Random;
import persistencia.Servidor;
import visualizacao.TelaDoJogadorDaVez;

public class Gerenciador {
	
	private ArrayList<Jogador> listaJogadores;
	private Servidor server;

	public Gerenciador(Servidor server) {
		this.server = server;
		
		// crio uma coneção com os jogadores
		this.listaJogadores = new ArrayList<Jogador>();

		
		if (jogadoresProntos()) {
			comecarJogo();
		}
	}

	private void comecarJogo() {
		sortCartas();
		
		jogo();
	}

	private void jogo() {
		
		//Sempre enviar as informações de todas as alterações para os jogadores
		while (!isFimDoJogo()) {
			
			Jogada jogada = new Jogada();
			sortJogadorDaVez();
			
			mostrarTelas(new Jogador(0));
			// Espero o jogador clicar na tela e enviar a carta e a dica
			exibirDica();
			// espero os jogadores clicarem na tela e enviarem a carta
			exibirCartasComDica();
			// espero os jogadores escolherem a carta
			salvarDadosJogada(jogada);
			exibirResultadosDaRodada();
		}
	}

	private void salvarDadosJogada(Jogada jogada) {
		
	}

	private boolean jogadoresProntos() {

		// se os jogadores estiverem prontos:
		return true;
		// se nao estiverem prontos:
		// return false;
	}

	private Jogador sortJogadorDaVez() {

		Random aleatorio = new Random();
		int idJogadorDaVez = aleatorio.nextInt(4);

		if (listaJogadores.get(idJogadorDaVez).getJaJogouNaRodada())
			return sortJogadorDaVez();
		return listaJogadores.get(idJogadorDaVez);
		
	}

	private void sortCartas() {
		ArrayList<Integer> idDasCartas = sortIdCartas();
		
	}
	
	public ArrayList<Integer> sortIdCartas() {
        
        Random random = new Random();
        ArrayList<Integer> numerosSort = new ArrayList<>();
        ArrayList<Integer> numerosDisponiveis = new ArrayList<>();
        
        for (int i = 1; i <= 24; i++) {
            numerosDisponiveis.add(i);
        }
        
        while (!numerosDisponiveis.isEmpty()) {
            int indiceSorteado = random.nextInt(numerosDisponiveis.size());
            int numeroSorteado = numerosDisponiveis.remove(indiceSorteado);
            numerosSort.add(numeroSorteado);
        }
        
        return numerosSort;
    }
	
	

	private void mostrarTelas(Jogador jogadordavez) {
		// Seto a tela de escolher cartas do jogador da vez como visible
		// jogadorDaVez.tela.setVisible;
		// jogadordavez.PainelDica.setEnable;
		// jogador 1, jogador2, jogador3, jogador 4. set enable painelEspera;
		//botao vai alterar os valores da jogada
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
			if (jogador.getPontuacao() >= 30) {
				return true;
			}
		}
		return false;
	}

}
