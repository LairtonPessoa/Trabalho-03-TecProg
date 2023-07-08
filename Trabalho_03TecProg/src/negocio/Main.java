package negocio;
import persistencia.*;
import visualizacao.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JogadaDAO jogada = new JogadaDAO();
		//Jogada j = new Jogada("teste", "teste", "dica", "teste", 0);
		//new TelaDeEscolha();
		new TelaDoJogadorDaVez(new Gerenciador(new Servidor()));
		//new TelaDosJogadores();
		//new TelaDoJogadorDaVez();
		//new TelaDosJogadores();
		//jogada.inserir(j);
		CartasDAO cartas = new CartasDAO();
		System.out.println(cartas.pegarCartas().get(1));
	}
}
