package controller;

import javax.swing.ImageIcon;

public class Carta {

	private ImageIcon iconeDaCarta;
	private boolean jaFoiSorteada;
	private ImageIcon iconeFrenteDaCarta;
	private ImageIcon iconeVersoDaCarta;
	private int id;
	
	public Carta(int id) {
		this.iconeFrenteDaCarta = iconeFrenteDaCarta;
		this.iconeVersoDaCarta = new ImageIcon("icons/versocarta.jpg");
		this.id = id;
	}
	public ImageIcon getIconeFrenteDaCarta() {
		return iconeFrenteDaCarta;
	}
	public void setIconeFrenteDaCarta(ImageIcon iconeFrenteDaCarta) {
		this.iconeFrenteDaCarta = iconeFrenteDaCarta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public ImageIcon getIconeDaCarta() {
		return iconeFrenteDaCarta;
	}
	public ImageIcon getIconeVersoDaCarta() {
		return iconeVersoDaCarta;
	}
	
	public boolean isJaFoiSorteada() {
		return jaFoiSorteada;
	}

	public void setJaFoiSorteada(boolean jaFoiSorteada) {
		this.jaFoiSorteada = jaFoiSorteada;
	}

}
