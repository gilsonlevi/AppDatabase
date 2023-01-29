package visao.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.dao.ContatoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import java.awt.Font;

public class DeletarContato extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletarContato frame = new DeletarContato();
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
	public DeletarContato() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DELETAR CONTATO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(151, 11, 158, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lbNome = new JLabel("Nome do Contato:");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNome.setBounds(10, 45, 147, 14);
		contentPane.add(lbNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(167, 42, 131, 20);
		contentPane.add(tfNome);
		
		JButton btDeletar = new JButton("DELETAR");
		btDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarContato();
			}
		});
		btDeletar.setBounds(55, 120, 147, 40);
		contentPane.add(btDeletar);
		
		JButton btVoltar = new JButton("VOLTAR");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContatoTelaInicial cont = new ContatoTelaInicial();
				dispose();
				cont.setVisible(true);
			}
		});
		btVoltar.setBounds(10, 9, 89, 23);
		contentPane.add(btVoltar);
		
		JButton btLimpar = new JButton("LIMPAR");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btLimpar.setBounds(223, 120, 147, 40);
		contentPane.add(btLimpar);
	}
	
	public void limpar() {
		tfNome.setText("");
	}
	
	public void deletarContato() {
		String nome = tfNome.getText();
		
		ContatoDAO dao = new ContatoDAO();
		boolean excluiu = dao.excluirContato(nome);
		
		if(excluiu == true) {
			JOptionPane.showMessageDialog(this, "Contato excluido com sucesso!!", "Contato Excluido",
					JOptionPane.INFORMATION_MESSAGE);
			limpar();
		}else if (excluiu == false) {
			JOptionPane.showMessageDialog(this, "O contato não foi encontrato", "Contato Não Encontrado",
					JOptionPane.INFORMATION_MESSAGE);
			limpar();
		}
	}
}
