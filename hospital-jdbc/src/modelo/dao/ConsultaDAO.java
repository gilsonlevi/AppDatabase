package modelo.dao;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import modelo.entidade.Consulta;

public class ConsultaDAO extends AbstratoDAO{
	
	public boolean adicionarConsulta(int matricula, String cpf, LocalDateTime horario, double valor) {
		boolean adicionou = false;
			try {
				PreparedStatement stmt = conexao.prepareStatement("INSERT INTO consulta (id_medico, id_paciente, horario, valor) VALUES "
						+ "((SELECT id FROM medico WHERE medico.matricula = ?), "
						+ "(SELECT id FROM paciente WHERE paciente.cpf = ?), ?, ?)");	
				stmt.setInt(1, matricula);
				stmt.setString(2, cpf);
				stmt.setObject(3, horario);
				stmt.setDouble(4, valor);

				
				adicionou = stmt.executeUpdate() == 1;
				
			} catch (Exception e) {
				
			}
		return adicionou;
	}

}
