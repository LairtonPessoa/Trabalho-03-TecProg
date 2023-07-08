package persistencia;

import java.net.Socket;
import java.util.ArrayList;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.*;

import negocio.Gerenciador;
import negocio.Jogador;

import java.awt.*;
import java.awt.event.*;

public class Servidor {
	
	private ServerSocket servSocket;
	private Gerenciador gerenciador;
	private ArrayList<ConexaoJogares> jogadores;
	private static final int maxJogadores = 4;

	public Servidor() {
		try {
			servSocket = new ServerSocket(6000);

		} catch (IOException e) {
			e.printStackTrace();
		}
		gerenciador = new Gerenciador(this);
	}

	public void iniciar(Gerenciador control) {
		int contator = 0;
		try {
			while (contator<maxJogadores) {
				Socket novoCliente = servSocket.accept();
				contator++;
				
				ConexaoJogares jogador = new ConexaoJogares(novoCliente, gerenciador);
				Thread thread = new Thread(jogador);
				thread.start();
				
			}
		} catch (Exception e) {
		}

	}

	public void enviarMensagem(String t2) {
		try {
			PrintStream saida = new PrintStream(socket1.getOutputStream());
			saida.println(t2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

