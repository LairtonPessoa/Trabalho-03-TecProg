package visualizacao;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaDoJogadorDaVez extends JFrame{

	public TelaDoJogadorDaVez() {
		
		JButton b1 = new JButton("carta 1");
		JButton b2 = new JButton("carta 2");
		JButton b3 = new JButton("carta 3");
		JButton b4 = new JButton("carta 4");
		JButton b5 = new JButton("carta 5");
		JButton b6 = new JButton("carta 6");
		JTextField caixaDeTexto = new JTextField(30);
		JButton enviarDica = new JButton("Enviar Dica");
		
		this.setLayout(new FlowLayout());
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		this.add(b6);
		this.add(caixaDeTexto);
		this.add(enviarDica);
		
		setSize(800,600);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
