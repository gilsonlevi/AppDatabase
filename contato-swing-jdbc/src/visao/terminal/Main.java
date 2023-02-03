package visao.terminal;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import modelo.dao.ContatoDAO;
import modelo.entidade.Contato;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		while(true) {
			System.out.println("0. Sair do programa");
			System.out.println("1. Adicionar contato");
			System.out.println("2. Consultar contato");
			System.out.println("3. Listar contatos");
			System.out.println("Digite sua opcão");
			int opcao = teclado.nextInt();
			teclado.nextLine();
			
			if(opcao == 0) {
				System.out.println("Saindo do programa...");
				break;
			}else if (opcao == 1) {
				Contato contato = new Contato();
				System.out.println("Digite o nome do contato: ");
				contato.setNome(teclado.nextLine());
				
				System.out.println("Digite o email do contato: ");
				contato.setEmail(teclado.nextLine());
				
				System.out.println("Digite o celular do contato: ");
				contato.setCelular(teclado.nextInt());
				teclado.nextLine();
				
				System.out.println("Digite a data de nascimento do contato: ");
				contato.setNascimento(DateUtil.stringToDate(teclado.nextLine(), LocalDate.class));
				
				ContatoDAO dao = new ContatoDAO();
				boolean adicionou = dao.adicionarContato(contato);
				
				if(adicionou == true) {
					System.out.println("Contato adicionado com sucesso!!");
				}
				
			}else if(opcao == 2) {
				System.out.println("Digite um nome: ");
				String nome = teclado.nextLine();
				
				ContatoDAO dao = new ContatoDAO();
				Contato contato = dao.consultarContato(nome);
				
				if(contato != null) {
					System.out.println(contato.getId());
					System.out.println(contato.getNascimento());
				}else
					System.out.println("O contato não foi encontrado!!");

			}else if (opcao == 3) {
				ContatoDAO dao = new ContatoDAO();
				List<Contato> contatos =  dao.listarContatos();
				
				for (Contato contato : contatos) {
					System.out.println("ID: " + contato.getId());
				}
				
			}
			
		}
	}

}
