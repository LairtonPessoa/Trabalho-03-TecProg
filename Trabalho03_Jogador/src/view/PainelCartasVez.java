package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelCartasVez extends JPanel {

    JButton carta1;
    JButton carta2;
    JButton carta3;
    JButton carta4;
    JButton carta5;
    JButton carta6;
    JButton cartaSelecionada;

    public PainelCartasVez() {

        ImageIcon cartaum = new ImageIcon("icons\\aviario.png");
        carta1 = criarBotao(cartaum);

        ImageIcon cartadois = new ImageIcon("icons\\dragaobranco.png");
        carta2 = criarBotao(cartadois);

        ImageIcon cartatres = new ImageIcon("icons\\kuriboh.png");
        carta3 = criarBotao(cartatres);

        ImageIcon cartaquatro = new ImageIcon("icons\\magonegro.png");
        carta4 = criarBotao(cartaquatro);

        ImageIcon cartacinco = new ImageIcon("icons\\NEOASV.png");
        carta5 = criarBotao(cartacinco);

        ImageIcon cartaseis = new ImageIcon("icons\\reicaveira.png");
        carta6 = criarBotao(cartaseis);

        this.add(carta1);
        this.add(carta2);
        this.add(carta3);
        this.add(carta4);
        this.add(carta5);
        this.add(carta6);

        this.setLayout(new GridLayout(2, 3, 5, 5));
        this.setBackground(null);
    }

    // Criar as cartas predefinidas.
    public JButton criarBotao(ImageIcon imgcartas) {
        JButton carta = new JButton();
        carta.setPreferredSize(new Dimension(150, 200));
        carta.addActionListener(new acaoCarta(carta, this));
        carta.setBorderPainted(false);
        int width = carta.getPreferredSize().width;
        int height = carta.getPreferredSize().height;
        ImageIcon resizedIcon = IconesCartas.resizeImageIcon(imgcartas, width, height);
        carta.setIcon(resizedIcon);
        return carta;
    }

    // Ações nas cartas
    private class acaoCarta implements ActionListener {
        private JButton carta;
        private JPanel painelPai;

        public acaoCarta(JButton carta, JPanel painelPai) {
            this.carta = carta;
            this.painelPai = painelPai;
        }

        public void actionPerformed(ActionEvent e) {
            if (cartaSelecionada == carta) { // Se a carta selecionada for clicada novamente
                cartaSelecionada = null; // Limpa a carta selecionada

                // Ativar todas as cartas
                for (Component component : painelPai.getComponents()) {
                    if (component instanceof JButton) {
                        JButton outraCarta = (JButton) component;
                        outraCarta.setEnabled(true);
                    }
                }
            } else {
                cartaSelecionada = carta;
                // Desativar as outras cartas
                for (Component component : painelPai.getComponents()) {
                    if (component instanceof JButton) {
                        JButton outraCarta = (JButton) component;
                        outraCarta.setEnabled(outraCarta == carta);
                    }
                }
            }
        }
    }
}

