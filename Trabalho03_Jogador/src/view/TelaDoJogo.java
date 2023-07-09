package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.GerenciadorCliente;

public class TelaDoJogo extends JFrame{
	
	private PainelMenu painelMenu;
	
	public TelaDoJogo(GerenciadorCliente controlador) {
		
		this.setTitle("É hora do duelo !");
		this.setLayout(new BorderLayout());
		this.setSize(530,510);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.painelMenu = new PainelMenu();
		//this.add(new PainelBotoesCartas(), BorderLayout.CENTER);
		//this.add(new PainelDica(controlador), BorderLayout.SOUTH);
		this.add(painelMenu, BorderLayout.CENTER);
		
		ImageIcon icon = new ImageIcon("icons\\enigmadomilenio.png");
		setIconImage(icon.getImage());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}