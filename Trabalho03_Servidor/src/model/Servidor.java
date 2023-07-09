package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import controller.ControladorDoJogo;

public class Servidor {

	private ControladorDoJogo controlador;
	private ServerSocket servidor;
	private ArrayList<Socket> jogadores;
	private static final int PORT = 9990;
	private static final int maxPlayers = 4;

	public Servidor(ControladorDoJogo controlador) {
		this.controlador = controlador;
		try {
			servidor = new ServerSocket(PORT);
			jogadores = new ArrayList<Socket>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void conectarRede() {
		int cont = 0;

		while (cont < maxPlayers) {
			try {
				Socket jogador = servidor.accept();
				jogadores.add(jogador);
				System.out.println("player conectado");
				cont++;
				Thread thread = new Thread(new ThreadServidor(jogador, controlador));
				thread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
