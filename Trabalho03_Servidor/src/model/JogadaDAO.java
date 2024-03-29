package model;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.*;

import java.sql.PreparedStatement;

public class JogadaDAO {

	

	public Jogada selecionarJogada(Jogada jog) {
		Jogada jogada = null;

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement result = conexao.prepareStatement("select * from jogada where JogadorVez_id=?");
			result.setInt(1, jog.getJogadorVez().getId());

			ResultSet resultado = result.executeQuery();

			while (resultado.next()) {
				jogada = new Jogada(resultado.getInt("jogadorVez_id"),resultado.getString("fraseDica"),resultado.getString("cartaEscolhida"), resultado.getInt("pontuacao"));
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
			PreparedStatement up = conexao.prepareStatement("update jogada set pontuacao=? " + "where fraseDica=?");
			
			up.setInt(1, jog.getPontuacao());
			up.setString(2, jog.getFraseDica());

			up.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inserir(Jogada jog) {
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = conexao.prepareStatement(
					"insert into jogada (jogadorVez_id, fraseDica, cartaEscolhida, pontuacao) values (?, ?, ?, ?)");

			inserir.setInt(1, jog.getJogadorVez().getId());
			inserir.setString(2, jog.getFraseDica());
			inserir.setString(3, jog.getCartaVez());
			inserir.setInt(4, jog.getPontuacao());

			inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
