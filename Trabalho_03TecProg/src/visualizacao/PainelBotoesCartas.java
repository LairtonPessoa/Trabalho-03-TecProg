package visualizacao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PainelBotoesCartas extends JPanel{

	JPanel painelcartas;
	JButton carta;
	JButton cartaSelecionada;
	PainelDica paineldica;

	public PainelBotoesCartas() {
		this.add(painelcartas());
		this.setBackground(new Color(100,149,237,70));
	}

	//Criar o painel das cartas.
	public JPanel painelcartas() {
		painelcartas = new JPanel();

		for(int i=0;i<6;i++) {
			painelcartas.add(criarBotao("Botão"));
		}
		painelcartas.setBackground(new Color(100,149,237,80));
		painelcartas.setLayout(new GridLayout(2,3,5,5));

		return painelcartas;
	}	

	//Criar as cartas predefinidas.
	public JButton criarBotao(String nome) {
		carta = new JButton(nome);
		carta.setPreferredSize(new Dimension(150,200));
		carta.setBorder(new RoundedBorder());
		//carta.addActionListener(new acaoCarta(carta));
		return carta;
	}

	//Classe para deixar as bordas redondas
	private static class RoundedBorder implements Border {
		private int arcWidth=20;
		private int arcHeight=20;

		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setColor(c.getForeground());
			g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, arcWidth, arcHeight));
			g2d.dispose();
		}

		public Insets getBorderInsets(Component c) {
			return new Insets(arcHeight, arcWidth, arcHeight, arcWidth);
		}

		public boolean isBorderOpaque() {
			return true;
		}
	}
}
