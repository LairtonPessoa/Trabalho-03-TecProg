package view;

import java.awt.Color;

import javax.swing.JPanel;

public class PainelIndividualJogador extends JPanel{

	public PainelIndividualJogador() {
		this.add(new PainelCartasIndividual());
		this.add(new PainelRecebeDica());
		this.setBackground(Color.black);
	}	
}
