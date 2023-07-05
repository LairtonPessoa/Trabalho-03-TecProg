package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import negocio.Carta;
import negocio.Jogada;

public class CartasDAO {

	public ArrayList<Carta> selecionar(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		
		try {
			Connection conexao = new Conexao().getConexao();
			
			PreparedStatement r = 
				conexao.prepareStatement("select * from carta order by nome");
			
			ResultSet resultado = r.executeQuery();
			
			while(resultado.next()) {
				Carta carta = new Carta(new ImageIcon(resultado.getString("icone")));
				cartas.add(carta);
			}
			conexao.close();
		}catch(Exception e) {
			
		}
		return cartas;
	}
	
	public Carta selecionarId(int id) {
		Carta carta = null;

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement result = conexao.prepareStatement("select * from jogada where id=?");
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
	}
	
	public void update(Jogada jog) {
		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement
					("uptdate jogada set jogadorVez=?, "
							+ "fraseDica=?, "
							+ "cartaEscolhida=?, "
							+ "pontuacao=?, "
							+ "where Id=?");
			up.setString(1, jog.getJogadorVez());
			up.setString(2, jog.getFraseDica());
			up.setString(3, jog.getCartaEscolhida());
			up.setInt(4, jog.getPontuacao());
			up.setInt(5, jog.getId());
			
			up.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
