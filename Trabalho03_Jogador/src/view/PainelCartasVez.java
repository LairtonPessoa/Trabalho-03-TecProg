package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
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
    PainelEnviarDica painelDica;

    public PainelCartasVez(PainelEnviarDica painel) {
    	this.painelDica = painel;
        carta1 = criarBotao();
        carta2 = criarBotao();
        carta3 = criarBotao();
        carta4 = criarBotao();
        carta5 = criarBotao();
        carta6 = criarBotao();

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
    public JButton criarBotao() {
        JButton carta = new JButton();
        carta.setPreferredSize(new Dimension(150, 200));
        carta.addActionListener(new acaoCarta(carta, this));
        carta.setBorderPainted(false);
        return carta;
    }

    public void setIconesBotoes(ArrayList<ImageIcon> iconesCartas) {
        for (int i = 0; i < iconesCartas.size(); i++) {
            ImageIcon imageIcon = iconesCartas.get(i);
            ImageIcon imageIconAux = IconesCartas.resizeImageIcon(imageIcon, carta1.getWidth(), carta1.getHeight());
            iconesCartas.set(i, imageIconAux);
        }
        carta1.setIcon(iconesCartas.get(0));
        carta2.setIcon(iconesCartas.get(1));
        carta3.setIcon(iconesCartas.get(2));
        carta4.setIcon(iconesCartas.get(3));
        carta5.setIcon(iconesCartas.get(4));
        carta6.setIcon(iconesCartas.get(5));
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
            painelDica.getBarra().setEnabled(true);
            painelDica.getEnviar().setEnabled(true);
        	if (cartaSelecionada == carta) { // Se a carta selecionada for clicada novamente
                cartaSelecionada = null; // Limpa a carta selecionada

                // Ativar todas as cartas
                for (Component component : painelPai.getComponents()) {
                    if (component instanceof JButton) {
                        JButton outraCarta = (JButton) component;
                        outraCarta.setEnabled(true);
                    }
                }
                painelDica.getBarra().setEnabled(false);
                painelDica.getEnviar().setEnabled(false);
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

