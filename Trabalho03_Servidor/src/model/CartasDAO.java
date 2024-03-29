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
import controller.*;
import model.Conexao;

public class CartasDAO {

	// Inserir Carta Selecionada
	public void inserir(String urlCarta) {
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = conexao.prepareStatement(
					"insert into cartas_selecionadas (carta_url) values (?)");

			inserir.setString(1, urlCarta);

			inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> selecionarCartas() {
		ArrayList<String> urlsCartas = new ArrayList<String>();

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement r = 
		    conexao.prepareStatement("select * from cartas_selecionadas order by id");

			ResultSet resultado = r.executeQuery();

			while (resultado.next()) {
				String url = resultado.getString("carta_url");
	            urlsCartas.add(url);
			}

			conexao.close();
		} catch (Exception e) {
		}
		return urlsCartas;
	}

	// Ler Arquivo
	public ArrayList<String> pegarCartas() {
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
