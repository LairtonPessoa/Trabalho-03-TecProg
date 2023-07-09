package controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import controller.*;
import model.*;

public class ControladorDoJogo {
	private ArrayList<Jogador> listaJogadores;
	private CartasDAO cartasDAO;

	public ControladorDoJogo() {
		
		cartasDAO = new CartasDAO();
		this.listaJogadores = new ArrayList<Jogador>();
		
		if (jogadoresProntos()) {
			comecarJogo();
		}
	}

	private void comecarJogo() {
		distribuirCartas();
		
		jogo();
	}

	private void jogo() {
		
		//Sempre enviar as informações de todas as alterações para os jogadores
		while (!isFimDoJogo()) {
			
			Jogada jogada = new Jogada();
			sortJogadorDaVez();
			
			mostrarTelas();
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
		
		if(listaJogadores.size()==4)
			return true;
		
		return false;
	}

	private Jogador sortJogadorDaVez() {

		Random aleatorio = new Random();
		int idJogadorDaVez = aleatorio.nextInt(4);

		if (listaJogadores.get(idJogadorDaVez).getJaJogouNaRodada())
			return sortJogadorDaVez();
		return listaJogadores.get(idJogadorDaVez);
		
	}

	private void distribuirCartas() {
		ArrayList<Integer> idDasCartas = sortIdCartas();
		
		for(Jogador jogador : listaJogadores) {
			for(int i = 0; i<6; i++) {
				//jogador.getListaCartas().add(cartasDAO.pegarCartas().get(i));
			}
		}
		
	}
	
	private ArrayList<Integer> sortIdCartas() {
        
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

	private void mostrarTelas() {
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
	
	public void adicionarJogadores(String nome) {
		
		int maiorId = 0;
		
		for(Jogador jogadores : listaJogadores) {
	
			if(jogadores.getId()>maiorId)
				maiorId= jogadores.getId();
			
		}
		
		Jogador jogador = new Jogador(maiorId+1);
		listaJogadores.add(jogador);
	}

	public void distribuirDica(String dica, Socket jogador) {
		try {
	        Writer writer = new OutputStreamWriter(jogador.getOutputStream());
	        BufferedWriter bufferedWriter = new BufferedWriter(writer);

	        bufferedWriter.write(dica);
	        bufferedWriter.newLine();
	        bufferedWriter.flush();

	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	}
}
