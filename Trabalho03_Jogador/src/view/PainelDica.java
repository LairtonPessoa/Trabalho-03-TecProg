package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.GerenciadorCliente;

public class PainelDica extends JPanel{

	private JTextField barra;
	private JButton enviar;
	private JPanel paineldica;
	private PainelJogadorVez painelcartas;

	public PainelDica() {
		this.add(paineldica());
		this.setBackground(null);
	}

	//Painel da dica
	public JPanel paineldica() {
		paineldica = new JPanel();

		barra = new JTextField();
		barra.setPreferredSize(new Dimension(325,40));
		barra.setEditable(true);
		//barra.getDocument().addDocumentListener(new acaoBarra());

		enviar = new JButton("Enviar");
		enviar.setEnabled(true);
		enviar.setPreferredSize(new Dimension(125,40));

		paineldica.setLayout(new FlowLayout());
		paineldica.setPreferredSize(new Dimension(460,50));
		paineldica.setBackground(null);

		paineldica.add(barra);
		paineldica.add(enviar);

		return paineldica;
	}

	public JTextField getBarra() {
		return barra;
	}

	public JButton getEnviar() {
		return enviar;
	}
	
}