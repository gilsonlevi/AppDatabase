package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstratoDAO {
	
	protected Connection conexao;
	
	public AbstratoDAO() {
		final String url = "jdbc:mysql://localhost/20201164010016_hospital_jdbc";
		final String usuario = "20201164010016+aires";
		final String senha = "20201164010016+aires";
		
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
		}
	}
}