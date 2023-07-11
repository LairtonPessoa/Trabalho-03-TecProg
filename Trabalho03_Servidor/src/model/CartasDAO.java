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

	// Pegar carta selecionada
	/*
	 * public Carta selecionarId(int id) { Carta carta = null;
	 * 
	 * try { Connection conexao = new Conexao().getConexao();
	 * 
	 * PreparedStatement result =
	 * conexao.prepareStatement("select * from cartas_selecionadas where id=?");
	 * result.setInt(1, id);
	 * 
	 * ResultSet resultado = result.executeQuery();
	 * 
	 * while (resultado.next()) { carta = new Carta(new
	 * ImageIcon(resultado.getString("icone"))); } conexao.close(); } catch
	 * (Exception e) { // TODO: handle exception } return carta; }
	 */

	// Inserir Carta Selecionada
	public void inserir(String urlCarta, JogadorServidor jogador) {
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = conexao.prepareStatement(
					"insert into cartas_selecionadas (carta_url, jogador_id) values (?, ?)");

			inserir.setString(1, urlCarta);
			inserir.setInt(2, jogador.getId());

			inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Carta> selecionar() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement r = 
		    conexao.prepareStatement("select * from cartas_selecionadas order by id");

			ResultSet resultado = r.executeQuery();

			while (resultado.next()) {
				Carta c = new Carta(resultado.getInt("id"));
				cartas.add(c);
			}

			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cartas;
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
}
