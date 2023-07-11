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
	private PainelFinalRodada painelFinalRodada;
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
		this.painelFinalRodada = new PainelFinalRodada();
		this.painelJogadorVez = new PainelJogadorVez(gerenciadorCliente);
		this.painelMenu.getJogar().addActionListener(new acaoJogar());
		this.painelIndividual.painelRecebeDica.getEnviarrecebe().addActionListener(new AcaoEnviarInd());
		this.painelJogadorVez.painelDica.getEnviar().addActionListener(new acaoEnviar());
		this.painelFinalRodada.painelTextoFinalRodada.getEnviarfinal().addActionListener(new AcaoVotarCartas());
		
		this.add(painelEspera, "painelEspera");
		this.add(painelIndividual, "painelIndividual");
		this.add(painelJogadorVez,"painelJogadorVez");
		this.add(painelMenu, "painelMenu");
		this.add(painelFinalRodada, "painelFinalRodada");
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
	
	public PainelIndividualJogador getPainelIndividual() {
		return painelIndividual;
	}
	
	public PainelFinalRodada getPainelFinalRodada() {
		return painelFinalRodada;
	}


	private class acaoJogar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			cardLayout.show(getContentPane(), "painelEspera");
			gerenciadorCliente.iniciarJogador("Nome ai");
			
		}
	}
	
	private class acaoEnviar implements ActionListener{
		
		String url;
		String dica;
		public void actionPerformed(ActionEvent e) {
			url = painelJogadorVez.painelCartas.cartaSelecionada.getIcon().toString();
			dica = painelJogadorVez.painelDica.getBarra().getText();
			String mensagem = dica + ";" + url + ";enviouDica";
			gerenciadorCliente.enviarMensagem(mensagem);
		}
	}
	
	private class AcaoEnviarInd implements ActionListener{
		
		String url;
		public void actionPerformed(ActionEvent e) {
			
			cardLayout.show(getContentPane(), "painelEspera");
			
			url = painelIndividual.painelCartasIndividual.cartaSelecionadaind.getIcon().toString();
			String mensagem = url + ";enviouCarta";
			gerenciadorCliente.enviarMensagem(mensagem);
		}
	}
	
	private class AcaoVotarCartas implements ActionListener{

		String url;
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			url = painelFinalRodada.painelCartasRecebidas.cartaSelecionadaind.getIcon().toString();
			String mensagem = url + ";calcularPontos";
			gerenciadorCliente.enviarMensagem(mensagem);
		}
		
	}
}