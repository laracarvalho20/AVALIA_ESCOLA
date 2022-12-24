package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class feedback {

	
	static Texte_1 dut = new Texte_1();
	static Connection conexao = dut.conectaDB();
	
	public static void main(String[] args) {
		
	}
	public static void criarFeed(String usuario_feed, String acesso) {
		try {
			PreparedStatement pi = conexao.prepareStatement("INSERT INTO feedback (usuario_feed, op_acess_feed) VALUES (?,?);");
			pi.setString(1,usuario_feed);
//			pi.setString(2, opiPosi);
//			pi.setString(3, opiNeg);
//			pi.setString(4, opiMate);
//			pi.setString(5, estrutura);
//			pi.setString(6, lanche);
			pi.setString(2, acesso);
//			pi.setString(8, denuncia);
			int retorno = pi.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listarFeed() {
		ResultSet feedback;
		try {
			feedback = conexao.createStatement().
					executeQuery("SELECT * FROM feedback");
			while(feedback.next()) {
				System.out.println(feedback.getInt("id_feed_pk") +" "+ feedback.getString("usuario_feed"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void atualizarFeed() {
		
	}
	
	public static void excluirEnt(int id) {
		try {
			PreparedStatement oi = conexao.prepareStatement("DELETE from feedback WHERE id_feed_pk = ?;");
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
