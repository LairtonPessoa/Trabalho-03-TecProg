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
		
		//this.add(painelEspera);
		//this.add(painelIndividual);
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
			
			if(gerenciadorCliente.getJogador().isJogadorDaVez()) {
				
			}
		}
	}
	
	private class acaoEnviar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
	
		}
	}
}