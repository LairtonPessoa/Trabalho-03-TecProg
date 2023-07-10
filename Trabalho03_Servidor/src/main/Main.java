package main;

import controller.ControladorDoJogo;
import model.Servidor;

public class Main {

	public static void main(String[] args) {
		Servidor server = new Servidor(new ControladorDoJogo());
		server.conectarRede();

	}

}
