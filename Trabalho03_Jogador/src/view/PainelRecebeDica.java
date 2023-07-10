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

	private JButton enviarRecebe;
	private JLabel texto;	
	private JLabel dicaRecebida;
	private JPanel painelDicaRecebida;
	
	public PainelRecebeDica() {
		
		texto = new JLabel("Dica:");
		texto.setForeground(Color.black);
		enviarRecebe = new JButton("Enviar");
		enviarRecebe.setEnabled(false);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/squealer.ttf"));
			Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/squealer.ttf"));
            font = font.deriveFont(Font.PLAIN, 38);
            font2 = font2.deriveFont(Font.PLAIN, 15);

            texto.setFont(font);
            enviarRecebe.setFont(font2);
        } catch (FontFormatException | IOException e) {
           e.printStackTrace();
        }
		enviarRecebe.setPreferredSize(new Dimension(125,40));

		this.setPreferredSize(new Dimension(470,53));
		this.setBackground(Color.white);
		
		this.add(texto);
		this.add(painelDicaRecebida());
		this.add(enviarRecebe);
	}

	public JPanel painelDicaRecebida() {
		
		painelDicaRecebida = new JPanel();
		dicaRecebida = new JLabel(" Mermao essse aqui é o diabo doido");
		dicaRecebida.setForeground(Color.black);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\LilitaOne-Regular.ttf"));
            font = font.deriveFont(Font.PLAIN, 13);
        
            dicaRecebida.setFont(font);
        } catch (FontFormatException | IOException e) {
           e.printStackTrace();
        }
		painelDicaRecebida.setPreferredSize(new Dimension(250,20));
		painelDicaRecebida.setLayout(new BorderLayout());
		painelDicaRecebida.setBackground(Color.white);
		painelDicaRecebida.setLayout(new BorderLayout());
		
		painelDicaRecebida.add(dicaRecebida, BorderLayout.CENTER);
	
		return painelDicaRecebida;
	}
	
	public JLabel getTexto() {
		return texto;
	}

	public JLabel getDicarecebida() {
		return dicaRecebida;
	}

	public void setDicarecebida(JLabel dicarecebida) {
		this.dicaRecebida = dicarecebida;
	}

	public JButton getEnviarrecebe() {
		return enviarRecebe;
	}
	
}

