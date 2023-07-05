package visualizacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TelaDoJogadorDaVez extends JFrame{

	JTextField barra;
	JButton carta;
	JButton cartaSelecionada;
	JButton enviar;
	JPanel painelcartas;
	JPanel paineldica;
	JPanel paineljogo;

	public TelaDoJogadorDaVez() {

		this.setLayout(new BorderLayout());
		this.setSize(530,510);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(paineljogo(), BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	//Painel da dica
	public JPanel paineldica() {
		paineldica = new JPanel();

		barra = new JTextField();
		barra.setPreferredSize(new Dimension(325,40));
		barra.setEditable(false);
		barra.getDocument().addDocumentListener(new acaoBarra());

		enviar = new JButton("Enviar");
		enviar.setEnabled(false);
		enviar.setPreferredSize(new Dimension(125,40));

		paineldica.setLayout(new FlowLayout());
		paineldica.setPreferredSize(new Dimension(460,50));
		paineldica.setBackground(new Color(100,149,237,70));

		paineldica.add(barra);
		paineldica.add(enviar);

		return paineldica;
	}

	//Painel do jogo, com as cartas e o painel das dicas.
	public JPanel paineljogo() {
		paineljogo = new JPanel();

		paineljogo.setBackground(new Color(100,149,237,80));
		paineljogo.add(painelcartas());
		paineljogo.add(paineldica());
		return paineljogo;
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
		carta.addActionListener(new acaoCarta(carta));
		return carta;
	}

	//Alterar a possibilidade de escrever na barra, e habilitar o botão enviar.
	private class acaoBarra implements DocumentListener {
		public void insertUpdate(DocumentEvent e) {
			verificarBotaoEnviar();
		}

		public void removeUpdate(DocumentEvent e) {
			verificarBotaoEnviar();
		}

		public void changedUpdate(DocumentEvent e) {
			verificarBotaoEnviar();
		}

		private void verificarBotaoEnviar() {
			enviar.setEnabled(!barra.getText().isEmpty() && cartaSelecionada != null);
			barra.setEditable(cartaSelecionada != null);
		}
	}

	//Ações nas cartas
	private class acaoCarta implements ActionListener {
		private JButton carta;

		public acaoCarta(JButton carta) {
			this.carta = carta;
		}

		public void actionPerformed(ActionEvent e) {
			cartaSelecionada = carta;
			barra.setEditable(true);
			// Desativar as outras cartas
			for (Component component : painelcartas.getComponents()) {
				if (component instanceof JButton) {
					JButton outraCarta = (JButton) component;
					outraCarta.setEnabled(outraCarta == carta);
				}
			}
		}
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
