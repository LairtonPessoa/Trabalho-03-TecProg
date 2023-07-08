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

import controller.Controlador;

public class PainelDica extends JPanel implements ActionListener{

	JTextField barra;
	JButton enviar;
	JPanel paineldica;
	PainelBotoesCartas painelcartas;
	private Controlador controlador;
		
	public PainelDica(Controlador controlador) {
		this.controlador=controlador;
		this.add(paineldica());
		this.setBackground(new Color(100,149,237,70));
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
		enviar.addActionListener(this);

		paineldica.setLayout(new FlowLayout());
		paineldica.setPreferredSize(new Dimension(460,50));
		paineldica.setBackground(new Color(100,149,237,70));

		paineldica.add(barra);
		paineldica.add(enviar);

		return paineldica;
	}

	
	public void actionPerformed(ActionEvent e) {
		String mensagem = barra.getText();
		controlador.enviarMensagem(mensagem);
		
	}

	
	
	
	
}
