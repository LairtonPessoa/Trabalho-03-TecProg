package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

import controller.ControladorDoJogo;

public class ThreadServidor implements Runnable {

	private Socket jogador;
	private ControladorDoJogo controlador;

	protected ThreadServidor(Socket s, ControladorDoJogo c) {
		jogador = s;
		controlador = c;
	}

	public void run() {
		
		try {	
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jogador.getInputStream()));
			
			while (true) {
				if(!jogador.isClosed()) {
					String mensagem[] = bufferedReader.readLine().split(";");
					String momentoDoJogo = mensagem[mensagem.length - 1];
			
					if (momentoDoJogo.equals("enviouDica")) {
						//controlador.salvarDadosInicioJogada(mensagem[1], mensagem[0]);
						controlador.distribuirDica(mensagem[0], mensagem[1]);
					} else if (momentoDoJogo.equals("enviouCarta")) {
						controlador.salvarCartaEscolhida(mensagem[0]);
					//	controlador.enviarTodasAsCartasParaOSocket(jogador);
					}
				}else if(jogador.isClosed()){
					//controlador.removerJogador(jogador);
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}

