package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelCartasRecebidas extends JPanel{

	PainelTextoFinalRodada painelTextoFinal;
	JPanel painelCartasRecebidas;
	JButton carta1recebida;
	JButton carta2recebida;
	JButton carta3recebida;
	JButton carta4recebida;
	public JButton cartaSelecionadaind;

	public PainelCartasRecebidas(PainelTextoFinalRodada painelTextoFinal) {
		this.painelTextoFinal = painelTextoFinal;
		this.add(painelCartasRecebidas());
		this.setBackground(new Color(210,180,140));
	}
	
	public JPanel painelCartasRecebidas() {

		painelCartasRecebidas = new JPanel();
		carta1recebida = criarBotao();
		carta2recebida = criarBotao();
		carta3recebida = criarBotao();		
		carta4recebida = criarBotao();

		painelCartasRecebidas.add(carta1recebida);
		painelCartasRecebidas.add(carta2recebida);
		painelCartasRecebidas.add(carta3recebida);
		painelCartasRecebidas.add(carta4recebida);

		painelCartasRecebidas.setLayout(new GridLayout(2, 3, 5, 5));
		painelCartasRecebidas.setBackground(null);
		return painelCartasRecebidas;
	}
	
	

	// Criar as cartas predefinidas.
	public JButton criarBotao() {
		JButton carta = new JButton();
		carta.setPreferredSize(new Dimension(150, 200));
		carta.addActionListener(new acaoCarta(carta, painelCartasRecebidas));
		carta.setBorderPainted(false);
		return carta;
	}
	

	public void setIconesBotoes(ArrayList<ImageIcon> iconesCartas) {
		for (int i = 0; i < iconesCartas.size(); i++) {
			ImageIcon imageIcon = iconesCartas.get(i);
			ImageIcon imageIconAux = IconesCartas.resizeImageIcon(imageIcon, carta1recebida.getWidth(), carta1recebida.getHeight());
			iconesCartas.set(i, imageIconAux);
		}
		carta1recebida.setIcon(iconesCartas.get(0));
		carta2recebida.setIcon(iconesCartas.get(1));
		carta3recebida.setIcon(iconesCartas.get(2));
		carta4recebida.setIcon(iconesCartas.get(3));
	}

	// Ações nas cartas
	private class acaoCarta implements ActionListener {
		private JButton cartarecebida;
		private JPanel painelPaiind;

		public acaoCarta(JButton cartaind, JPanel painelPaiind) {
			this.cartarecebida = cartaind;
			this.painelPaiind = painelPaiind;
		}

		public void actionPerformed(ActionEvent e) {
			if (cartaSelecionadaind == cartarecebida) { // Se a carta selecionada for clicada novamente
				cartaSelecionadaind = null; // Limpa a carta selecionada
				painelTextoFinal.getEnviarfinal().setEnabled(false);
				// Ativar todas as cartas
				for (Component component : painelPaiind.getComponents()) {
					if (component instanceof JButton) {
						JButton outraCartaind = (JButton) component;
						outraCartaind.setEnabled(true);
					}
				}
			} else {
				cartaSelecionadaind = cartarecebida;
				// Desativar as outras cartas
				for (Component component : painelPaiind.getComponents()) {
					if (component instanceof JButton) {
						JButton outraCartaind = (JButton) component;
						outraCartaind.setEnabled(outraCartaind == cartarecebida);
					}
				}
				painelTextoFinal.getEnviarfinal().setEnabled(true);
			}
		}
	}
}
