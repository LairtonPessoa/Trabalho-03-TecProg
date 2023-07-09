package model;

import java.sql.*;

public class Conexao {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conexao() {

		this.host = "127.0.0.1";
		this.banco = "gartic"; // segundo seu PC
		this.usuario = "root"; // segundo seu PC
		this.senha = ""; // segundo seu PC
	}

	public Connection getConexao() {
		String url = "jdbc:mysql://" + this.host + "/" + this.banco + "?verifyServerCertificate=false&useSSL=true";
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException ex) {
			System.out.println("Conexao com MYSQL nao realizada");
			ex.printStackTrace();
		}
		return null;
	}

}