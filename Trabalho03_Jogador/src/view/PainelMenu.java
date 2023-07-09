package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class PainelMenu extends JPanel{

	JPanel menu;
	JPanel botoesmenu;
	JPanel painellogo;
	JPanel painelcombotoes;
	JPanel paineldecorado;
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
		painelcombotoes = new JPanel();
		
		ImageIcon img = new ImageIcon("icons_menu\\imgfundo1.png");
		JLabel imgfundo = new JLabel(img);
	
		ImageIcon img2 = new ImageIcon("icons_menu\\imgfundo2.png");
		JLabel imgfundo2 = new JLabel(img2);

		painelcombotoes.setLayout(new BoxLayout(painelcombotoes, BoxLayout.X_AXIS));
		painelcombotoes.setBackground(null);
		
		painelcombotoes.add(imgfundo2);
		painelcombotoes.add(painelBotoesMenu());
		painelcombotoes.add(imgfundo);
		
		return painelcombotoes;
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
		sair.addActionListener(new AcaoSairJogo());;
		
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/squealer.ttf"));
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
		ImageIcon imgaditiva1 = new ImageIcon("icons_menu\\pegasusimg.png");
		JLabel imgadd = new JLabel(imgaditiva1);
		ImageIcon imgaditiva2 = new ImageIcon("icons_menu\\kaibaimgt.png");
		JLabel imgadd2 = new JLabel(imgaditiva2);
		imgadd2.setPreferredSize(new Dimension(100,10));
		
		painellogo.setLayout(new BorderLayout());
		painellogo.setPreferredSize(new Dimension(520,150));
		painellogo.setBackground(null);
		
		painellogo.add(imgadd, BorderLayout.EAST);
		painellogo.add(logo, BorderLayout.CENTER);
		painellogo.add(imgadd2, BorderLayout.WEST);

		return painellogo;
	}
	
	public JPanel painelDecorado() {
		paineldecorado = new JPanel();
		
		ImageIcon img = new ImageIcon("icons_menu\\atributos.png");
		JLabel imgfundo = new JLabel(img);	
		
		paineldecorado.setLayout(new BorderLayout());
		paineldecorado.setPreferredSize(new Dimension(530,70));
		paineldecorado.setBackground(Color.black);
		
		paineldecorado.add(imgfundo, BorderLayout.CENTER);
		
		return paineldecorado;
	}
	
	private int dialogoSairJogo() {
	    ImageIcon icon = new ImageIcon("icons_menu\\kaibaicon.png");
	    UIManager.put("OptionPane.questionIcon", icon);
	    UIManager.put("Button.background", Color.BLACK);
	    UIManager.put("Button.foreground", Color.WHITE);

	    try {
	        Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/squealer.ttf"));
	        font = font.deriveFont(Font.PLAIN, 15);
	        UIManager.put("OptionPane.messageFont", font);
	        UIManager.put("Button.font", font);
	    } catch (FontFormatException | IOException e) {
	        e.printStackTrace();
	    }

	    return JOptionPane.showConfirmDialog(
	            null,
	            "Quando você pensa na derrota, você já perdeu."
	                    + "\n		Deseja continuar?",
	            "Confirmação",
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE);
	}

	private class AcaoSairJogo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int resposta = dialogoSairJogo();
			if (resposta == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		}
	}	
	
	public JButton getJogar() {
		return jogar;
	}

	public JButton getSair() {
		return sair;
	}

	
}		
