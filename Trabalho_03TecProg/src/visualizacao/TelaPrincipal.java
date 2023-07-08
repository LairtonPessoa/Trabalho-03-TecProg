package visualizacao;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame {

    private JPanel cardPanel; // Contêiner intermediário para o CardLayout

    public TelaPrincipal() {

        this.setSize(400, 300);

        TelaDeEscolha telaDeEscolha = new TelaDeEscolha();
        TelaDoJogadorDaVez telaJogadorDaVez = new TelaDoJogadorDaVez();
        TelaDosJogadores telaDosJogadores = new TelaDosJogadores();
        
        cardPanel = new JPanel(); // Crie o JPanel para o CardLayout
        CardLayout layout = new CardLayout();
        cardPanel.setLayout(layout);
        cardPanel.add(telaDeEscolha, "Tela de escolha");
        cardPanel.add(telaDosJogadores, "tela dos jogadores");
        cardPanel.add(telaJogadorDaVez);

        layout.show(cardPanel, "tela dos jogadores");

        // Adicione o cardPanel ao JFrame usando BorderLayout.CENTER
        this.add(cardPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

	public JPanel getCardPanel() {
		return cardPanel;
	}
}