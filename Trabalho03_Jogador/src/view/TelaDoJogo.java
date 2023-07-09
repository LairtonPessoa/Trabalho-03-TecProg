package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.GerenciadorCliente;

public class TelaDoJogo extends JFrame{
	
	private PainelMenu painelMenu;
	private GerenciadorCliente gerenciadorCliente;
	
	public TelaDoJogo(GerenciadorCliente gerenciadorCliente) {
		
		this.setTitle("É hora do duelo !");
		this.setLayout(new BorderLayout());
		this.setSize(530,510);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.gerenciadorCliente = gerenciadorCliente;
		this.painelMenu = new PainelMenu();
		//this.add(new PainelBotoesCartas(), BorderLayout.CENTER);
		//this.add(new PainelDica(controlador), BorderLayout.SOUTH);
		this.add(painelMenu, BorderLayout.CENTER);
		
		ImageIcon icon = new ImageIcon("icons_menu\\enigmadomilenio.png");
		setIconImage(icon.getImage());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public PainelMenu getPainelMenu() {
		return painelMenu;
	}
	
	private class acaoJogar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			gerenciadorCliente.iniciarJogador("Nome ai");
			
		}
		
	}
}