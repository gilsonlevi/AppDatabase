package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstratoDAO {
	
	protected Connection conexao;
	
	public AbstratoDAO() {
		final String url = "jdbc:mysql://localhost/academia2";
		final String usuario = "root";
		final String senha = "@JNL12345silva";
		
		try {
			conexao =  DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void fecharConexao() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
	}
}
