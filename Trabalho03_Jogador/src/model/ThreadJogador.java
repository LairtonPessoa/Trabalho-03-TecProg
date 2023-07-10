package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import controller.*;
import controller.ControladorDoJogo;


public class ThreadJogador implements Runnable {
    private Socket servidor;
    private GerenciadorCliente gerenciadorCliente;
    private ControladorDoJogo controladorDoJogo;

    public ThreadJogador(Socket servidor, GerenciadorCliente gerenciadorCliente) {
        this.servidor = servidor;
        this.gerenciadorCliente = gerenciadorCliente;
    }

    public void run() {
        try {
            // Obter o BufferedReader para ler as mensagens do servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(servidor.getInputStream()));

            while (true) {
                String mensagem[] = reader.readLine().split(";");
                String oQueFoiEnviado = mensagem[mensagem.length-1];
           
                	// Chamar os métodos do controlador com base na mensagem recebida
                	if(oQueFoiEnviado.equals("novoJogador")) {
                		gerenciadorCliente.adicionarJogador();
                	}else if(oQueFoiEnviado.equals("distribuirCartas")){
                		gerenciadorCliente.distribuirCartas(oQueFoiEnviado);
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

