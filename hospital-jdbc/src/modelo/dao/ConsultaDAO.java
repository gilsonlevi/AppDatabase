package modelo.dao;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;

public class ConsultaDAO extends AbstratoDAO{
	
	public boolean adicionarConsulta(int matricula, String cpf, LocalDateTime horario, double valor) {
		boolean adicionou = false;
			try {
				PreparedStatement stmt = conexao.prepareStatement("insert into consulta (id_paciente, id_medico, horario, valor) values (?,?,?,?)");
				stmt.setString(1, cpf);
				stmt.setInt(2, matricula);
				stmt.setObject(3, horario);
				stmt.setDouble(4, valor);
				
				adicionou = stmt.executeUpdate() == 1;
				
			} catch (Exception e) {
				
			}
		return adicionou;
	}

}
