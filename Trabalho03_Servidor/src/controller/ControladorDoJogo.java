package controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import controller.*;
import model.*;

public class ControladorDoJogo {

	private ArrayList <JogadorServidor> listaJogadores;
	private CartasDAO cartasDAO;
	private ArrayList<Carta> cartasDoJogo;
//	private ArrayList<Socket> sockets;
	
	public ControladorDoJogo() {
		
//		this.sockets = new ArrayList<Socket>();
		this.listaJogadores = new ArrayList<JogadorServidor>();
		this.cartasDoJogo = new ArrayList<Carta>();
		this.cartasDAO = new CartasDAO();
		
	}

	public void salvarDadosInicioJogada(String url, String dica) {
		Jogada jogada = new Jogada();
		jogada.setCartaVez(url);
		jogada.setFraseDica(dica);
		
		cartasDAO.inserir(procurarCarta(url), jogada);
	}
	
	public Carta procurarCarta(String url) {
		for (Carta carta : cartasDoJogo) {
			if(carta.getIconeFrenteDaCarta().toString() == url) {
				return carta;
			}
		}
		return null;
	}

	public void comecarJogo(Socket jogador) {
		/* Aqui comentei a parte de distribuir pois o metodo distribuir ja envia
		 * para os 4 o baralho de uma vez, e este metodo vai ser chamado para 
		 * cada socket individual, e comentei o metodo jogo() pq fica num laço
		 * infinito e nunca atualiza os outros jogadores, esse metodo jogo() 
		 * seria para a implementação em 1 unico projeto. 
		 */
		
		enviarMensagem("HoraDoDuelo", jogador);
		//jogo();
		//sortJogadorDaVez();
	}

	private void jogo() {
		
		while (!isFimDoJogo()) {
			
			Jogada jogada = new Jogada();
			sortJogadorDaVez();
			mostrarTelas();

			salvarDadosJogada(jogada);
			exibirResultadosDaRodada();
			
			restaurarJogadores();
		}
	}

	private void salvarDadosJogada(Jogada jogada) {
		
	}

	public void sortJogadorDaVez() {

		int idJogadorVez = sortIdJogador();
		listaJogadores.get(idJogadorVez).setJogadorDaVez(true);
		
		enviarMensagem("JogadorDaVez", listaJogadores.get(idJogadorVez).getSocket());

	}
	
	private int sortIdJogador() {
		Random aleatorio = new Random();
		int idJogadorDaVez = aleatorio.nextInt(4);
		
		if(listaJogadores.get(idJogadorDaVez).getJaJogouNaRodada()) {
			return sortIdJogador();
		}
		return idJogadorDaVez;
		
	}
	
	private void restaurarJogadores() {
		for(JogadorServidor jogador : listaJogadores) {
			jogador.setJaJogouNaRodada(false);
		}
	}

	public void distribuirCartas() {
		/* aqui chamei o metodo instanciar as cartas pois um erro que estava acontecendo
		 * era que quando atribuia as cartasDoJogo ao baralho auxiliar elas em nenhum
		 * momento do codigo foram criadas, entao adicionei a parte de criar dentro do
		 * metodo instanciarCartas, e a parte de sortId das cartas tambem movi pra la,
		 * mas como n entendi a logica acho que em algum lugar nao esta sendo sorteado, 
		 * pois quando eu dou um print la no cliente as cartas sao iguais e em ordem,
		 * nao mexi muito nessa parte do sortei para nao mexer muito na pate do ryam e 
		 * do Antonio para fazer sentido pra vcs
		 */
		instanciarCartas();
		ArrayList<Carta> baralhoAuxiliar = cartasDoJogo;
		Collections.shuffle(baralhoAuxiliar);

		for(JogadorServidor jogador : listaJogadores) {
			
			String baralhoDoJogador="";
			
			for(int i = 0; i<6 ; i++) {
				Carta carta = baralhoAuxiliar.remove(0);
				jogador.getListaCartas().add(carta);
				
				baralhoDoJogador += cartasDAO.pegarCartas().get(carta.getId())+";";
			}
			enviarMensagem(baralhoDoJogador + "distribuirCartas", jogador.getSocket());
		}
		
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
		for (JogadorServidor jogador : listaJogadores) {
			if (jogador.getPontuacao() >= 30) {
				return true;
			}
		}
		return false;
	}
	
