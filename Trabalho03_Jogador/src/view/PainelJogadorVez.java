package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.GerenciadorCliente;

public class PainelJogadorVez extends JPanel{

	private GerenciadorCliente controlador;
	public PainelEnviarDica painelDica;
	public PainelCartasVez painelCartas;
	
	public PainelJogadorVez(GerenciadorCliente controlador) {
		painelDica = new PainelEnviarDica();
		painelCartas = new PainelCartasVez(painelDica);
		//painelDica.getEnviar().addActionListener(new AcaoEnviar());
		this.controlador=controlador;
		this.setBackground(Color.black);
		
		this.add(painelCartas);
		this.add(painelDica);
	}

	/*private class  AcaoEnviar implements ActionListener{ 
	
		public void actionPerformed(ActionEvent e) {
			String mensagem = painelDica.getBarra().getText() + ";enviouDica";
			controlador.enviarMensagem(mensagem);			
		}
	}*/
}

