package visao.terminal;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		while(true) {
			System.out.println("0. Sair do programa");
			System.out.println("1. Adicionar contato");
			System.out.println("2. Remover contato ");
			System.out.println("3. Atualizar celular do contato");
			System.out.println("4. Consultar contato");
			System.out.println("5. Listar contatos");
			System.out.println("Digite sua resposta: ");
			int resp = teclado.nextInt();
			teclado.nextLine();
			if(resp == 0) {
				System.out.println("Saindo do programa...");
				break;
			}else if (resp == 1) {
				Menu.adicionarContato();
			}else if (resp == 2) {
				Menu.excluirContato();
			}else if (resp == 3) {
				Menu.atualizarCelular();
			}else if (resp == 4) {
				Menu.buscarPeloId();
			}else if (resp == 5) {
				Menu.buscarTodos();
			}
			
			
		}
		
	}
}

