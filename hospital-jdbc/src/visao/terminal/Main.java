package visao.terminal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

import modelo.dao.AbstratoDAO;
import modelo.dao.ConsultaDAO;
import modelo.dao.MedicoDAO;
import modelo.dao.PacienteDAO;
import modelo.entidade.Consulta;
import modelo.entidade.Medico;
import modelo.entidade.Paciente;

public class Main {
	public static void main(String[] args) throws SQLException {
		Scanner teclado = new Scanner(System.in);
		
		while(true) {
			System.out.println("0. Sair do programa");
			System.out.println("1. Cadastrar medico");
			System.out.println("2. Cadastrar paciente");
			System.out.println("3. Buscar medico por matricula");
			System.out.println("4. Buscar paciente por CPF");
			System.out.println("5. Cadastrar uma consulta");
			System.out.println("6. Remover uma consulta cadastrada");
			System.out.println("7. Atualizar o horario de uma consulta cadastrada");
			System.out.println("8. Gerar relatório das consultas");
			System.out.println("Digite sua opção: ");
			int opcao = teclado.nextInt();
			teclado.nextLine();
			
			if(opcao == 0) {
				System.out.println("Saindo do programa");
				break;
			}else if(opcao == 1) {
				Medico medico = new Medico();
				System.out.println("Digite o nome do medico: ");
				medico.setNome(teclado.nextLine());
				
				System.out.println("Digite a matricula: ");
				medico.setMatricula(teclado.nextInt());
				teclado.nextLine();
				
				System.out.println("Digite a especialidade: ");
				medico.setEspecialidade(teclado.nextLine());
				
				System.out.println("Digite o salario: ");
				medico.setSalario(teclado.nextDouble());
				
				MedicoDAO dao = new MedicoDAO();
				boolean adicionou = dao.adicionarMedico(medico);
				if(adicionou == true) {
					System.out.println("Medico adicionado com sucesso!!");
				}
				
			}else if (opcao == 2) {
				Paciente paciente = new Paciente();
				System.out.println("Digite o nome do paciente: ");
				paciente.setNome(teclado.nextLine());
				
				System.out.println("Digite o CPF: ");
				paciente.setCpf(teclado.nextLine());
				
				System.out.println("Digite a doença: ");
				paciente.setDoenca(teclado.nextLine());
				
				PacienteDAO dao = new PacienteDAO();
				
				boolean adicionou = dao.adicionarPaciente(paciente);
				
				if(adicionou == true) {
					System.out.println("Paciente adicionado com sucesso!!");
				}
			}else if (opcao == 3) {
				Medico medico = new Medico();
				System.out.println("Digite a matricula do medico: ");
				int matricula = teclado.nextInt();
				
				MedicoDAO dao = new MedicoDAO();

				medico = dao.buscarPorMatricula(matricula);

				System.out.println("ID: " + medico.getId());
				System.out.println("Nome: " + medico.getNome());
				System.out.println("Matricula: " + medico.getMatricula());
				System.out.println("Especialidade: " + medico.getEspecialidade());
				System.out.println("Salario: " + medico.getSalario());
				System.out.println("--------------------------------");	
			}else if (opcao == 4) {
				Paciente paciente = new Paciente();
				
				System.out.println("Digite o CPF do paciente: ");
				String cpf = teclado.nextLine();
				
				PacienteDAO dao = new PacienteDAO();
				
				paciente = dao.buscarPorCPF(cpf);
				
				System.out.println("ID: " + paciente.getId());
				System.out.println("Nome: " + paciente.getNome());
				System.out.println("CPF: " + paciente.getCpf());
				System.out.println("Doença: " + paciente.getDoenca());
				System.out.println("--------------------------------");	
			}else if (opcao == 5) {
	
				Consulta consulta = new Consulta();
				System.out.println("Digite a matricula do medico: ");
				int matricula = teclado.nextInt();
				teclado.nextLine();
				
				System.out.println("Digite o CPF do paciente: ");
				String cpf = teclado.nextLine();
				
				System.out.println("Digite o horario da consulta: ");
				LocalDateTime horario = DateUtil.stringToDate(teclado.nextLine(), LocalDateTime.class); 
				
				System.out.println("Digite o valor da consulta: ");
				double valor = teclado.nextDouble();
				
				ConsultaDAO dao = new ConsultaDAO();
				
				
				
				boolean adicionou = dao.adicionarConsulta(matricula, cpf, horario, valor);
				
				if(adicionou == true) {
					System.out.println("Consulta adicionada com sucesso!!");
				}else if(adicionou == false) {
					System.out.println("A consulta não foi adicionada");
				}
			
			}else if (opcao == 6) {
				
			}else if (opcao == 7) {
				
			}else if (opcao == 8) {
				
			}
		}
		
	}
}
