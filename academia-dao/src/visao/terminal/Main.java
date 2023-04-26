package visao.terminal;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		while(true) {
			System.out.println("Bem vindo");
			System.out.println("0. Sair do programa");
			System.out.println("1. Adicionar funcionario");
			System.out.println("2. Buscar funcionario");
			System.out.println("3. Excluir funcionario");
			System.out.println("4. Ver todos os funcionarios");
			System.out.println("Digite um opção: ");
			int resp = teclado.nextInt();
			teclado.nextLine();
			if(resp == 0) {
				System.out.println("----------------------------");
				System.out.println("Saindo do programa...");
				System.out.println("----------------------------");
				System.out.println("----------------------------");
				System.out.println("----------------------------");
				System.out.println("----------------------------");
				System.out.println("----------------------------");
				System.out.println("----------------------------");
				System.out.println("----------------------------");
				
				break;
			}else if (resp == 1) {
				Menu.menuAdicionarFuncionario();
			}else if (resp == 2) {
				Menu.menuBuscarFuncionario();
			}else if (resp == 3) {
				Menu.menuExcluirFuncionario();
			}else if (resp == 4) {
				Menu.menuListarFuncionarios();
			}
		}
		
		teclado.close();
	}
		
}

