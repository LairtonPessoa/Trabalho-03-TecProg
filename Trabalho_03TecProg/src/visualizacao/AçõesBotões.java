package visualizacao;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//Classe temporaria apenas para se ter ideia de algumas ações.

public class AçõesBotões {

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
					enviar.setEnabled(!barra.getText().isEmpty() && painelcartas.cartaSelecionada != null);
					barra.setEditable(painelcartas.cartaSelecionada != null);
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
					paineldica.barra.setEditable(true);
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
