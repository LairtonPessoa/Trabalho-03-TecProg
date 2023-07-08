package visualizacao;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class TelaDoJogadorDaVez extends JFrame{

	public TelaDoJogadorDaVez() {

		this.setLayout(new BorderLayout());
		this.setSize(530,510);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(new PainelBotoesCartas(), BorderLayout.CENTER);
		this.add(new PainelDica(), BorderLayout.SOUTH);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

