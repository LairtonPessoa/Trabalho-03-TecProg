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

public class PainelEnviarDica extends JPanel{

	private JTextField barra;
	private JButton enviar;
		
	public PainelEnviarDica() {

		barra = new JTextField();
		barra.setPreferredSize(new Dimension(325,40));
		barra.setEditable(false);
		//barra.getDocument().addDocumentListener(new acaoBarra());

		enviar = new JButton("Enviar");
		enviar.setEnabled(false);
		enviar.setPreferredSize(new Dimension(125,40));

		this.add(barra);
		this.add(enviar);		
		this.setBackground(null);
	}

	public JTextField getBarra() {
		return barra;
	}

	public JButton getEnviar() {
		return enviar;
	}
	
}