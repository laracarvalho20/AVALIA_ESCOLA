package CRUD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCompletoFun;
	private JTextField txtDataNascFun;
	private JTextField txtCPfFun;
	private JTextField txtFuncaoFun;
	private JTextField txtPNEFun;
	private JPasswordField passwordFun;
	private JPasswordField passwordConfirmFun;
	
	boolean pcdF = false;
	private JTextField txtId_Inst_Fk;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario();
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
	public TelaCadastroFuncionario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Funcionário");
		lblNewLabel.setBounds(144, 17, 213, 14);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome completo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 63, 104, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Nascimento");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(12, 114, 121, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(12, 170, 42, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Função");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(12, 225, 55, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Senha");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(12, 279, 55, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Confirmar senha");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(12, 327, 104, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Portador de necessidade especial?");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(12, 427, 205, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Descrição PNE");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(12, 477, 104, 16);
		contentPane.add(lblNewLabel_8);
		
		JButton buttonCadastrar = new JButton("Enviar");
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionariosCRUD fun = new funcionariosCRUD();
				fun.criarFun(txtNomeCompletoFun.getText(),
						txtDataNascFun.getText(),
						txtCPfFun.getText(), txtFuncaoFun.getText(),
						new String(passwordFun.getPassword()), pcdF,
						txtPNEFun.getText(),
						txtId_Inst_Fk.getCaretPosition());
						
						TelaFeed feed = new TelaFeed();
						feed.setVisible(true);
						dispose();
			}
		});
		buttonCadastrar.setBounds(197, 557, 105, 28);
		contentPane.add(buttonCadastrar);
		
		txtNomeCompletoFun = new JTextField();
		txtNomeCompletoFun.setBounds(166, 61, 233, 21);
		contentPane.add(txtNomeCompletoFun);
		txtNomeCompletoFun.setColumns(10);
		
		txtDataNascFun = new JTextField();
		txtDataNascFun.setColumns(10);
		txtDataNascFun.setBounds(166, 112, 233, 21);
		contentPane.add(txtDataNascFun);
		
		txtCPfFun = new JTextField();
		txtCPfFun.setColumns(10);
		txtCPfFun.setBounds(166, 168, 233, 21);
		contentPane.add(txtCPfFun);
		
		txtFuncaoFun = new JTextField();
		txtFuncaoFun.setColumns(10);
		txtFuncaoFun.setBounds(166, 220, 233, 21);
		contentPane.add(txtFuncaoFun);
		
		txtPNEFun = new JTextField();
		txtPNEFun.setEnabled(false);
		txtPNEFun.setColumns(10);
		txtPNEFun.setBounds(166, 472, 233, 21);
		contentPane.add(txtPNEFun);
		
		passwordFun = new JPasswordField();
		passwordFun.setBounds(166, 274, 233, 22);
		contentPane.add(passwordFun);
		
		passwordConfirmFun = new JPasswordField();
		passwordConfirmFun.setBounds(166, 322, 233, 22);
		contentPane.add(passwordConfirmFun);
		
		final JRadioButton radioButtonSimPNE = new JRadioButton("Sim");
		radioButtonSimPNE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButtonSimPNE.isSelected()){
					txtPNEFun.setEnabled(true);
					 pcdF = true;
				}else {
					txtPNEFun.setEnabled(false);
					pcdF = false;
				}
			}
		});
		radioButtonSimPNE.setBounds(242, 426, 60, 18);
		contentPane.add(radioButtonSimPNE);
		
		JLabel Codigo = new JLabel("Código de Instituição");
		Codigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Codigo.setBounds(12, 379, 121, 16);
		contentPane.add(Codigo);
		
		txtId_Inst_Fk = new JTextField();
		txtId_Inst_Fk.setColumns(10);
		txtId_Inst_Fk.setBounds(166, 374, 233, 21);
		contentPane.add(txtId_Inst_Fk);
	}
}
