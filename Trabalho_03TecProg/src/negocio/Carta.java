package negocio;

import javax.swing.ImageIcon;

public class Carta {

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
}
