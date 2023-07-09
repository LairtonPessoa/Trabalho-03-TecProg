package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelMenu extends JPanel{

	JPanel menu;
	JPanel botoesmenu;
	JPanel painellogo;
	JButton jogar;
	JButton sair;
	
	public PainelMenu() {

		this.add(painelMenu());
	}
	
	public JPanel painelMenu() {
		menu = new JPanel();

		menu.setBackground(Color.black);
		menu.setPreferredSize(new Dimension(530,510));
		menu.setVisible(true);
		
		menu.add(painelLogotipo());
		menu.add(painelComBotoesMenu());
		menu.add(painelDecorado());
	
		return menu;
	}
	
	public JPanel painelComBotoesMenu() {
		JPanel teste = new JPanel();
		
		ImageIcon img = new ImageIcon("icons_menu\\imgfundo1.png");
		JLabel imgfundo = new JLabel(img);
	
		ImageIcon img2 = new ImageIcon("icons_menu\\imgfundo2.png");
		JLabel imgfundo2 = new JLabel(img2);

		teste.setLayout(new BoxLayout(teste, BoxLayout.X_AXIS));
		teste.setBackground(null);
		
		teste.add(imgfundo2);
		teste.add(painelBotoesMenu());
		teste.add(imgfundo);
		
		return teste;
	}
	
	public JPanel painelBotoesMenu() {
		botoesmenu = new JPanel();
		
		jogar = new JButton("JOGAR");
		jogar.setPreferredSize(new Dimension(10,10));
		jogar.setBorderPainted(false);
		jogar.setForeground(Color.white);
		jogar.setBackground(null);
		
		sair = new JButton("SAIR");
		sair.setPreferredSize(new Dimension(10,10));
		sair.setBorderPainted(false);
		sair.setForeground(Color.white);
		sair.setBackground(null);
		
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\Squealer.ttf"));
            font = font.deriveFont(Font.PLAIN, 30); // Defina o estilo e o tamanho da fonte desejados

            // Define a fonte do texto do botão
            jogar.setFont(font);
            sair.setFont(font);
        } catch (FontFormatException | IOException e) {
           e.printStackTrace();
        }
		
		botoesmenu.setLayout(new GridLayout(2,1,0,10));
		botoesmenu.setBackground(Color.black);
		botoesmenu.setVisible(true);
		botoesmenu.setPreferredSize(new Dimension(120,100));
		botoesmenu.add(jogar);
		botoesmenu.add(sair);
		
		return botoesmenu;
	}
	public JPanel painelLogotipo() {
		painellogo = new JPanel();
		
		ImageIcon logojogo = new ImageIcon("icons_menu\\logojogo.png");
		JLabel logo = new JLabel(logojogo);
		
		painellogo.setLayout(new BorderLayout());
		painellogo.setPreferredSize(new Dimension(300,150));
		painellogo.setBackground(null);
		
		painellogo.add(logo, BorderLayout.CENTER);
	
		return painellogo;
	}
	
	public JPanel painelDecorado() {
		JPanel paineldecorado = new JPanel();
		
		ImageIcon img = new ImageIcon("icons_menu\\atributos.png");
		JLabel imgfundo = new JLabel(img);	
		
		paineldecorado.setLayout(new BorderLayout());
		paineldecorado.setPreferredSize(new Dimension(530,70));
		paineldecorado.setBackground(Color.black);
		
		paineldecorado.add(imgfundo, BorderLayout.CENTER);
		
		return paineldecorado;
	}
}		
