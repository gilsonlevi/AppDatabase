package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.entidade.Aluno;

public class AlunoDAO extends AbstratoDAO{
	
	public boolean adicionar(Aluno aluno)  {
		boolean adicionou = false;
		try {
			PreparedStatement stmt = conexao.prepareStatement(
					"insert into aluno (nome, senha) values (?,?)");
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getSenha());
			
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
			PreparedStatement stmt = conexao.prepareStatement("delete from aluno where nome = ? and senha = ?");
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
	
	public Aluno buscarPeloNome(String nome) {
		Aluno aluno = null;
		try {
			PreparedStatement stmt = conexao.prepareStatement("select * from aluno where nome = ?");
			stmt.setString(1, nome);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));	
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return aluno;
	}
	
	public List<Aluno> listarAlunos(){
		List<Aluno> alunos = new ArrayList<>();
		try {
			PreparedStatement stmt = conexao.prepareStatement("select * from aluno");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id")); 
				aluno.setNome(rs.getString("nome"));
				
				alunos.add(aluno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}
}
