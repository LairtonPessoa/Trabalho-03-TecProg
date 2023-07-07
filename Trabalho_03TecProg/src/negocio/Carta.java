package negocio;

import javax.swing.ImageIcon;

public class Carta {

	private ImageIcon iconeDaCarta;
	private boolean jaFoiSorteada;
	private ImageIcon iconeFrenteDaCarta;
	private ImageIcon iconeVersoDaCarta;
	private int id;

	public int getId() {
		return id;
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
