package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import modelo.entidade.Consulta;
import modelo.entidade.Medico;
import modelo.entidade.Paciente;
import visao.terminal.DateUtil;

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

	public boolean remover(int matricula, String cpf, LocalDateTime horario) {
		boolean removeu = false;
		try {
			PreparedStatement stmt = conexao.prepareStatement(
					"delete from consulta where id_medico = (SELECT id FROM medico WHERE medico.matricula = ?) and "
					+ "id_paciente = (select id from paciente where paciente.cpf = ?) and horario = ?");
			stmt.setInt(1, matricula);
			stmt.setString(2, cpf);
			stmt.setObject(3, horario);

			int rem = stmt.executeUpdate();
			if(rem  >= 1) {
				removeu = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return removeu;
		}
		return removeu;
	}
	
	
	public boolean atualizar(int matricula,String cpf,LocalDateTime horario, LocalDateTime novoHorario) {
		boolean atualizou = false;
		try (PreparedStatement stmt = conexao.prepareStatement("UPDATE consulta SET consulta.horario = ? WHERE "
				+ "id_medico = (SELECT id FROM medico WHERE medico.matricula = ?) AND "
				+ "id_paciente = (SELECT id FROM paciente WHERE paciente.cpf = ?) AND horario = ?")) {
			stmt.setObject(1, novoHorario);
			stmt.setInt(2, matricula);
			stmt.setString(3, cpf);
			stmt.setObject(4, horario);

			int atu = stmt.executeUpdate();
			
			if(atu <= 1) {
				atualizou = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			atualizou = false;
		}
		return atualizou;
	}
	
	
	public List<Consulta> listar() {
		List<Consulta> consultas = new ArrayList<Consulta>();
		try {
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM consulta "
					+ "INNER JOIN medico ON medico.id = consulta.id_medico "
					+ "INNER JOIN paciente ON paciente.id = consulta.id_paciente");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Medico medico = new Medico();
				medico.setId(rs.getInt("medico.id"));
				medico.setNome(rs.getString("medico.nome"));
				medico.setMatricula(rs.getInt("medico.matricula"));
				medico.setEspecialidade(rs.getString("medico.especialidade"));
				medico.setSalario(rs.getDouble("medico.salario"));
				
				Paciente paciente  = new Paciente();
				paciente.setId(rs.getInt("paciente.id"));
				paciente.setNome(rs.getString("paciente.nome"));
				paciente.setCpf(rs.getString("paciente.cpf"));
				paciente.setDoenca(rs.getString("paciente.doenca"));
				
				Consulta consulta = new Consulta();
				consulta.setMedico(medico);
				consulta.setPaciente(paciente);
				consulta.setHorario(rs.getObject("consulta.horario", LocalDateTime.class));
				consulta.setValor(rs.getDouble("consulta.valor"));
				
				consultas.add(consulta);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return consultas;
	}
	
}
