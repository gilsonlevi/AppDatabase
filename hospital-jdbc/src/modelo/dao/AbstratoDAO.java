package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstratoDAO {
	
	protected Connection conexao;
	
	public AbstratoDAO() {
		final String url = "jdbc:mysql://10.225.0.4/20201164010004_hospital_jdbc";
		final String usuario = "20201164010004+alves";
		final String senha = "20201164010004+alves";
		
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