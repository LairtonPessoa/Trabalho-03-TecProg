package controller;

import java.io.BufferedWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.WriteAbortedException;
import java.io.Writer;
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

	public void setJogador(JogadorCliente jogador) {
		this.jogador=jogador;
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
	
}