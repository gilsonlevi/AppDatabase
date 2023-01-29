package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.entidade.Medico;

public class MedicoDAO extends AbstratoDAO {

	public boolean adicionarMedico(Medico medico) {
		boolean adicionou = false;
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(
					"insert into medico(nome, matricula, especialidade, salario) values (?,?,?,?)");
			stmt.setString(1, medico.getNome());
			stmt.setInt(2, medico.getMatricula());
			stmt.setString(3, medico.getEspecialidade());
			stmt.setDouble(4, medico.getSalario());
			
			adicionou = stmt.executeUpdate() == 1;
			
		} catch (Exception e) {
			
		}
		return adicionou;
	}
	
	public Medico buscarPorMatricula(int Matricula) {
		Medico medico = null;
		try {
			PreparedStatement stmt = conexao.prepareStatement("select from medico where matricula = ?");
			stmt.setInt(1, Matricula);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				medico = new Medico();
				
				medico.setId(rs.getInt("id"));
				medico.setNome(rs.getString("nome"));
				medico.setMatricula(rs.getInt("matricula"));
				medico.setEspecialidade(rs.getString("especialidade"));
				medico.setSalario(rs.getDouble("salario"));
			}
			
			
		} catch (Exception e) {
			
		}
		return medico;
	}
	
	
	
}
