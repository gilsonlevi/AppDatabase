package jogoDasCoresSWING;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CoresTelaInicial extends JFrame {

	private JPanel contentPane;
	private JButton botaoMagenta;
	private JButton botaoAzul;
	private JButton botaoVerde;
	private JButton botaoLaranja;
	private JButton botaoCinza;
	private JButton botaoBranco;
	private JButton botaoPreto;
	private JButton botaoVermelho;
	private JButton botaoRosa;
	
	private List<String> cores = new ArrayList();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoresTelaInicial frame = new CoresTelaInicial();
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
	public CoresTelaInicial() {
		setTitle("Cores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 488);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		botaoMagenta = new JButton("Magenta");
		botaoMagenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoMagenta.setEnabled(false);
				botaoMagenta.setBackground(Color.LIGHT_GRAY);
				cores.add("Magenta");
				checarTodosBotoes();
			}
		});
		botaoMagenta.setContentAreaFilled(false);
		botaoMagenta.setOpaque(true);
		botaoMagenta.setBackground(Color.magenta);

		botaoMagenta.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoMagenta.setBounds(10, 11, 120, 120);
		contentPane.add(botaoMagenta);
		
		botaoAzul = new JButton("Azul");
		botaoAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoAzul.setEnabled(false);
				botaoAzul.setBackground(Color.LIGHT_GRAY);
				cores.add("Azul");
				checarTodosBotoes();
			}
		});
		botaoAzul.setForeground(Color.WHITE);
		botaoAzul.setContentAreaFilled(false);
		botaoAzul.setOpaque(true);
		botaoAzul.setBackground(Color.blue);
		
		botaoAzul.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoAzul.setBounds(10, 145, 120, 120);
		contentPane.add(botaoAzul);
		
		botaoVerde = new JButton("Verde");
		botaoVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoVerde.setEnabled(false);
				botaoVerde.setBackground(Color.LIGHT_GRAY);
				cores.add("Verde");
				checarTodosBotoes();
			}
		});
		botaoVerde.setContentAreaFilled(false);
		botaoVerde.setOpaque(true);
		botaoVerde.setBackground(Color.green);
		
		botaoVerde.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoVerde.setBounds(160, 11, 120, 120);
		contentPane.add(botaoVerde);
		
		botaoLaranja = new JButton("Laranja");
		botaoLaranja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoLaranja.setEnabled(false);
				botaoLaranja.setBackground(Color.LIGHT_GRAY);
				cores.add("Laranja");
				checarTodosBotoes();
			}
		});
		botaoLaranja.setContentAreaFilled(false);
		botaoLaranja.setOpaque(true);
		botaoLaranja.setBackground(Color.orange);
		
		botaoLaranja.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoLaranja.setBounds(304, 11, 120, 120);
		contentPane.add(botaoLaranja);
		
		botaoCinza = new JButton("Cinza");
		botaoCinza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoCinza.setEnabled(false);
				botaoCinza.setBackground(Color.LIGHT_GRAY);
				cores.add("Cinza");
				checarTodosBotoes();
			}
		});
		botaoCinza.setContentAreaFilled(false);
		botaoCinza.setOpaque(true);
		botaoCinza.setBackground(Color.gray);
		
		botaoCinza.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoCinza.setBounds(304, 145, 120, 120);
		contentPane.add(botaoCinza);
		
		botaoBranco = new JButton("Branco");
		botaoBranco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoBranco.setEnabled(false);
				botaoBranco.setBackground(Color.LIGHT_GRAY);
				cores.add("Branco");
				checarTodosBotoes();
			}
		});
		botaoBranco.setContentAreaFilled(false);
		botaoBranco.setOpaque(true);
		botaoBranco.setBackground(Color.white);
		
		botaoBranco.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoBranco.setBounds(10, 280, 120, 120);
		contentPane.add(botaoBranco);
		
		botaoPreto = new JButton("Preto");
		botaoPreto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoPreto.setEnabled(false);
				botaoPreto.setBackground(Color.LIGHT_GRAY);
				cores.add("Preto");
				checarTodosBotoes();
			}
		});
		botaoPreto.setForeground(Color.WHITE);
		botaoPreto.setContentAreaFilled(false);
		botaoPreto.setOpaque(true);
		botaoPreto.setBackground(Color.black);
		
		botaoPreto.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoPreto.setBounds(160, 280, 120, 120);
		contentPane.add(botaoPreto);
		
		botaoVermelho = new JButton("Vermelho");
		botaoVermelho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoVermelho.setEnabled(false);
				botaoVermelho.setBackground(Color.LIGHT_GRAY);
				cores.add("Vermelho");
				checarTodosBotoes();
			}
		});
		botaoVermelho.setContentAreaFilled(false);
		botaoVermelho.setOpaque(true);
		botaoVermelho.setBackground(Color.red);
		
		botaoVermelho.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoVermelho.setBounds(304, 280, 120, 120);
		contentPane.add(botaoVermelho);
		
		botaoRosa = new JButton("Rosa");
		botaoRosa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoRosa.setEnabled(false);
				botaoRosa.setBackground(Color.LIGHT_GRAY);
				cores.add("Rosa");
				checarTodosBotoes();
			}
		});
		botaoRosa.setContentAreaFilled(false);
		botaoRosa.setOpaque(true);
		botaoRosa.setBackground(Color.pink);
		
		botaoRosa.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoRosa.setBounds(160, 145, 120, 120);
		contentPane.add(botaoRosa);
		
		JButton reiniciar = new JButton("REINICIAR");
		reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciar();
			}
		});
		reiniciar.setBounds(160, 411, 120, 27);
		contentPane.add(reiniciar);
	}
	
	private void checarTodosBotoes() {
		if(botaoMagenta.isEnabled() == false && botaoAzul.isEnabled() == false && botaoBranco.isEnabled() == false && botaoCinza.isEnabled() == false 
				&& botaoLaranja.isEnabled() == false && botaoPreto.isEnabled() == false && botaoRosa.isEnabled() == false && botaoVerde.isEnabled() == false && botaoVermelho.isEnabled() == false
				) {
			JOptionPane.showMessageDialog(this, cores.get(0) +  " > " +  cores.get(1) +  " > " +  cores.get(2) +  " > " +  cores.get(3) +  " > " +  cores.get(4) +  " > " +  cores.get(5) +
					" > " +  cores.get(6) +  " > " +  cores.get(7) +  " > " +  cores.get(8), "Jogo das Cores",
					JOptionPane.INFORMATION_MESSAGE);			
		}
	}
	
	private void reiniciar () {
		 botaoMagenta.setEnabled(true);
		 botaoAzul.setEnabled(true);
		 botaoVerde.setEnabled(true);
		 botaoLaranja.setEnabled(true);
		 botaoCinza.setEnabled(true);
		 botaoBranco.setEnabled(true);
		 botaoPreto.setEnabled(true);
		 botaoVermelho.setEnabled(true);
		 botaoRosa.setEnabled(true);
		 
		 botaoMagenta.setBackground(Color.magenta);
		 botaoAzul.setBackground(Color.blue);
		 botaoVerde.setBackground(Color.green);
		 botaoLaranja.setBackground(Color.orange);
		 botaoCinza.setBackground(Color.gray);
		 botaoBranco.setBackground(Color.white);
		 botaoPreto.setBackground(Color.black);
		 botaoVermelho.setBackground(Color.red);
		 botaoRosa.setBackground(Color.pink);
		 
		 cores.clear();
	}
}