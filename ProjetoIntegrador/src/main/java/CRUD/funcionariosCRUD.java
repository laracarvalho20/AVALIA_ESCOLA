package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class funcionariosCRUD {

	static Texte_1 dau = new Texte_1();
	static Connection conexao = dau.conectaDB();
	
/*	public static void main(String[] args) {
		//criarFun("Luiz", "2022-09-07", "professor apenas do turno matutino", "Professor", "root", "não", "não");
		atualizarFun("Raul", "2022-03-01", 2);
		//excluirFun(1);
	} */
	
	public void criarFun(String nome, String cpfFun, String dataNas,
			String funcao, String senha, boolean pcdF, String descr, int id_inst_fk) {
		try {
			PreparedStatement ola = conexao.prepareStatement("INSERT INTO funcionarios (nome_complet_fun, cpf_fun, data_nasc_fun, funcao_fun, senha_fun, pcd_fun, descricao_pcd_fun, id_inst_fk) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
			ola.setString(1, nome);
			ola.setString(2, dataNas);
			ola.setString(3, cpfFun);
		//	ola.setString(3, observ);
			ola.setString(4, funcao);
			ola.setString(5, senha);
			ola.setBoolean(6, pcdF);
			ola.setString(7, descr);
			ola.setInt(8, id_inst_fk);
			//ola.executeUpdate();
			int retorno = ola.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listarFun(String cpf_fun, String senha_fun, int id_inst_fk) {
		ResultSet funcionarios;
		try {
			String sql = "SELECT * FROM funcionarios WHERE cpf_fun = ? AND senha_fun = ? AND id_inst_fk = ?";
			PreparedStatement sle = conexao.prepareStatement(sql);
		
			sle.setString(1, cpf_fun);
			sle.setString(2, senha_fun);
			sle.setInt(3, id_inst_fk);
			ResultSet rs = sle.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Usuario Encontrado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void atualizarFun(String nome, String data, int id) {
		try {
			PreparedStatement ola = conexao.prepareStatement("UPDATE funcionarios (nome_complet_fun, data_nasc_fun) VALUES (?, ?) WHERE id_fun_pk = "+id+" ;");
			ola.setString(1, nome);
			ola.setString(2, data);
			//ola.setInt(3, id);
			//ola.setString(4, funcao);
//			ola.setString(5, senha);
//			ola.setString(6, pcd);
//			ola.setString(7, descr);
			ola.executeUpdate();
			int retorno = ola.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void excluirFun(int id) {
		try {
			PreparedStatement oi = conexao.prepareStatement("DELETE from funcionarios WHERE id_fun_pk = ?;");
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
	
}//fim do class
