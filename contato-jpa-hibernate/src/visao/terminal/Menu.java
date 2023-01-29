package visao.terminal;

import java.util.List;
import java.util.Scanner;

import modelo.DAO.ContatoDAO;
import modelo.entidade.Contato;

public class Menu {
	 
	public static void adicionarContato() {
		Scanner teclado = new Scanner(System.in);
		Contato contato = new Contato();
		System.out.println("Digite o nome do contato: ");
		contato.setNome(teclado.nextLine());
		
		System.out.println("Digite o celular do contato: ");
		contato.setCelular(teclado.nextInt());
		teclado.nextLine();
		
		System.out.println("Digite o email do contato: ");
		contato.setEmail(teclado.nextLine());
		
		ContatoDAO dao = new ContatoDAO();
		
		Contato c = dao.save(contato);
		if(c.equals(null)) {
			System.out.println("O contato não foi salvo!!");
		}else
			System.out.println("Contato salvo com sucesso!!!");
	}
	
	public static void excluirContato() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o id do contato: ");
		Integer id = teclado.nextInt();
		
		ContatoDAO dao = new ContatoDAO();
		dao.remove(id);
	}
	
	public static void atualizarCelular() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o id do contato: ");
		Integer id = teclado.nextInt();
		
		System.out.println("Digite o novo número do contato: ");
		Integer celular = teclado.nextInt();
		
		ContatoDAO dao = new ContatoDAO();
		dao.atualizar(id, celular);
		
	}
	
	public static void buscarPeloId() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite o id do contato: ");
		Integer id = teclado.nextInt();
		
		ContatoDAO dao = new ContatoDAO();
		
		Contato contato = dao.encontrarPeloId(id);
		
		System.out.println("---------------------");
		System.out.println("ID: " + contato.getId());
		System.out.println("Nome: " + contato.getNome());
		System.out.println("E-mail: " + contato.getEmail());
	}
	
	public static void buscarTodos() {
		ContatoDAO dao = new ContatoDAO();
		
		List<Contato> contatos =  dao.finAll();
		
		for (Contato contato : contatos) {
			System.out.println("----------------------------");
			System.out.println("ID: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("E-mail: " + contato.getEmail());
			System.out.println("----------------------------");
		}
	}
	
	
}

