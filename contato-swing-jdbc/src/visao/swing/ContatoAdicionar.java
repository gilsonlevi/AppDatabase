package visao.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.dao.ContatoDAO;
import modelo.entidade.Contato;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ContatoAdicionar extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfCelular;
	private JTextField tfNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContatoAdicionar frame = new ContatoAdicionar();
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
	public ContatoAdicionar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNome.setBounds(24, 45, 61, 14);
		contentPane.add(lbNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(81, 44, 141, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(81, 83, 141, 20);
		contentPane.add(tfEmail);
		
		tfCelular = new JTextField();
		tfCelular.setColumns(10);
		tfCelular.setBounds(81, 123, 141, 20);
		contentPane.add(tfCelular);
		
		tfNascimento = new JTextField();
		tfNascimento.setColumns(10);
		tfNascimento.setBounds(108, 169, 114, 20);
		contentPane.add(tfNascimento);
		
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbEmail.setBounds(24, 86, 46, 14);
		contentPane.add(lbEmail);
		
		JLabel lbCelular = new JLabel("Celular:");
		lbCelular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCelular.setBounds(24, 126, 53, 14);
		contentPane.add(lbCelular);
		
		JLabel lbNascimento = new JLabel("Nascimento:");
		lbNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNascimento.setBounds(24, 170, 81, 14);
		contentPane.add(lbNascimento);
		
		JLabel lblNewLabel_2 = new JLabel("NOVO CONTATO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(151, 11, 135, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btLimpar = new JButton("LIMPAR");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btLimpar.setBounds(247, 45, 177, 43);
		contentPane.add(btLimpar);
		
		JButton btAdicionarCont = new JButton("ADICIONAR CONTATO");
		btAdicionarCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarContato();
			}
		});
		btAdicionarCont.setBounds(247, 123, 177, 43);
		contentPane.add(btAdicionarCont);
		
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
	}
	
	public void limpar() {
		tfNome.setText("");
		tfCelular.setText("");
		tfEmail.setText("");
		tfNascimento.setText("");
	}
	
	public void adicionarContato() {
		try {
			boolean adicionou = false;;
			Contato contato = new Contato();
			
			contato.setNome(tfNome.getText());
			contato.setEmail(tfEmail.getText());
			contato.setCelular(Integer.parseInt(tfCelular.getText()));
			contato.setNascimento(DateUtil.stringToDate(tfNascimento.getText(), LocalDate.class));
			ContatoDAO dao = new ContatoDAO();
	
			adicionou = dao.adicionarContato(contato);
			
			if(adicionou == true) {
				JOptionPane.showMessageDialog(this, "Contato adicionado com sucesso!!", "Contato Adicionado",
						JOptionPane.INFORMATION_MESSAGE);
				limpar();
			}else if (adicionou == false){
				JOptionPane.showMessageDialog(this, "Você digitou um valor inválido, tente novamente!!", "Valor Inválido!",
						JOptionPane.ERROR_MESSAGE);
				limpar();
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Você digitou um valor inválido, tente novamente!!", "Valor Inválido!",
					JOptionPane.ERROR_MESSAGE);
			
			limpar();
		}
		
	}
}
