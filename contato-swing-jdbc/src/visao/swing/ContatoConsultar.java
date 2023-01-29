package visao.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.dao.ContatoDAO;
import modelo.entidade.Contato;
import visao.terminal.DateUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ContatoConsultar extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfID;
	private JTextField tfNome2;
	private JTextField tfEmail;
	private JTextField tfNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContatoConsultar frame = new ContatoConsultar();
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
	public ContatoConsultar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULTAR CONTATO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(150, 11, 180, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNome.setBounds(10, 42, 67, 14);
		contentPane.add(lbNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(87, 41, 115, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btConsultar = new JButton("CONSULTAR");
		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		btConsultar.setBounds(50, 200, 118, 36);
		contentPane.add(btConsultar);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(227, 47, 31, 14);
		contentPane.add(lblNewLabel_1);
		
		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setColumns(10);
		tfID.setBounds(268, 41, 156, 20);
		contentPane.add(tfID);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(205, 72, 58, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(212, 106, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nascimento:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(170, 140, 81, 14);
		contentPane.add(lblNewLabel_4);
		
		tfNome2 = new JTextField();
		tfNome2.setEditable(false);
		tfNome2.setColumns(10);
		tfNome2.setBounds(268, 72, 156, 20);
		contentPane.add(tfNome2);
		
		tfEmail = new JTextField();
		tfEmail.setEditable(false);
		tfEmail.setColumns(10);
		tfEmail.setBounds(268, 105, 156, 20);
		contentPane.add(tfEmail);
		
		tfNascimento = new JTextField();
		tfNascimento.setEditable(false);
		tfNascimento.setColumns(10);
		tfNascimento.setBounds(268, 136, 156, 20);
		contentPane.add(tfNascimento);
		
		JButton btVoltar = new JButton("VOLTAR");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContatoTelaInicial cont = new ContatoTelaInicial();
				dispose();
				cont.setVisible(true);
			}
		});  
		btVoltar.setBounds(10, 7, 89, 23);
		contentPane.add(btVoltar);
		
		JButton btLimpar = new JButton("LIMPAR");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btLimpar.setBounds(268, 200, 118, 36);
		contentPane.add(btLimpar);
	}
	
	public void limpar() {
		tfNome.setText("");
	}
	
	public void consultar() {
		Contato contato = null;
		try {
			String nome = this.tfNome.getText();
			
			ContatoDAO dao = new ContatoDAO();
			
			contato = dao.consultarContato(nome);
			
			if(contato != null) {
				tfID.setText(Integer.toString(contato.getId()));
				tfNome2.setText(contato.getNome());
				tfEmail.setText(contato.getEmail());
				tfNascimento.setText(DateUtil.dateToString(contato.getNascimento()));
			}else if(contato == null) {
				JOptionPane.showMessageDialog(this, "O contato não foi encontrado!!", "Contato Não Encontrado",
						JOptionPane.ERROR_MESSAGE);
				limpar();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
}
