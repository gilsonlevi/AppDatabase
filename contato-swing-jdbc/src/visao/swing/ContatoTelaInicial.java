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
import java.awt.Color;
import javax.swing.UIManager;

public class ContatoTelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContatoTelaInicial frame = new ContatoTelaInicial();
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
	public ContatoTelaInicial() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbAgenda = new JLabel("AGENDA");
		lbAgenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbAgenda.setBounds(188, 23, 94, 14);
		contentPane.add(lbAgenda);
		
		JButton btAddContato = new JButton("Adicionar Contato");
		btAddContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContatoAdicionar cont = new ContatoAdicionar();
				dispose();
				cont.setVisible(true);
			}
		});
		btAddContato.setBounds(256, 48, 153, 37);
		contentPane.add(btAddContato);
		
		JButton btRemoverContato = new JButton("Remover Contato");
		btRemoverContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletarContato deletContato = new DeletarContato();
				dispose();
				deletContato.setVisible(true);
				
			}
		});
		btRemoverContato.setBounds(17, 48, 158, 37);
		contentPane.add(btRemoverContato);
		
		JButton btVerContatos = new JButton("Ver Contatos");
		btVerContatos.setBounds(17, 116, 158, 37);
		contentPane.add(btVerContatos);
		
		JButton btConsulContato = new JButton("Consultar Contato");
		btConsulContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ContatoConsultar cont = new ContatoConsultar();
				dispose();
				cont.setVisible(true);
			}
		});
		btConsulContato.setBounds(256, 116, 153, 37);
		contentPane.add(btConsulContato);
		
		JButton btAtualizarCelular = new JButton("Atulizar Celular");
		btAtualizarCelular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContatoAtualizarCelular cont = new ContatoAtualizarCelular();
				dispose();
				cont.setVisible(true);
			}
		});
		btAtualizarCelular.setBounds(141, 189, 153, 37);
		contentPane.add(btAtualizarCelular);
	}

	
}


