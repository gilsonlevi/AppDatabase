package visao.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.dao.ContatoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ContatoAtualizarCelular extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCelular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContatoAtualizarCelular frame = new ContatoAtualizarCelular();
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
	public ContatoAtualizarCelular() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ATUALIZAR CELULAR DO CONTATO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(84, 36, 269, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNome.setBounds(26, 72, 72, 33);
		contentPane.add(lbNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(108, 80, 153, 25);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lbCelular = new JLabel("Novo Celular:");
		lbCelular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCelular.setBounds(10, 122, 113, 25);
		contentPane.add(lbCelular);
		
		tfCelular = new JTextField();
		tfCelular.setColumns(10);
		tfCelular.setBounds(108, 121, 153, 25);
		contentPane.add(tfCelular);
		
		JButton btnNewButton = new JButton("ALTERAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnNewButton.setBounds(137, 193, 137, 33);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContatoTelaInicial cont  = new ContatoTelaInicial();
				dispose();
				cont.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
	}
	
	public void limpar() {
		tfNome.setText("");
		tfCelular.setText("");
	}
	
	public void alterar() {
		try {
			String nome = tfNome.getText();
			int celular  = Integer.parseInt(tfCelular.getText());
			
			ContatoDAO dao = new ContatoDAO();
			
			boolean alterou = dao.alterarCelular(celular, nome);
			
			if(alterou == true) {
				JOptionPane.showMessageDialog(this, "O celular foi alterado!!", "Celular Alterado",
						JOptionPane.INFORMATION_MESSAGE);
				limpar();
			}else if(alterou == false) {
				JOptionPane.showMessageDialog(this, "O contato não foi encontrado!!", "Contato Não Encontrado",
						JOptionPane.ERROR_MESSAGE);
				limpar();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Valor Invalido!!", "Valor Invalido",
					JOptionPane.ERROR_MESSAGE);
				limpar();
		}
		
		
	}
}