	public void adicionarJogadores(String nome) {
		
		int maiorId = 0;
		
		for(JogadorServidor jogadores : listaJogadores) {
	
			if(jogadores.getId()>maiorId)
				maiorId= jogadores.getId();
			
		}
		
		JogadorServidor jogador = new JogadorServidor(maiorId+1);
		listaJogadores.add(jogador);
	}
	
	public void enviarMensagem(String mensagem, Socket jogador) {
		try {
	        Writer writer = new OutputStreamWriter(jogador.getOutputStream());
	        BufferedWriter bufferedWriter = new BufferedWriter(writer);

	        bufferedWriter.write(mensagem);
	        bufferedWriter.newLine();
	        bufferedWriter.flush();

	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void distribuirDica(String dica, String urlCartaDaVez, Socket jogador) {
		/*Este metodo recebe a dica a ser enviada para cada socket,
		 *e recebe o socket que irá receber a dica, assim enviara a 
		 *dica para o socket indicado e tambem  pode receber a string 
		 *da url da carta da vez para poder salvala no banco.
		 */
		this.enviarMensagem(dica+";dica", jogador);
		
	}

	public void salvarCartaEscolhida(String string) {
		/* Este metodo irá salvar a carta escolhida pelo socket que 
		 * enviou dependendo do momento do jogo que o socket especi-
		 * fico esta, como o jogador da vez n ira enviar a carta dele 
		 * mesmo momento que os outros ela sera salva no banco de dados 
		 * e depois repassada em outro momento, no caso acho que será 
		 * quando o jogador da vez estiver no momento enviouDica que
		 * ele ira enviar 3 coisas, a dica, a string do icone da carta.
		 * 
		 */
		
	}

	private void instanciarCartas() {
		ArrayList<String> enderecoCartas = cartasDAO.pegarCartas();
		//ArrayList<Integer> idDasCartas = sortIdCartas();
		
		for(int i = 0; i<24; i++) {
			Carta carta = new Carta(i);
			carta.setIconeFrenteDaCarta(new ImageIcon(enderecoCartas.get(i)));
			
			//for (Integer idAleatorio : idDasCartas) {
			//	carta.setId(idAleatorio);
			//}
			cartasDoJogo.add(carta);
		}
	}
	
	public ArrayList<JogadorServidor> getListaJogadores() {
		return listaJogadores;
	}



	public void enviarTodasAsCartasParaOSocket(Socket jogador) {

		/* Aqui o controlador deverá ler do banco de dados todas as cartas 
		 * de uma rodada e enviar para todos os  sockets conectados a rede
		 * 
		 */
		
		try {
	        Writer writer = new OutputStreamWriter(jogador.getOutputStream());
	        BufferedWriter bufferedWriter = new BufferedWriter(writer);

	        /* Aqui dentro do bufferedWriter.write devera ter as url das
	         * quatro cartas e o qual é a carta da vez para poder fazer 
	         * a logica la no cliente de acertar a carta ou não por favor
	         * envie cada parte separada por ';' pois este sera o parametro 
	         * para quebrar a string por meio do metodo .split
	         */
	        bufferedWriter.write("");
	        bufferedWriter.newLine();
	        bufferedWriter.flush();

	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	}

	public void setSockets(ArrayList<Socket> sockets) {
		
		
		for (Socket socket : sockets) {
			JogadorServidor jogador = new JogadorServidor(listaJogadores.size()+1);
			jogador.setSocket(socket);
			listaJogadores.add(jogador);
		}
	}


//	public void removerJogador(Socket socket) {
//	for (JogadorServidor jogadorServidor : listaJogadores) {
//		if(jogadorServidor.getSocket()==socket) {
//			jogadorServidor.se
//		}
//	}
//	
//}
}
