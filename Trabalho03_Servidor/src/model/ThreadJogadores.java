package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

import controller.Controlador;

public class ThreadJogadores implements Runnable {

	private Socket jogador;
	private Controlador controlador;

	protected ThreadJogadores(Socket s, Controlador c) {
		jogador = s;
		controlador = c;
	}

	public void run() {
		try {
			Reader reader = new InputStreamReader(jogador.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(reader);

			String mensagem[] = bufferedReader.readLine().split(";");
			String momentoDoJogo = mensagem[mensagem.length - 1];

			if (momentoDoJogo.equals("enviouDica")) {
				controlador.distribuirDica(mensagem[0], jogador);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}