package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidade.Funcionario;

public class FuncionarioDAO extends AbstratoDAO{
	
	public boolean adicionar(Funcionario funcionario)  {
		boolean adicionou = false;
		try {
			PreparedStatement stmt = conexao.prepareStatement(
					"insert into funcionario (nome, senha) values (?,?)");
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getSenha());
			
			int ad = stmt.executeUpdate();
			
			if(ad >0) {
				adicionou = true;
			}else {
				adicionou = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adicionou;
		
	}
	
	public boolean excluir(String nome, String senha) {
		boolean excluiu = false;
		try {
			PreparedStatement stmt = conexao.prepareStatement("delete from funcionario where nome = ? and senha = ?");
			stmt.setString(1, nome);
			stmt.setString(2, senha);
			int ex = stmt.executeUpdate();
			
			if(ex >0) {
				excluiu =  true;
			}else {
				excluiu = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return excluiu;
	}
	
	public Funcionario buscarPeloNome(String nome) {
		Funcionario func = null;
		try {
			PreparedStatement stmt = conexao.prepareStatement("select * from funcionario where nome = ?");
			stmt.setString(1, nome);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				func = new Funcionario();
				func.setId(rs.getInt("id"));
				func.setNome(rs.getString("nome"));	
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return func;
	}
	
	public List<Funcionario> listarFuncionarios(){
		List<Funcionario> funcionarios = new ArrayList<>();
		try {
			PreparedStatement stmt = conexao.prepareStatement("select * from funcionario");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Funcionario func = new Funcionario();
				func.setId(rs.getInt("id")); 
				func.setNome(rs.getString("nome"));
				
				funcionarios.add(func);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionarios;
	}
}
