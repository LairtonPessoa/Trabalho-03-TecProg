package visualizacao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PainelDica extends JPanel{

	JTextField barra;
	JButton enviar;
	JPanel paineldica;
	PainelBotoesCartas painelcartas;
		
	public PainelDica() {
		this.add(paineldica());
		this.setBackground(new Color(100,149,237,70));
	}
	
	//Painel da dica
	public JPanel paineldica() {
		paineldica = new JPanel();

		barra = new JTextField();
		barra.setPreferredSize(new Dimension(325,40));
		barra.setEditable(false);
		//barra.getDocument().addDocumentListener(new acaoBarra());

		enviar = new JButton("Enviar");
		enviar.setEnabled(false);
		enviar.setPreferredSize(new Dimension(125,40));

		paineldica.setLayout(new FlowLayout());
		paineldica.setPreferredSize(new Dimension(460,50));
		paineldica.setBackground(new Color(100,149,237,70));

		paineldica.add(barra);
		paineldica.add(enviar);

		return paineldica;
	}
}
