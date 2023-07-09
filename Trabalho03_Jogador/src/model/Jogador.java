package model;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.GerenciadorCliente;

public class Jogador {

	private GerenciadorCliente controlador;
	private String nome;
	private Socket jogador;
	private static final int PORT = 6000;

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

		//	controlador.activeTelaDeEspera();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

	}

}