package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//import controller.ControladorDoJogo;
import controller.GerenciadorCliente;

public class ThreadJogador implements Runnable {
    private Socket socket;
    private GerenciadorCliente gerenciadorCliente;
 //    private ControladorDoJogo controladorDoJogo;

    public ThreadJogador(Socket socket, GerenciadorCliente gerenciadorCliente) {
        this.socket = socket;
        this.gerenciadorCliente = gerenciadorCliente;
    }

    public void run() {
        try {
            // Obter o BufferedReader para ler as mensagens do servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                String mensagem[] = reader.readLine().split(";");
                String oQueFoiEnviado = mensagem[mensagem.length-1];
           
                	// Chamar os métodos do controlador com base na mensagem recebida
                	if(oQueFoiEnviado.equals("novoJogador")) {
                		//gerenciadorDoJogo.adicionarJogador();
                	}else if(oQueFoiEnviado.equals("distribuirCartas")){
                		gerenciadorCliente.distribuirCartas(mensagem);
                		System.out.println(socket);
                   }else if(oQueFoiEnviado.equals("HoraDoDuelo")) {
                		gerenciadorCliente.iniciarJogo();
		           }else if (oQueFoiEnviado.equals("dica")) {
                       gerenciadorCliente.exibirDica(mensagem[0]);
                   } else if (oQueFoiEnviado.equals("exibirCartasComDica")) {
                      // gerenciadorCliente.exibirCartasComDica();
                   } else if (oQueFoiEnviado.equals("exibirResultadosDaRodada")) {
                       //gerenciadorCliente.exibirResultadosDaRodada();
                   } 
                    // ...
               }
            
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}

