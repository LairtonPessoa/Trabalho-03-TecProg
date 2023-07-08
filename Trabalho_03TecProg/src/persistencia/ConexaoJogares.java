package persistencia;

import java.net.Socket;

import negocio.Gerenciador;

public class ConexaoJogares implements Runnable{

	private Socket socket;
	private Gerenciador gerenciador;
	
	public ConexaoJogares(Socket s, Gerenciador g) {
		socket=s;
		gerenciador=g;
	}
	
	public void run() {
		
		
	}

}
