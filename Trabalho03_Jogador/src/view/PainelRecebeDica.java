package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelRecebeDica extends JPanel{

	private JButton enviarrecebe;
	private JLabel texto;	
	private JLabel dicarecebida;
	private JPanel paineldicarecebida;
	
	public PainelRecebeDica() {
		
		texto = new JLabel("Dica:");
		texto.setForeground(Color.black);
		enviarrecebe = new JButton("Enviar");
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/squealer.ttf"));
			Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/squealer.ttf"));
            font = font.deriveFont(Font.PLAIN, 38);
            font2 = font2.deriveFont(Font.PLAIN, 15);

            texto.setFont(font);
            enviarrecebe.setFont(font2);
        } catch (FontFormatException | IOException e) {
           e.printStackTrace();
        }
		enviarrecebe.setPreferredSize(new Dimension(125,40));

		this.setPreferredSize(new Dimension(470,53));
		this.setBackground(Color.white);
		
		this.add(texto);
		this.add(painelDicaRecebida());
		this.add(enviarrecebe);
	}

	public JPanel painelDicaRecebida() {
		
		paineldicarecebida = new JPanel();
		dicarecebida = new JLabel(" Mermao essse aqui é o diabo doido");
		dicarecebida.setForeground(Color.black);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\LilitaOne-Regular.ttf"));
            font = font.deriveFont(Font.PLAIN, 13);
        
            dicarecebida.setFont(font);
        } catch (FontFormatException | IOException e) {
           e.printStackTrace();
        }
		paineldicarecebida.setPreferredSize(new Dimension(250,20));
		paineldicarecebida.setLayout(new BorderLayout());
		paineldicarecebida.setBackground(Color.white);
		paineldicarecebida.setLayout(new BorderLayout());
		
		paineldicarecebida.add(dicarecebida, BorderLayout.CENTER);
	
		return paineldicarecebida;
	}
	
	public JLabel getTexto() {
		return texto;
	}

	public JLabel getDicarecebida() {
		return dicarecebida;
	}

	public void setDicarecebida(JLabel dicarecebida) {
		this.dicarecebida = dicarecebida;
	}
}

