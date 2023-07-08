package main;

import controller.Controlador;
import model.Servidor;

public class Main {

	public static void main(String[] args) {
		Servidor server = new Servidor(new Controlador());
		server.conectarRede();

	}

}