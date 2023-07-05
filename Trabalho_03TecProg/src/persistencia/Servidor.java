package persistencia;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.*;

import negocio.GerenciadorDeJogo;

import java.awt.*;
import java.awt.event.*;

public class Servidor {

	BufferedReader leitor;
	PrintWriter w;
	private Socket socket1;

	private ServerSocket servSocket;

	public Servidor() {
		try {
			servSocket = new ServerSocket(6000);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void configuraRede(GerenciadorDeJogo control) throws Exception {
		try {
			String texto = null;
			socket1 = servSocket.accept();
			BufferedReader leitor = new BufferedReader(new InputStreamReader(socket1.getInputStream()));

			while (true) {

				if ((texto = leitor.readLine()) != null) {
					System.out.println("entrou");
					control.receberMensagens(texto);
				}
			}
		} catch (IOException e) {
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

