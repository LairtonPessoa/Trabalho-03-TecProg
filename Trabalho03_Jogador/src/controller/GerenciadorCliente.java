package controller;

import java.awt.Component;
import java.awt.Graphics;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.WriteAbortedException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.JogadorCliente;
import view.TelaDoJogo;

public class GerenciadorCliente {

	private JogadorCliente jogador;
	private TelaDoJogo tela;

	public GerenciadorCliente() {
		tela = new TelaDoJogo(this);
		 
	}

	public void iniciarJogador(String nome) {
		jogador = new JogadorCliente(nome);
		jogador.joinConection("localhost", this);
		
	}

	public void enviarMensagem(String mensagem) {
	    try {
	        Writer writer = new OutputStreamWriter(jogador.getJogador().getOutputStream());
	        BufferedWriter bufferedWriter = new BufferedWriter(writer);

	        bufferedWriter.write(mensagem);
	        bufferedWriter.newLine();
	        bufferedWriter.flush();

	       
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void exibirDica(String dicaParaSerRepassada) {
		/*metodo que vai altterar a tela para a proxima etapa do jogo
		 *aqui vai ter que acondecer uma verificação para saber de o jogador 
		 *conectado é o jogador da vez, pois se for o jogador da vez ele
		 *ficará numa tela de aguarde, pois este metodo sera utilizado quando
		 *o servidor enviar a dica do jogador da vez para todos os outros,
		 *ai se nao for o jogador da vez ele ficara na tela de escolha dos outros 
		 *jogadores para escolher uma carta com base na dica passada.
		 */
		
		
	}

	public void iniciarJogo() {
		
		if(jogador.isJogadorDaVez()) {
			tela.getCardLayout().show(tela.getContentPane(), "painelJogadorVez");
		}else {
			tela.getCardLayout().show(tela.getContentPane(), "painelEspera");
		}
		
	}

	public void distribuirCartas(String[] cartas) {
		ArrayList<ImageIcon> listaIcones = new ArrayList<>();
		ArrayList<String> listaCartas =	new ArrayList<>(Arrays.asList(cartas));
		
		for(String urlCartas : listaCartas){
			listaIcones.add(new ImageIcon(urlCartas));
			
			System.out.println(urlCartas);
		}
		
		/* Aqui eu fiz manual e adicionei os parametros pq nao precisa separar denovo, ja esta separando la na
		 * threadJogador,
		 */
		//listaIcones.add(new ImageIcon(carta1));
		//listaIcones.add(new ImageIcon(carta2));
		//listaIcones.add(new ImageIcon(carta3));
		//listaIcones.add(new ImageIcon(carta4));
		//listaIcones.add(new ImageIcon(carta5));
		//listaIcones.add(new ImageIcon(carta6));
		
		
		
		//System.out.println(carta1+" " + carta2+" " +carta3+" "+carta4+" "+carta5+" "+carta6+" ");
		tela.getPainelJogadorVez().painelcartas.setIconesBotoes(listaIcones);
	}
	
	public ArrayList<String> separarString(String string, String delimitador) {
        String[] camposSeparados = string.split(delimitador);
        ArrayList<String> campos = new ArrayList<>(Arrays.asList(camposSeparados));
        return campos;
    }
	
	
	public void setJogador(JogadorCliente jogador) {
		this.jogador=jogador;
	}
	public JogadorCliente getJogador() {
		return jogador;
	}

	
}