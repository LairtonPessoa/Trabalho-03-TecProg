package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PainelIndividualJogador extends JPanel{

	public PainelCartasIndividual painelCartasIndividual;
	public PainelRecebeDica painelRecebeDica;
	
	public PainelIndividualJogador() {
		
		this.painelRecebeDica = new PainelRecebeDica();
		this.painelCartasIndividual = new PainelCartasIndividual(painelRecebeDica);
		
		this.add(painelCartasIndividual);
		this.add(painelRecebeDica);
		this.setBackground(Color.black);
	}	
}
