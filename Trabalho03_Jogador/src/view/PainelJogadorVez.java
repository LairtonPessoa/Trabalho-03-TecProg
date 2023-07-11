package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.GerenciadorCliente;

public class PainelJogadorVez extends JPanel{

	private GerenciadorCliente controlador;
	public PainelEnviarDica painelDica;
	public PainelCartasVez painelCartas;
	public Image img;
	
	public PainelJogadorVez(GerenciadorCliente controlador) {
		painelDica = new PainelEnviarDica();
		painelCartas = new PainelCartasVez(painelDica);
		try {
			img = ImageIO.read(new File("icons_menu\\imgfundorodadafinal.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\Squealer.ttf"));
            font = font.deriveFont(Font.PLAIN, 16);
            painelDica.getEnviar().setFont(font);
            painelDica.getEnviar().setForeground(new Color(210,180,140));
        } catch (FontFormatException | IOException e) {
           e.printStackTrace();
        }		this.controlador=controlador;
		this.setBackground(Color.black);
		
		this.add(painelCartas);
		this.add(painelDica);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(),this);
	}
	/*private class  AcaoEnviar implements ActionListener{ 
	
		public void actionPerformed(ActionEvent e) {
			String mensagem = painelDica.getBarra().getText() + ";enviouDica";
			controlador.enviarMensagem(mensagem);			
		}
	}*/
}

