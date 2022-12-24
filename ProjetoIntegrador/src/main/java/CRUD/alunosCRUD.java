package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class alunosCRUD {

	static Texte_1 rai = new Texte_1();
	static Connection conexao = rai.conectaDB();
	
	
/*	public static void main(String[] args) {
		
	}*/
	
	public static void criarAlunos(boolean pcd, String senha, String data, String nomeAluno, String cpfAlu, String nomeSocial, String genero, String descPcdAlu) {
		try {
			PreparedStatement oi = conexao.prepareStatement("INSERT INTO alunos (pcd_aluno, senha_aluno, data_nasc_aluno, nome_aluno, cpf_alu, nome_social_aluno, genero_aluno, desc_Pcd_Alu) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
			oi.setBoolean(1, pcd);
			oi.setString(2, senha);
			oi.setString(3, data);
			oi.setString(4, nomeAluno);
			oi.setString(5, cpfAlu);
			oi.setString(6, nomeSocial);
			oi.setString(7, genero);
			oi.setString(8, descPcdAlu);
		//	oi.setString(7, observacao);
			int retorno = oi.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listarAlunos(String cpf_alu, String senha_aluno) {
		ResultSet alunos = null;
		try {
			String sql = "SELECT * FROM alunos WHERE cpf_alu = ? AND senha_aluno = ?";
			PreparedStatement sle = conexao.prepareStatement(sql);
		
			sle.setString(1, cpf_alu);
			sle.setString(2, senha_aluno);
			ResultSet rs = sle.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Usuario Encontrado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void AtualizarAlunos() {
		
	}
	public static void excluirAlunos(int id) {
		try {
			PreparedStatement oi = conexao.prepareStatement("DELETE from alunos WHERE id_aluno_pk = ?;");
			oi.setInt(1, id);
			oi.executeUpdate();
			int retorno = oi.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
