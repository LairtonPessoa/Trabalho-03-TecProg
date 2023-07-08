package controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.WriteAbortedException;
import java.io.Writer;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Jogador;
import view.TelaDoJogadorDaVez;

public class Controlador {

	private JFrame telaDeEspera;
	private Jogador jogador;

	public Controlador() {
//		telaDeEspera = new JFrame();
//		telaDeEspera.add(new JLabel("Aguarde..."));
//		telaDeEspera.setSize(600,600);
//		telaDeEspera.setVisible(false);
		jogador = new Jogador("Rayssa");
		jogador.joinConection("localhost", this);
		new TelaDoJogadorDaVez(this);

	}

	public void setJogador(Jogador jogador) {
		this.jogador=jogador;
	}

	public void enviarMensagem(String mensagem) {
	    try {
	        Writer writer = new OutputStreamWriter(jogador.getJogador().getOutputStream());
	        BufferedWriter bufferedWriter = new BufferedWriter(writer);

	        bufferedWriter.write(mensagem);
	        bufferedWriter.newLine();
	        bufferedWriter.flush();

	        bufferedWriter.close();-
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}