package model;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.*;
import java.util.ArrayList;

import java.sql.PreparedStatement;

public class JogadaDAO {

	public ArrayList<Jogada> selecionar() {
		ArrayList<Jogada> jogadas = new ArrayList<Jogada>();

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement r = conexao.prepareStatement("select * from carta order by nome");

			ResultSet resultado = r.executeQuery();

			while (resultado.next()) {
				Jogada jogada = new Jogada(resultado.getString("jogadorVez"), resultado.getString("fraseDica"),
						resultado.getString("cartaEscolhida"), resultado.getInt("pontuacao"));
				jogadas.add(jogada);
			}
			conexao.close();
		} catch (Exception e) {

		}
		return jogadas;
	}

	public Jogada selecionarId(int id) {
		Jogada jogada = null;

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement result = conexao.prepareStatement("select * from jogada where id=?");
			result.setInt(1, id);

			ResultSet resultado = result.executeQuery();

			while (resultado.next()) {
				jogada = new Jogada(resultado.getString("jogadorVez"), resultado.getString("fraseDica"),
						resultado.getString("cartaEscolhida"), resultado.getInt("pontuacao"));
			}
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jogada;
	}

	public void update(Jogada jog) {
		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement("uptdate jogada set jogadorVez=?, " + "fraseDica=?, "
					+ "cartaEscolhida=?, " + "pontuacao=?, " + "where Id=?");
			up.setString(1, jog.getJogadorVez());
			up.setString(2, jog.getFraseDica());
			up.setString(3, jog.getCartaEscolhida());
			up.setInt(4, jog.getPontuacao());
			up.setInt(5, jog.getId());

			up.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inserir(Jogada jog) {
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = conexao.prepareStatement(
					"insert into jogada (jogadorVez, fraseDica, cartaEscolhida, pontuacao) values (?, ?, ?, ?)");

			inserir.setString(1, jog.getJogadorVez());
			inserir.setString(2, jog.getFraseDica());
			inserir.setString(3, jog.getCartaEscolhida());
			inserir.setInt(4, jog.getPontuacao());

			inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
