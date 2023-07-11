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
	

	public void comecarJogo(Socket jogador) {
		
		enviarMensagem("HoraDoDuelo", jogador);
		//jogo();
		//sortJogadorDaVez();
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
		for (JogadorServidor jogador : listaJogadores) {
			this.enviarMensagem(dica+";dica", jogador.getSocket());
		}
		
	}

	public void salvarCartaEscolhida(String url) {
		ArrayList<String> listaUrl = new ArrayList<String>();
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
		
		try {
	        Writer writer = new OutputStreamWriter(jogador.getOutputStream());
	        BufferedWriter bufferedWriter = new BufferedWriter(writer);

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
					jogadaDAO.update(jogada);
					jogada = jogadaDAO.selecionarJogada(jogada);
					this.enviarMensagem(jogador.getPontuacao()+ ";" + jogada.getCartaVez() + ";" + jogada.getFraseDica() + ";" + jogada.getJogadorVez().getId() +";pontuacao", socket);
				}
			}
		}else{
			for (JogadorServidor jogador : listaJogadores) {
				if(jogador.getSocket() == socket) {
					jogador.setPontuacao(jogador.getPontuacao() - 1);
					jogadaDAO.update(jogada);
					jogada = jogadaDAO.selecionarJogada(jogada);
					this.enviarMensagem(jogador.getPontuacao()+ ";" + jogada.getCartaVez() + ";" + jogada.getFraseDica() + ";" + jogada.getJogadorVez().getId() +";pontuacao", socket);
				}
			}
		}
		
	}
}
