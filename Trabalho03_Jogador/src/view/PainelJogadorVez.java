package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
	
import controller.GerenciadorCliente;

public class PainelJogadorVez extends JPanel{

	private GerenciadorCliente controlador;

	JButton cartaSelecionada;
	PainelDica paineldica;
	PainelCartas painelcartas;
	
	public PainelJogadorVez(GerenciadorCliente controlador) {
		paineldica = new PainelDica();
		painelcartas = new PainelCartas();
		paineldica.getEnviar().addActionListener(new acaoEnviar());
		this.controlador=controlador;
		this.setBackground(Color.black);
		this.add(painelcartas);
		this.add(paineldica);
	}

	private class  acaoEnviar implements ActionListener{ 
	
		public void actionPerformed(ActionEvent e) {
			String mensagem = paineldica.getBarra().getText();
			controlador.enviarMensagem(mensagem);			
		}
	}
}

