package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import controller.Controlador;

public class TelaDoJogadorDaVez extends JFrame{

	public TelaDoJogadorDaVez(Controlador controlador) {

		this.setLayout(new BorderLayout());
		this.setSize(530,510);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(new PainelBotoesCartas(), BorderLayout.CENTER);
		this.add(new PainelDica(controlador), BorderLayout.SOUTH);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}