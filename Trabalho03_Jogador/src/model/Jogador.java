package model;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.GerenciadorCliente;

public class Jogador {

	private GerenciadorCliente controlador;
	private String nome;
	private Socket jogador;
	private static final int PORT = 9990;

	public Jogador(String nome) {
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}

	public Socket getJogador() {
		return jogador;
	}

	public void joinConection(String host, GerenciadorCliente c) {
		try {
			jogador = new Socket(host, PORT);
			controlador = c;
			Thread thread = new Thread(new ThreadJogador(jogador, c));
			thread.start();
			

		//	controlador.activeTelaDeEspera();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}