package CRUD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtTipoInstituicao;
	private JTextField txtNome;
	private JTextField txtFundacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */instituicaoCRUD inst = new instituicaoCRUD();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public TelaCadastro() {
		setTitle("Cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo da Instituição");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 101, 136, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 156, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fundação");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 210, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		txtTipoInstituicao = new JTextField();
		txtTipoInstituicao.setBounds(146, 101, 227, 20);
		contentPane.add(txtTipoInstituicao);
		txtTipoInstituicao.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(146, 154, 227, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtFundacao = new JTextField();
		txtFundacao.setBounds(146, 208, 227, 20);
		contentPane.add(txtFundacao);
		txtFundacao.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(103, 255, 213, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton buttonEnviar = new JButton("Enviar");
		buttonEnviar.setBounds(54, 51, 103, 23);
		panel.add(buttonEnviar);
		buttonEnviar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		final JRadioButton radioButtonFuncionario = new JRadioButton("Funcionário");
		radioButtonFuncionario.setBounds(0, 0, 115, 18);
		panel.add(radioButtonFuncionario);
		buttonGroup.add(radioButtonFuncionario);
		
		final JRadioButton radioButtonAluno = new JRadioButton("Aluno");
		radioButtonAluno.setBounds(145, 0, 68, 18);
		panel.add(radioButtonAluno);
		buttonGroup.add(radioButtonAluno);
		buttonEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inst.criarInst(txtTipoInstituicao.getText(), txtNome.getText(), txtFundacao.getText());
				
				if(radioButtonFuncionario.isSelected()){
				TelaCadastroFuncionario telaFun = new TelaCadastroFuncionario();
				telaFun.setVisible(true);
				}
				if(radioButtonAluno.isSelected()){
					TelaCadastroAluno alu = new TelaCadastroAluno();
					alu.setVisible(true);
				}
				dispose();
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Cadastro de Insitituição");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(103, 30, 213, 20);
		contentPane.add(lblNewLabel_3);
	}
}
