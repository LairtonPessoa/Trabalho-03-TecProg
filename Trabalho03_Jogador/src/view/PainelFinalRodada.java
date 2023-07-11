package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PainelFinalRodada extends JPanel{

	public PainelCartasRecebidas painelCartasRecebidas;
	public PainelTextoFinalRodada painelTextoFinalRodada;
	public Image img;
	
	public PainelFinalRodada() {
		try {
			img = ImageIO.read(new File("icons_menu\\imgfundorodadafinal.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		painelTextoFinalRodada = new PainelTextoFinalRodada();
		painelCartasRecebidas = new PainelCartasRecebidas(painelTextoFinalRodada);
		this.add(painelCartasRecebidas);
		this.add(painelTextoFinalRodada);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(),this);
	}
}
