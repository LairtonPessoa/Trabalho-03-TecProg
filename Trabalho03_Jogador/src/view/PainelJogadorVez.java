package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

<<<<<<< HEAD:Trabalho03_Jogador/src/view/PainelBotoesCartas.java
public class PainelBotoesCartas extends JPanel{
	
=======
import controller.GerenciadorCliente;

public class PainelJogadorVez extends JPanel{

	private GerenciadorCliente controlador;
>>>>>>> ab5f4a9316dabb56792f7a1601fea4ef78d715a8:Trabalho03_Jogador/src/view/PainelJogadorVez.java
	JPanel painelcartas;
	JButton carta1;
	JButton carta2;
	JButton carta3;
	JButton carta4;
	JButton carta5;
	JButton carta6;
	JButton cartaSelecionada;
	PainelDica paineldica;
	
	public PainelJogadorVez(GerenciadorCliente controlador) {
		paineldica = new PainelDica();
		paineldica.getEnviar().addActionListener(new acaoEnviar());
		this.controlador=controlador;
		this.add(painelCartas());
		this.setBackground(Color.black);
		this.add(paineldica);
	}

	//Criar o painel das cartas.
	public JPanel painelCartas() {
		painelcartas = new JPanel();
		
		ImageIcon cartaum = new ImageIcon("icons\\aviario.png");
		carta1=criarBotao(cartaum);

		ImageIcon cartadois = new ImageIcon("icons\\dragaobranco.png");
		carta2=criarBotao(cartadois);
		
		ImageIcon cartatres = new ImageIcon("icons\\kuriboh.png");
	    carta3=criarBotao(cartatres);
	    
		ImageIcon cartaquatro = new ImageIcon("icons\\magonegro.png");
		carta4=criarBotao(cartaquatro);

		ImageIcon cartacinco = new ImageIcon("icons\\NEOASV.png");
		carta5=criarBotao(cartacinco);

		ImageIcon cartaseis = new ImageIcon("icons\\reicaveira.png");
		carta6=criarBotao(cartaseis);

		painelcartas.add(carta1);
		painelcartas.add(carta2);
		painelcartas.add(carta3);
		painelcartas.add(carta4);
		painelcartas.add(carta5);
		painelcartas.add(carta6);

		painelcartas.setBackground(Color.black);
		painelcartas.setLayout(new GridLayout(2,3,5,5));

		return painelcartas;
	}	

	//Criar as cartas predefinidas.
	public JButton criarBotao(ImageIcon imgcartas) {
		JButton carta = new JButton();
		carta.setPreferredSize(new Dimension(150,200));
		carta.addActionListener(new acaoCarta(carta));
		carta.setBorderPainted(false);
		int width = carta.getPreferredSize().width;
	    int height = carta.getPreferredSize().height;
	    ImageIcon resizedIcon = IconesCartas.resizeImageIcon(imgcartas, width, height);
	    carta.setIcon(resizedIcon);
		return carta;
	}

	//Ações nas cartas
	private class acaoCarta implements ActionListener {
		private JButton carta;

		public acaoCarta(JButton carta) {
			this.carta = carta;
		}

		public void actionPerformed(ActionEvent e) {
			if (cartaSelecionada == carta) { // Se a carta selecionada for clicada novamente
				cartaSelecionada = null; // Limpa a carta selecionada
				
				// Ativar todas as cartas
				for (Component component : painelcartas.getComponents()) {
					if (component instanceof JButton) {
						JButton outraCarta = (JButton) component;
						outraCarta.setEnabled(true);
					}
				}
			} else {
				cartaSelecionada = carta;
				// Desativar as outras cartas
				for (Component component : painelcartas.getComponents()) {
					if (component instanceof JButton) {
						JButton outraCarta = (JButton) component;
						outraCarta.setEnabled(outraCarta == carta);
					}
				}
			}
		}
	}
	
<<<<<<< HEAD:Trabalho03_Jogador/src/view/PainelBotoesCartas.java
	
=======
	private class  acaoEnviar implements ActionListener{ 
	
		public void actionPerformed(ActionEvent e) {
			String mensagem = paineldica.getBarra().getText();
			controlador.enviarMensagem(mensagem);			
		}
	}
>>>>>>> ab5f4a9316dabb56792f7a1601fea4ef78d715a8:Trabalho03_Jogador/src/view/PainelJogadorVez.java
}

