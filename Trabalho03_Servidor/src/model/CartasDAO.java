package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import negocio.Carta;
import negocio.Jogada;
import negocio.Jogador;

	
public class CartasDAO {
	
	//Pegar carta selecionada
	/*public Carta selecionarId(int id) {
		Carta carta = null;

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement result = conexao.prepareStatement("select * from cartas_selecionadas where id=?");
			result.setInt(1, id);

			ResultSet resultado = result.executeQuery();

			while (resultado.next()) {
				carta = new Carta(new ImageIcon(resultado.getString("icone")));
			}
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return carta;
	}*/
	
	//Inserir Carta Selecionada
	public void inserir(Carta carta, Jogada jogada, Jogador jogador) {
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = 
			conexao.prepareStatement("insert into cartas_selecionadas (jogada_id, carta_id, jogador) values (?, ?, ?)");
			
			inserir.setInt(1, jogada.getId());
			inserir.setInt(2, carta.getId());
			inserir.setString(3, jogador.getNome());
			
			inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Ler Arquivo
	public ArrayList<String> pegarCartas(){
		ArrayList<String> cartas = new ArrayList<String>();
		try {
	        FileReader leitorArquivo = new FileReader("Cartas.txt");

	        BufferedReader leitor = new BufferedReader(leitorArquivo);

	        String linhaArquivo;
	        while ((linhaArquivo = leitor.readLine()) != null) {
	        	cartas.add(linhaArquivo);
	        }

	        leitor.close();
	        leitorArquivo.close();
	    } catch (IOException e1) {
	        System.out.println("Ocorreu um erro ao ler o arquivo: " + e1.getMessage());
	    }
		return cartas;
	}
}
