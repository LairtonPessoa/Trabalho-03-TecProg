package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PainelEspera extends JPanel {
    private JLabel imgfundologo2;
    private JLabel texto;
    
    public PainelEspera() {
        ImageIcon imglogo = new ImageIcon("icons_menu\\imgespera.png");
        JLabel imgfundologo = new JLabel(imglogo);

        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);
        this.add(imgfundologo, BorderLayout.NORTH);
        this.add(painelInferior(), BorderLayout.SOUTH);

        Timer timer = new Timer(500, e -> {
            imgfundologo2.setVisible(!imgfundologo2.isVisible());
            texto.setVisible(!texto.isVisible());
        });

        timer.start();
    }

    public JPanel painelInferior() {
        JPanel painelinferior = new JPanel();
        texto = new JLabel("Aguardando oponentes...");
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/squealer.ttf"));
            font = font.deriveFont(Font.PLAIN, 40); // Defina o estilo e o tamanho da fonte desejados
            texto.setForeground(Color.white);
            texto.setFont(font);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        ImageIcon imglogo2 = new ImageIcon("icons_menu\\itemsdomilenioolho.png");
        imgfundologo2 = new JLabel(imglogo2);
        painelinferior.setBackground(Color.black);
        painelinferior.add(texto);
        painelinferior.add(imgfundologo2);
        return painelinferior;
    }
}
