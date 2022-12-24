package CRUD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JTextPane;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordLogin;
	JTextField txtLogin;
	private JTextField txtCodigoInst;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setResizable(false);
		setFont(new Font("Tahoma", Font.PLAIN, 15));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Avalia Escola");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(175, 39, 133, 14);
		contentPane.add(lblNewLabel);
		
		final JRadioButton radioButtonFun = new JRadioButton("Funcionário");
		buttonGroup.add(radioButtonFun);
		radioButtonFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButtonFun.isSelected()){
					txtCodigoInst.setEnabled(true);
				}else {
					txtCodigoInst.setEnabled(false);
				}
			}
		});
		
		txtCodigoInst = new JTextField();
		txtCodigoInst.setEnabled(false);
		txtCodigoInst.setBounds(167, 333, 150, 21);
		contentPane.add(txtCodigoInst);
		txtCodigoInst.setColumns(10);
		radioButtonFun.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioButtonFun.setBounds(97, 112, 109, 23);
		contentPane.add(radioButtonFun);
		
		final JRadioButton radioButtonAluno = new JRadioButton("Aluno");
		buttonGroup.add(radioButtonAluno);
		radioButtonAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButtonAluno.isSelected()) {
					txtCodigoInst.setEnabled(false);
				}
			}
		});
		radioButtonAluno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioButtonAluno.setBounds(294, 112, 66, 23);
		contentPane.add(radioButtonAluno);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(52, 180, 54, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(52, 257, 54, 14);
		contentPane.add(lblNewLabel_1_1);
		
		passwordLogin = new JPasswordField();
		passwordLogin.setBounds(167, 258, 150, 23);
		contentPane.add(passwordLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(167, 178, 150, 23);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JButton buttonEntrar = new JButton("Entrar");
		buttonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButtonAluno.isSelected()) {
					alunosCRUD loginAlu = new alunosCRUD();
					loginAlu.listarAlunos(txtLogin.getText(), new String(passwordLogin.getPassword()));
					dispose();
					TelaFeed feed = new TelaFeed();
					feed.setVisible(true);
			}if(radioButtonFun.isSelected()) {
					funcionariosCRUD fun = new funcionariosCRUD();
					fun.listarFun(txtLogin.getText(), new String(passwordLogin.getPassword()), txtCodigoInst.getCaretPosition());
					dispose();
					TelaFeed feed = new TelaFeed();
					feed.setVisible(true);
				}
		}
	});
		buttonEntrar.setBounds(197, 390, 90, 28);
		contentPane.add(buttonEntrar);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Código da Instituição");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(31, 337, 124, 14);
		contentPane.add(lblNewLabel_1_1_1);
	}
}
