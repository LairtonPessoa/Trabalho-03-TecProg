package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelTextoFinalRodada extends JPanel{

	private JLabel texto;	
	private JButton enviarfinal;
	
	public PainelTextoFinalRodada() {
		texto = new JLabel("Advinhe qual a carta correta! ");	
		enviarfinal = new JButton("Enviar");
		enviarfinal.setEnabled(false);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\Squealer.ttf"));
			Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\Squealer.ttf"));
            font = font.deriveFont(Font.PLAIN, 25);
            font2 = font2.deriveFont(Font.PLAIN, 16);
            enviarfinal.setFont(font2);
            texto.setFont(font);
            texto.setForeground(new Color(139,69,19));
        } catch (FontFormatException | IOException e) {
           e.printStackTrace();
        }
		this.add(texto);
		this.add(enviarfinal);
		this.setBackground(new Color(210,180,140));
	}

	public JButton getEnviarfinal() {
		return enviarfinal;
	}
	
}


