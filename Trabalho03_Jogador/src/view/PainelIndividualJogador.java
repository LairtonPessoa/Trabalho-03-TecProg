package view;

import java.awt.Color;

import javax.swing.JPanel;

import controller.GerenciadorCliente;

public class PainelIndividualJogador extends JPanel{

	public PainelCartasIndividual painelCartasIndividual;
	public PainelRecebeDica painelRecebeDica;
	
	public PainelIndividualJogador() {
		
		this.painelCartasIndividual = new PainelCartasIndividual();
		this.painelRecebeDica = new PainelRecebeDica();
		
		this.add(painelCartasIndividual);
		this.add(painelRecebeDica);
		this.setBackground(Color.black);
	}	
	
	/*
	private GerenciadorCliente controlador;
	public PainelEnviarDica painelDica;
	public PainelCartasVez painelCartas;
	
	public PainelJogadorVez(GerenciadorCliente controlador) {
		painelDica = new PainelEnviarDica();
		painelCartas = new PainelCartasVez(painelDica);
		//painelDica.getEnviar().addActionListener(new AcaoEnviar());
		this.controlador=controlador;
		this.setBackground(Color.black);
		
		this.add(painelCartas);
		this.add(painelDica);	
	}
	*/
}
