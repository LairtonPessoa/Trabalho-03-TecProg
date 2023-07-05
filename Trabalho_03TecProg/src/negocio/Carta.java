package negocio;

import javax.swing.ImageIcon;

public class Carta {

	private ImageIcon iconeDaCarta;
	private int id;
	
	public int getId() {
		return id;
	}

	public Carta(ImageIcon iconeDaCarta) {
		this.iconeDaCarta=iconeDaCarta;
	}

	public ImageIcon getIconeDaCarta() {
		return iconeDaCarta;
	}

}
