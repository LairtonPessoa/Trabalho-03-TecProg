package persistencia;

import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.SQLException;

import negocio.Jogada;
import java.util.ArrayList;

import java.sql.PreparedStatement;



public class JogadaDAO {

	public ArrayList<Jogada> selecionar(){
		ArrayList<Jogada> jogadas = new ArrayList<Jogada>();
		
		try {
			Connection conexao = new Conexao().getConexao();
			
			java.sql.PreparedStatement r = 
				conexao.prepareStatement("select * from carta order by nome");
			
			ResultSet resultado = r.executeQuery();
			
			while(resultado.next()) {
				Jogada jogada = new Jogada(resultado.getString("cartaEscolhidaJogadorVez"), resultado.getString("jogadorVez"), resultado.getString("fraseDica"), resultado.getString("cartaEscolhida"), resultado.getInt("pontuacao"));
				jogadas.add(jogada);
			}
			conexao.close();
		}catch(Exception e) {
			
		}
		return jogadas;
	}
	
	public Jogada selecionarId(int id) {
		Jogada jogada = null;

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement result = conexao.prepareStatement("select * from produto where id=?");
			result.setInt(1, id);

			ResultSet resultado = result.executeQuery();

			while (resultado.next()) {
				jogada = new Jogada(resultado.getString("cartaEscolhidaJogadorVez"), resultado.getString("jogadorVez"), resultado.getString("fraseDica"), resultado.getString("cartaEscolhida"), resultado.getInt("pontuacao"));
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
			PreparedStatement up = conexao.prepareStatement
					("uptdate Jogada set cartaEscolhidaJogadorVez=?, "
							+ "jogadorVez=?, "
							+ "fraseDica=?, "
							+ "cartaEscolhida=?, "
							+ "pontuacao=?, "
							+ "where Id=?");
			up.setString(1, jog.getCartaEscolhidaJogadorVez());
			up.setString(1, jog.getJogadorVez());
			up.setString(1, jog.getFraseDica());
			up.setString(1, jog.getCartaEscolhida());
			up.setInt(1, jog.getPontuacao());
			up.setInt(1, jog.getId());
			
			up.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inserir(Jogada jog) {
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = 
			conexao.prepareStatement("insert into jogada (cartaEscolhidaJogadorVez, jogadorVez, fraseDica, cartaEscolhida, pontuacao) values (?, ?, ?, ?, ?)");
			
			inserir.setString(1, jog.getCartaEscolhidaJogadorVez());
			inserir.setString(1, jog.getJogadorVez());
			inserir.setString(1, jog.getFraseDica());
			inserir.setString(1, jog.getCartaEscolhida());
			inserir.setInt(1, jog.getPontuacao());
			
			inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletar(Jogada jog) {
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement deletar = 
			conexao.prepareStatement("delete from jogadas where id =?");
			
			deletar.setInt(1, jog.getId());
			deletar.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
