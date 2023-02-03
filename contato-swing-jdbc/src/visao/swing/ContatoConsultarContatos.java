package visao.swing;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import modelo.dao.ContatoDAO;
import modelo.entidade.Contato;

import javax.swing.JScrollPane;

public class ContatoConsultarContatos extends JFrame {

	private JPanel contentPane;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContatoConsultarContatos frame = new ContatoConsultarContatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContatoConsultarContatos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		String[] colunas = {"ID", "Nome", "Email", "Celular"};
		Object[][] dados = listar();
		contentPane.setLayout(null);
		
		tabela = new JTable(dados, colunas);
		
		JScrollPane barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(10, 10, 476, 157);
		contentPane.add(barraRolagem);
	}
	
	private Object[][] listar() {
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.listarContatos();

		Object[][] matriz = new Object[contatos.size()][4];
		
		
		for (Contato contato : contatos) {
			matriz[0][0] = contato.getId();
		}

		for (int i = 0; i < matriz.length; i++) {
			matriz[i][0] = contatos.get(i).getId();
			matriz[i][1] = contatos.get(i).getNome();
			matriz[i][2] = contatos.get(i).getEmail();
			matriz[i][3] = contatos.get(i).getCelular();
		}

		return matriz;
	}
	

}
