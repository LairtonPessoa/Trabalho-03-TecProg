package visualizacao;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import negocio.Gerenciador;
import persistencia.Servidor;

public class TelaDoJogadorDaVez extends JFrame{
	
	private Gerenciador gerenciador;
	
	public TelaDoJogadorDaVez(Gerenciador gerenciadorDeJogo) {
		
		gerenciador = new Gerenciador(new Servidor());
		
		this.setLayout(new BorderLayout());
		this.setSize(530,510);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(new PainelBotoesCartas(), BorderLayout.CENTER);
		this.add(new PainelDica(), BorderLayout.SOUTH);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private static class Main {
		 public static void main(String[] args) {
	     //new TelaDoJogadorDaVez();	
	     }
	}
       
}

