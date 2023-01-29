package visao.terminal;

import java.util.List;
import java.util.Scanner;

import modelo.dao.FuncionarioDAO;
import modelo.entidade.Funcionario;

public class Menu {
	
	public static void menuAdicionarFuncionario() {
		Scanner teclado = new Scanner(System.in);
		
		Funcionario funcionario = new Funcionario();
		
		System.out.println("Digite o nome do funcionario: ");
		funcionario.setNome(teclado.nextLine());
		
		System.out.println("Digite a senha do funcionario");
		funcionario.setSenha(teclado.nextLine());

		FuncionarioDAO dao = new FuncionarioDAO();
		
		boolean ad = dao.adicionar(funcionario);
		
		if(ad) {
			System.out.println("Funcionario adicionado com sucesso!!!");
		}
	}
	
	public static void menuBuscarFuncionario() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o nome do funcionario: ");
		String nome = teclado.nextLine();
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		Funcionario func = dao.buscarPeloNome(nome);
		
		System.out.println("ID: " + func.getId());
		System.out.println("Nome: " + func.getNome());
	}
	
	public static void menuExcluirFuncionario() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o nome do funcionario: ");
		String nome = teclado.nextLine();
		
		System.out.println("Digite a senha da funcionario: ");
		String senha = teclado.nextLine();
		
		FuncionarioDAO dao = new FuncionarioDAO();
		boolean ex = dao.excluir(nome, senha);
		
		if(ex) {
			System.out.println("Funcionario excluido com sucesso!!!");
		}
		
	}
	
	public static void menuListarFuncionarios() {
		FuncionarioDAO dao = new FuncionarioDAO();
		
		List<Funcionario> funcionarios = dao.listarFuncionarios();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("ID: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
		}
	}
	
}