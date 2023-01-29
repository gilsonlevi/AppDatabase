package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import modelo.entidade.Contato;
import visao.terminal.DateUtil;

public class ContatoDAO extends AbstratoDAO{
	
	public boolean adicionarContato(Contato contato) {
		boolean adicionou = false;
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(
					"insert into contato (nome, email, celular, nascimento) values (?,?,?,?)");
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setInt(3, contato.getCelular());
			stmt.setObject(4, contato.getNascimento());
			
			adicionou = stmt.executeUpdate() == 1;
		} catch (Exception e) {
			fecharConexao();
		}
		return adicionou;
	}
	
	public boolean excluirContato(String nome) {
		boolean deletou = false;
		try {
			PreparedStatement stmt = conexao.prepareStatement("delete from contato where nome = ?");
			stmt.setString(1, nome);
			
			deletou = stmt.executeUpdate() == 1;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return deletou;
	}
	
	public Contato consultarContato(String nome) {
		Contato contato = null;
		try {
			PreparedStatement stmt = conexao.prepareStatement("select * from contato where nome = ?");
			stmt.setString(1, nome);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				contato = new Contato();
				
				contato.setId(rs.getInt("id")); 
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				LocalDate nascimento = rs.getObject("nascimento", LocalDate.class);
				contato.setNascimento(nascimento);
				
			}
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return contato;
		
	}
	
	public boolean alterarCelular(int celular, String nome) {
		boolean alterar = false;
		
		try {
			PreparedStatement stmt = conexao.prepareStatement("update contato set celular = ? where nome = ?");
			stmt.setInt(1, celular);
			stmt.setString(2, nome);
			
			alterar = stmt.executeUpdate() == 1;
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return alterar;
	}
	
	
}
