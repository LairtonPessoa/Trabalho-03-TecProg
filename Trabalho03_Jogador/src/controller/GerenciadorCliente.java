package controller;

import java.io.BufferedWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.WriteAbortedException;
import java.io.Writer;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Jogador;
import view.TelaDoJogo;

public class GerenciadorCliente {

	private JFrame telaDeEspera;
	private Jogador jogador;
	private TelaDoJogo tela;

	public GerenciadorCliente() {
//		telaDeEspera = new JFrame();
//		telaDeEspera.add(new JLabel("Aguarde..."));
//		telaDeEspera.setSize(600,600);
//		telaDeEspera.setVisible(false);
		
		jogador = new Jogador("Rayssa");
		jogador.joinConection("localhost", this);
		tela = new TelaDoJogo(this);
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

	        bufferedWriter.close();
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}