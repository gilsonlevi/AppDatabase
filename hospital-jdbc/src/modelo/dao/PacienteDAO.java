package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.entidade.Medico;
import modelo.entidade.Paciente;

public class PacienteDAO extends AbstratoDAO{
	
	public boolean adicionarPaciente(Paciente paciente) {
		boolean adicionar = false;
		
		try {
			PreparedStatement stmt = conexao.prepareStatement("insert into paciente(nome, cpf, doenca) values (?,?,?)");	
			stmt.setString(1, paciente.getNome());
			stmt.setString(2, paciente.getCpf());
			stmt.setString(3, paciente.getDoenca());
			
			adicionar = stmt.executeUpdate() == 1;
			
		} catch (Exception e) {
			
		}
		return adicionar;
	}
	
	public Paciente buscarPorCPF(int cpf) {
		Paciente paciente = null;
		try {
			PreparedStatement stmt = conexao.prepareStatement("select from paciente where cpf = ?");
			stmt.setInt(1, cpf);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				paciente = new Paciente();
				
				paciente.setId(rs.getInt("id"));
				paciente.setNome(rs.getString("nome"));
				paciente.setCpf(rs.getString("cpf"));
				paciente.setDoenca(rs.getString("doenca"));
			}
			
			
		} catch (Exception e) {
			
		}
		return paciente;
	}

}
