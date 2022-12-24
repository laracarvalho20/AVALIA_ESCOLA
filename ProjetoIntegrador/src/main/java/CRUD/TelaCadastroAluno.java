package CRUD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCompleAlu;
	private JTextField txtDataNascAlu;
	private JTextField txtCPFAlu;
	private JTextField txtGeneroAlu;
	private JTextField txtNomeSocial;
	private JTextField txtDescPNEAlu;
	private JPasswordField passwordAlu;
	private JPasswordField passwordConfirAlu;

	boolean pneAlu = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAluno frame = new TelaCadastroAluno();
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
	public TelaCadastroAluno() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Aluno");
		lblNewLabel.setBounds(161, 23, 159, 14);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Completo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 54, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 103, 124, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setBounds(10, 155, 39, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gênero");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 201, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Senha");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 251, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Confirmar senha");
		lblNewLabel_6.setBounds(10, 295, 101, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Deseja incluir Nome Social?");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(10, 336, 159, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Portador de necessidade especial?");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7_1.setBounds(10, 429, 197, 14);
		contentPane.add(lblNewLabel_7_1);
		
		final JRadioButton radiobuttonNomeSocial = new JRadioButton("Sim");
		radiobuttonNomeSocial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radiobuttonNomeSocial.isSelected()){
					txtNomeSocial.setEnabled(true);
				}else {
					txtNomeSocial.setEnabled(false);
				}
			}
		});
		radiobuttonNomeSocial.setBounds(213, 333, 57, 23);
		contentPane.add(radiobuttonNomeSocial);
		
		final JRadioButton radiobuttonPNE = new JRadioButton("Sim");
		radiobuttonPNE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radiobuttonPNE.isSelected()){
					txtDescPNEAlu.setEnabled(true);
					pneAlu = true;
				}else {
					txtDescPNEAlu.setEnabled(false);
					pneAlu = false;
				}

			}
		});
		radiobuttonPNE.setBounds(213, 426, 57, 23);
		contentPane.add(radiobuttonPNE);
		
		JLabel lblNewLabel_8 = new JLabel("Nome Social");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(10, 383, 81, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Descrição PNE");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(10, 474, 88, 14);
		contentPane.add(lblNewLabel_9);
		
		txtNomeCompleAlu = new JTextField();
		txtNomeCompleAlu.setBounds(161, 48, 197, 20);
		contentPane.add(txtNomeCompleAlu);
		txtNomeCompleAlu.setColumns(10);
		
		txtDataNascAlu = new JTextField();
		txtDataNascAlu.setColumns(10);
		txtDataNascAlu.setBounds(161, 101, 197, 20);
		contentPane.add(txtDataNascAlu);
		
		txtCPFAlu = new JTextField();
		txtCPFAlu.setColumns(10);
		txtCPFAlu.setBounds(161, 152, 197, 20);
		contentPane.add(txtCPFAlu);
		
		txtGeneroAlu = new JTextField();
		txtGeneroAlu.setColumns(10);
		txtGeneroAlu.setBounds(161, 199, 197, 20);
		contentPane.add(txtGeneroAlu);
		
		txtNomeSocial = new JTextField();
		txtNomeSocial.setEnabled(false);
		txtNomeSocial.setColumns(10);
		txtNomeSocial.setBounds(161, 381, 197, 20);
		contentPane.add(txtNomeSocial);
		
		txtDescPNEAlu = new JTextField();
		txtDescPNEAlu.setEnabled(false);
		txtDescPNEAlu.setColumns(10);
		txtDescPNEAlu.setBounds(161, 471, 197, 20);
		contentPane.add(txtDescPNEAlu);
		
		passwordAlu = new JPasswordField();
		passwordAlu.setBounds(161, 249, 197, 23);
		contentPane.add(passwordAlu);
		
		passwordConfirAlu = new JPasswordField();
		passwordConfirAlu.setBounds(161, 292, 197, 23);
		contentPane.add(passwordConfirAlu);
		
		JButton buttonEnviar = new JButton("Enviar");
		buttonEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alunosCRUD.criarAlunos(pneAlu, new String(passwordAlu.getPassword()),
						txtDataNascAlu.getText(), txtNomeCompleAlu.getText(),
						txtCPFAlu.getText(), txtNomeSocial.getText(),
						txtGeneroAlu.getText(), txtDescPNEAlu.getText());
						dispose();
						TelaFeed feed = new TelaFeed();
						feed.setVisible(true);
			}
		});
		buttonEnviar.setBounds(197, 557, 89, 23);
		contentPane.add(buttonEnviar);
	}
}
