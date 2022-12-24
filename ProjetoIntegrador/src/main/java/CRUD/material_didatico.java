package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class material_didatico {
	
	static Texte_1 dole = new Texte_1();
	static Connection conexao = dole.conectaDB();
	
	public static void main(String[] args) {
		
		criarMat("lulu", 20, "SIM", "senac", "2002-09-08");
	}
	
	public static void criarMat(String nome, int quant, String acess, String origem, String data) {
		
		try {
			PreparedStatement to = conexao.prepareStatement("INSERT INTO material_didatico (nome_mat, quantidade_mat, acessibilidade_mat, origem_mat, dataReceb_mat, templo_aplica_mat) VALUES (?, ?, ?, ?, ?, ?);");
			to.setString(1,nome);
			to.setInt(2, quant);
			to.setString(3, acess);
			to.setString(4, origem);
			to.setString(5, data);
			
			int retorno = to.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void listarMat() {
		ResultSet material_didatico;
		try {
			material_didatico = conexao.createStatement().
					executeQuery("SELECT * FROM material_didatico");
			while(material_didatico.next()) {
				System.out.println(material_didatico.getInt("id_mat_pk") +" "+ material_didatico.getString("nome_mat"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void  atualizarMat(String nome, int quant, String acess) {
		
	}
	public static void excluirMat(int id) {
		try {
			PreparedStatement oi = conexao.prepareStatement("DELETE from material_didatico WHERE id_mat_pk = ?;");
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
