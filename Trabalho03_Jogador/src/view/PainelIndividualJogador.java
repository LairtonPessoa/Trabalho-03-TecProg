package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PainelIndividualJogador extends JPanel{

	public PainelCartasIndividual painelCartasIndividual;
	public PainelRecebeDica painelRecebeDica;
	public Image img;
	
	public PainelIndividualJogador() {
		
		try {
			img = ImageIO.read(new File("icons_menu\\imgfundorodadafinal.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.painelRecebeDica = new PainelRecebeDica();
		this.painelCartasIndividual = new PainelCartasIndividual(painelRecebeDica);
		
		this.add(painelCartasIndividual);
		this.add(painelRecebeDica);
		this.setBackground(Color.black);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(),this);
	}
}
