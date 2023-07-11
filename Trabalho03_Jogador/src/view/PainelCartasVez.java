package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelCartasVez extends JPanel {

	ArrayList<JButton> botoesCartas;
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

    	botoesCartas = new ArrayList<JButton>();
    	
    	for(int i = 0; i < 6; i++) {
    		botoesCartas.add(criarBotao());
    		this.add(botoesCartas.get(i));
    	}
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
            ImageIcon imageIconAux = IconesCartas.resizeImageIcon(imageIcon, 150, 200);
            //botoesCartas.get(i).setIcon(new ImageIcon(imageIconAux.toString()));
            iconesCartas.set(i, imageIconAux);
        }
    	for(int i = 0; i < 6; i++) {
    		botoesCartas.get(i).setIcon(iconesCartas.get(i));
    	}
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

