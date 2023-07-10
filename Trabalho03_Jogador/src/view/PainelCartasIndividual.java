package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelCartasIndividual extends JPanel{
	
	public JButton carta1ind;
	public JButton carta2ind;
    public JButton carta3ind;
    public JButton carta4ind;
    public JButton carta5ind;
    public JButton carta6ind;
    public JButton cartaSelecionadaind;
    public PainelRecebeDica painelRecebeDica;
    
    public PainelCartasIndividual(PainelRecebeDica painelRecebeDica) {
    	this.painelRecebeDica = painelRecebeDica;
    	
        ImageIcon cartaum = new ImageIcon("icons\\cyberdragao.png");
        carta1ind = criarBotao(cartaum);

        ImageIcon cartadois = new ImageIcon("icons\\aladodera.png");
        carta2ind = criarBotao(cartadois);

        ImageIcon cartatres = new ImageIcon("icons\\exodia.png");
        carta3ind = criarBotao(cartatres);

        ImageIcon cartaquatro = new ImageIcon("icons\\slifer.png");
        carta4ind = criarBotao(cartaquatro);

        ImageIcon cartacinco = new ImageIcon("icons\\obelisco.png");
        carta5ind = criarBotao(cartacinco);

        ImageIcon cartaseis = new ImageIcon("icons\\pequenamaganegra.png");
        carta6ind = criarBotao(cartaseis);

        this.add(carta1ind);
        this.add(carta2ind);
        this.add(carta3ind);
        this.add(carta4ind);
        this.add(carta5ind);
        this.add(carta6ind);

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
    
    public void setIconesBotoes(ArrayList<ImageIcon> iconesCartas) {
        for (int i = 0; i < iconesCartas.size(); i++) {
            ImageIcon imageIcon = iconesCartas.get(i);
            ImageIcon imageIconAux = IconesCartas.resizeImageIcon(imageIcon, carta1ind.getWidth(), carta1ind.getHeight());
            iconesCartas.set(i, imageIconAux);
        }
        carta1ind.setIcon(iconesCartas.get(0));
        carta2ind.setIcon(iconesCartas.get(1));
        carta3ind.setIcon(iconesCartas.get(2));
        carta4ind.setIcon(iconesCartas.get(3));
        carta5ind.setIcon(iconesCartas.get(4));
        carta6ind.setIcon(iconesCartas.get(5));
    }

    // Ações nas cartas
    private class acaoCarta implements ActionListener {
        private JButton cartaind;
        private JPanel painelPaiind;

        public acaoCarta(JButton cartaind, JPanel painelPaiind) {
            this.cartaind = cartaind;
            this.painelPaiind = painelPaiind;
        }

        public void actionPerformed(ActionEvent e) {
            if (cartaSelecionadaind == cartaind) { // Se a carta selecionada for clicada novamente
                cartaSelecionadaind = null; // Limpa a carta selecionada
                painelRecebeDica.getEnviarrecebe().setEnabled(false);
                // Ativar todas as cartas
                for (Component component : painelPaiind.getComponents()) {
                    if (component instanceof JButton) {
                        JButton outraCartaind = (JButton) component;
                        outraCartaind.setEnabled(true);
                    }
                }
            } else {
                cartaSelecionadaind = cartaind;
                painelRecebeDica.getEnviarrecebe().setEnabled(true);
                // Desativar as outras cartas
                for (Component component : painelPaiind.getComponents()) {
                    if (component instanceof JButton) {
                        JButton outraCartaind = (JButton) component;
                        outraCartaind.setEnabled(outraCartaind == cartaind);
                    }
                }
            }
        }
    }
}

