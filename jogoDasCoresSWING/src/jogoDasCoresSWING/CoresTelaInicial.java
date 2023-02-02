package jogoDasCoresSWING;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botaoMagenta = new JButton("Magenta");
		botaoMagenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoMagenta.setEnabled(false);
				botaoMagenta.setBackground(Color.LIGHT_GRAY);
				
			}
		});
		botaoMagenta.setContentAreaFilled(false);
		botaoMagenta.setOpaque(true);
		botaoMagenta.setBackground(Color.magenta);

		botaoMagenta.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoMagenta.setBounds(10, 11, 120, 120);
		contentPane.add(botaoMagenta);
		
		JButton botaoAzul = new JButton("Azul");
		botaoAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoAzul.setEnabled(false);
				botaoAzul.setBackground(Color.LIGHT_GRAY);
			}
		});
		botaoAzul.setForeground(Color.WHITE);
		botaoAzul.setContentAreaFilled(false);
		botaoAzul.setOpaque(true);
		botaoAzul.setBackground(Color.blue);
		
		botaoAzul.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoAzul.setBounds(10, 145, 120, 120);
		contentPane.add(botaoAzul);
		
		JButton botaoVerde = new JButton("Verde");
		botaoVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoVerde.setEnabled(false);
				botaoVerde.setBackground(Color.LIGHT_GRAY);
				
			}
		});
		botaoVerde.setContentAreaFilled(false);
		botaoVerde.setOpaque(true);
		botaoVerde.setBackground(Color.green);
		
		botaoVerde.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoVerde.setBounds(160, 11, 120, 120);
		contentPane.add(botaoVerde);
		
		JButton botaoLaranja = new JButton("Laranja");
		botaoLaranja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoLaranja.setEnabled(false);
				botaoLaranja.setBackground(Color.LIGHT_GRAY);
			}
		});
		botaoLaranja.setContentAreaFilled(false);
		botaoLaranja.setOpaque(true);
		botaoLaranja.setBackground(Color.orange);
		
		botaoLaranja.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoLaranja.setBounds(304, 11, 120, 120);
		contentPane.add(botaoLaranja);
		
		JButton botaoCinza = new JButton("Cinza");
		botaoCinza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoCinza.setEnabled(false);
				botaoCinza.setBackground(Color.LIGHT_GRAY);
			}
		});
		botaoCinza.setContentAreaFilled(false);
		botaoCinza.setOpaque(true);
		botaoCinza.setBackground(Color.gray);
		
		botaoCinza.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoCinza.setBounds(304, 145, 120, 120);
		contentPane.add(botaoCinza);
		
		JButton botaoBranco = new JButton("Branco");
		botaoBranco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoBranco.setEnabled(false);
				botaoBranco.setBackground(Color.LIGHT_GRAY);
			}
		});
		botaoBranco.setContentAreaFilled(false);
		botaoBranco.setOpaque(true);
		botaoBranco.setBackground(Color.white);
		
		botaoBranco.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoBranco.setBounds(10, 280, 120, 120);
		contentPane.add(botaoBranco);
		
		JButton botaoPreto = new JButton("Preto");
		botaoPreto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoPreto.setEnabled(false);
				botaoPreto.setBackground(Color.LIGHT_GRAY);
			}
		});
		botaoPreto.setForeground(Color.WHITE);
		botaoPreto.setContentAreaFilled(false);
		botaoPreto.setOpaque(true);
		botaoPreto.setBackground(Color.black);
		
		botaoPreto.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoPreto.setBounds(160, 280, 120, 120);
		contentPane.add(botaoPreto);
		
		JButton botaoVermelho = new JButton("Vermelho");
		botaoVermelho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoVermelho.setEnabled(false);
				botaoVermelho.setBackground(Color.LIGHT_GRAY);
			}
		});
		botaoVermelho.setContentAreaFilled(false);
		botaoVermelho.setOpaque(true);
		botaoVermelho.setBackground(Color.red);
		
		botaoVermelho.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoVermelho.setBounds(304, 280, 120, 120);
		contentPane.add(botaoVermelho);
		
		JButton botaoRosa = new JButton("Rosa");
		botaoRosa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoRosa.setEnabled(false);
				botaoRosa.setBackground(Color.LIGHT_GRAY);
			}
		});
		botaoRosa.setContentAreaFilled(false);
		botaoRosa.setOpaque(true);
		botaoRosa.setBackground(Color.pink);
		
		botaoRosa.setFont(new Font("Tahoma", Font.BOLD, 17));
		botaoRosa.setBounds(160, 145, 120, 120);
		contentPane.add(botaoRosa);
	}
}
