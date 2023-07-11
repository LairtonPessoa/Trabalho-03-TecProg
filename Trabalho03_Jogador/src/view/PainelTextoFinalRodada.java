package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelTextoFinalRodada extends JPanel{

    private JLabel dica;
    private JButton enviarfinal;

    public PainelTextoFinalRodada() {
        enviarfinal = new JButton("Enviar");
        enviarfinal.setEnabled(false);
        enviarfinal.setBackground(null);
        enviarfinal.setBorderPainted(false);
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\Squealer.ttf"));
            font = font.deriveFont(Font.PLAIN, 25);
            enviarfinal.setFont(font);
            enviarfinal.setForeground(new Color(139,69,19));
        } catch (FontFormatException | IOException e) {
           e.printStackTrace();
        }
        this.add(painelDicaFinal());
        this.add(enviarfinal);
        this.setPreferredSize(new Dimension(315,50));
        this.setBackground(new Color(210,180,140));
    }

    public JPanel painelDicaFinal() {
        JPanel painelDicaFinal = new JPanel();
        dica = new JLabel("Advinhe qual a carta correta! ");
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\Squealer.ttf"));
            font = font.deriveFont(Font.PLAIN, 16);
            dica.setFont(font);
            dica.setForeground(new Color(139,69,19));
        } catch (FontFormatException | IOException e) {
               e.printStackTrace();
            }
        painelDicaFinal.setBackground(new Color(210,180,140));
        painelDicaFinal.setPreferredSize(new Dimension(200,30));
        painelDicaFinal.add(dica);
        return painelDicaFinal;
    }

    public JButton getEnviarfinal() {
        return enviarfinal;
    }
    public JLabel getDica() {
        return dica;
    }

}