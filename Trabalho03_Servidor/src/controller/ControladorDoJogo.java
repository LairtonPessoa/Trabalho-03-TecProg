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
	private JogadaDAO jogadaDAO;
	private ArrayList<Carta> cartasDoJogo;
	private Jogada jogada;
//	private ArrayList<Socket> sockets;
	
	public ControladorDoJogo() {
		
//		this.sockets = new ArrayList<Socket>();
		this.jogada = new Jogada();
		this.listaJogadores = new ArrayList<JogadorServidor>();
		this.cartasDoJogo = new ArrayList<Carta>();
		this.cartasDAO = new CartasDAO();
		this.jogadaDAO = new JogadaDAO();
		
	}

	public void salvarDadosInicioJogada(String url, String dica) {
		//jogada = new Jogada();
		jogada.setCartaVez(url);
		jogada.setFraseDica(dica);
		for (JogadorServidor jogador  : listaJogadores) {
			if(jogador.isJogadorDaVez()) {
				jogada.setJogadorVez(jogador);
			}
		}
		jogadaDAO.inserir(jogada);
	}
	
	/*public Carta procurarCarta(String url) {
		for (Carta carta : cartasDoJogo) {
			if(carta.getIconeFrenteDaCarta().toString().equals(url)) {
				return carta;
			}
		}
		return null;
	}*/

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

			exibirResultadosDaRodada();
			
			restaurarJogadores();
		}
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

	public void distribuirDica(String dica, String urlCartaDaVez) {
		/*Este metodo recebe a dica a ser enviada para cada socket,
		 *e recebe o socket que irá receber a dica, assim enviara a 
		 *dica para o socket indicado e tambem  pode receber a string 
		 *da url da carta da vez para poder salvala no banco.
		 */
		for (JogadorServidor jogador : listaJogadores) {
			this.enviarMensagem(dica+";dica", jogador.getSocket());
		}
		
	}

	public void salvarCartaEscolhida(String url) {
		//ArrayList<String> listaUrl = new ArrayList<String>();
		cartasDAO.inserir(url);
		ArrayList<String> listaCartaOutrosJogadoresBanco = new ArrayList<String>();
		for (String string : cartasDAO.selecionarCartas()) {
			if(!listaCartaOutrosJogadoresBanco.contains(string)) {
				listaCartaOutrosJogadoresBanco.add(string);
				//listaUrl.add(url);
			}
		}
		jogada.setCartasDosOutrosJogadores(listaCartaOutrosJogadoresBanco);
		
		if(jogada.getCartasDosOutrosJogadores().size()==3) {
			//for (String string : listaUrl) {
				//cartasDAO.deletar(string);
			//}
			ArrayList<String> cartasJogadaAux = jogada.getCartasDosOutrosJogadores();
			cartasJogadaAux.add(jogada.getCartaVez());
			
			Collections.shuffle(cartasJogadaAux);
			
			String cartasDaJogada="";
			for (String cartas : cartasJogadaAux) {
				cartasDaJogada += cartas + ";";
				
			}
			for (JogadorServidor jogador : listaJogadores) {
				enviarMensagem(cartasDaJogada + jogada.getFraseDica() + ";" + "telaDeAdivinhacao", jogador.getSocket());
			}
			jogada.getCartasDosOutrosJogadores().clear();
		}
		
	}

	private void instanciarCartas() {
		ArrayList<String> enderecoCartas = cartasDAO.pegarCartas();
		
		for(int i = 0; i<24; i++) {
			Carta carta = new Carta(i);
			carta.setIconeFrenteDaCarta(new ImageIcon(enderecoCartas.get(i)));
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

	public void computarPontos(String url, Socket socket) {
		if(url.equals(jogada.getCartaVez())) {
			for (JogadorServidor jogador : listaJogadores) {
				if(jogador.getSocket() == socket) {
					jogador.setPontuacao(jogador.getPontuacao()+2);
					this.enviarMensagem(jogador.getPontuacao()+";pontuacao", socket);
				}
			}
		}else{
			this.enviarMensagem(0+";pontuacao", socket);
		}
		
	}
}
