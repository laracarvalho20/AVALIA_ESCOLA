package CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class instituicaoCRUD {
	
	static Texte_1 dao = new Texte_1();
	static Connection conexao = dao.conectaDB();
	
/*	public static void main(String[] args) {
		
		//String tipo, nome= "", fundacao=" ";		
		//tipo = JOptionPane.showInputDialog(null, "Informe o tipo da instituição: ");		
		//criarInst("Restaurante Senac", "Senac", "2022-01-01");
		//atualizarInst(6, "Universidade", "UFBA - Campus Ondina");
		//excluirInst(0);
		//listarInst();
	}*/
	
	public void criarInst(String tipo, String nome, String fundacao) {
		try {
			PreparedStatement prep = conexao.prepareStatement("INSERT INTO instituicao (tipo_inst, nome_inst, fundacao_inst) VALUES (?, ?, ?);");
			prep.setString(1, tipo);
			prep.setString(2, nome);
			prep.setString(3, fundacao);
			//prep.executeUpdate();
			int retorno = prep.executeUpdate();
            
            if(retorno > 0){
                System.out.println("Registro inserido com sucesso; " + retorno + " linha(s) afetada(s).");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void listarInst() {
		ResultSet instituicao;
		try {
			instituicao = conexao.createStatement().
					executeQuery("SELECT * FROM instituicao WHERE fundacao_inst >= '2000-01-01';");
			while(instituicao.next()) {
				System.out.println(instituicao.getInt("id_instituicao_pk") +" "+ instituicao.getString("tipo_inst"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void atualizarInst(int id, String tipo, String nome) {
		try {
			PreparedStatement prep = conexao.prepareStatement("UPDATE instituicao SET tipo_inst = ?, nome_inst = ? WHERE id_instituicao_pk = ?;");
			prep.setInt(3, id);
			prep.setString(1, tipo);
			prep.setString(2, nome);			
//			prep.setString(1, nome);
//			prep.setString(1, fundacao);
			int retorno = prep.executeUpdate();
            
            if(retorno > 0){
            	System.out.println("Registro atualizado com sucesso; " + retorno + " linha(s) afetada(s).");
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void excluirInst(int id) {
		try {
			PreparedStatement prep = conexao.prepareStatement("DELETE from instituicao WHERE id_instituicao_pk = ?;");
			prep.setInt(1, id);
			int retorno = prep.executeUpdate();
            
            if(retorno > 0){
                System.out.println("Registro excluído com sucesso. " + retorno + " linha(s) afetada(s).");
            } else {
            	System.out.println("Nenhum registro foi alterado.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
