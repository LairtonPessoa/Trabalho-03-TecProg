package model;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.Controlador;

public class Jogador {

	private Controlador controlador;
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

	public void joinConection(String host, Controlador c) {
		try {
			jogador = new Socket(host, PORT);
			controlador = c;
			
		//	controlador.activeTelaDeEspera();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
	}
	
}
