package persistencia;

import java.net.Socket;

import negocio.GerenciadorDeJogo;

public class ConexaoJogares implements Runnable{

	private Socket socket;
	private GerenciadorDeJogo gerenciador;
	
	public ConexaoJogares(Socket s, GerenciadorDeJogo g) {
		socket=s;
		gerenciador=g;
	}
	
	public void run() {
		
		
	}

}
