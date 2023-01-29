package visao.terminal;

import java.util.List;
import java.util.Scanner;

import modelo.dao.FuncionarioDAO;
import modelo.entidade.Funcionario;

public class Menu {
	
	public static void adicionarFuncionario() {
		Scanner teclado = new Scanner(System.in);
		Funcionario funcionario = new Funcionario();
	
		System.out.println("Digite o nome do funcionario: ");
		funcionario.setNome(teclado.nextLine());
		
		System.out.println("Digite a profissão do funcionario: ");
		funcionario.setProfissao(teclado.nextLine());
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.save(funcionario);
		
		System.out.println("Funcionario adicionado com sucesso!!!");
	}
	
	public static void excluirFuncionario() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o id do funcionario: ");
		Integer id = teclado.nextInt();
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.remove(id);
		
		System.out.println("Funcionario removido com sucesso!!");
	}
	
	public static void listarTodos() {
		FuncionarioDAO dao = new FuncionarioDAO();
		
		List<Funcionario> funcionarios =  dao.listarFuncionarios();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Id: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Profissão: " + funcionario.getProfissao());
		}
	}
	
	public static void buscarPeloId() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o id do funcionario: ");
		Integer id = teclado.nextInt();
		
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.findById(id);
		
		System.out.println("Id: " + funcionario.getId());
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Profissão: " + funcionario.getProfissao());
	} 
}
