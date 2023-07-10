package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.GerenciadorCliente;

public class TelaDoJogo extends JFrame{
	
	private PainelMenu painelMenu;
	private PainelJogadorVez painelJogadorVez;
	private PainelEspera painelEspera;
	private PainelIndividualJogador painelIndividual;
	private GerenciadorCliente gerenciadorCliente;
	private CardLayout cardLayout;
	
	public TelaDoJogo(GerenciadorCliente gerenciadorCliente) {
		
		this.setTitle("É hora do duelo !");
		this.setSize(530,510);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);

		this.gerenciadorCliente = gerenciadorCliente;
		this.painelMenu = new PainelMenu();
		this.painelEspera = new PainelEspera();
		this.painelIndividual = new PainelIndividualJogador();		
		this.painelJogadorVez = new PainelJogadorVez(gerenciadorCliente);
		this.painelMenu.getJogar().addActionListener(new acaoJogar());
		this.painelJogadorVez.painelDica.getEnviar().addActionListener(new acaoEnviar());
		
		this.add(painelEspera, "painelEspera");
		this.add(painelIndividual, "painelIndividual");
		this.add(painelJogadorVez,"painelJogadorVez");
		this.add(painelMenu, "painelMenu");
		cardLayout.show(getContentPane(), "painelMenu");
		
		ImageIcon icon = new ImageIcon("icons_menu\\enigmadomilenio.png");
		setIconImage(icon.getImage());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public PainelMenu getPainelMenu() {
		return painelMenu;
		
	}
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}
	
	public PainelJogadorVez getPainelJogadorVez() {
		return painelJogadorVez;
	}

	public void setPainelJogadorVez(PainelJogadorVez painelJogadorVez) {
		this.painelJogadorVez = painelJogadorVez;
	}
	
	private class acaoJogar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			gerenciadorCliente.iniciarJogador("Nome ai");
			
		}
	}
	
	private class acaoEnviar implements ActionListener{

		String url;
		String dica;
		
		public void actionPerformed(ActionEvent e) {

			url = painelJogadorVez.painelCartas.cartaSelecionada.getIcon().toString();
			dica = painelJogadorVez.painelDica.getBarra().getText();
			System.out.println(url);
			System.out.println(dica);
			/*
			 * Pegar o texto escrito na barra, pegar a url da carta selecionada, chamar metodo do controlador de enviar a mensagem(dica;url;"enviouDica")
			 * Guardar as coisas em arquivo
			 */
		}
	}
}