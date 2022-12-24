package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class enderecoCRUD {

	static Texte_1 dai = new Texte_1();
	static Connection conexao = dai.conectaDB();
	
	public static void main(String[] args) {
		criarEnd("Brasil", "Bahia", "ba", "Salvador", "546729", "Rua Carlos", 2);
		//listarEnt();
		//excluirEnt(4);
		//atualizarEnt(2, "EUA", "nova york");
	}
	
	public static void criarEnd(String pais, String estado, String uf, String cidade, String cep, String rua, int numero) {
		try {
			PreparedStatement oi = conexao.prepareStatement("INSERT INTO endereco (pais_ende, estado_ende, uf_ende, cidade_ende, cep_ende, rua_ende, num_ende) VALUES (?, ?, ?, ?, ?, ?, ?);");
			oi.setString(1,pais);
			oi.setString(2, estado);
			oi.setString(3, uf);
			oi.setString(4, cidade);
			oi.setString(5, cep);
			oi.setString(6, rua);
			oi.setInt(7, numero);
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
	
	public static void listarEnt() {
		ResultSet endereco;
		try {
			endereco = conexao.createStatement().
					executeQuery("SELECT * FROM endereco");
			while(endereco.next()) {
				System.out.println(endereco.getInt("id_ende_pk") +" "+ endereco.getString("pais_ende"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void atualizarEnt(int id ,String pais, String estado) {
		try{
			PreparedStatement oi = conexao.prepareStatement("UPDATE endereco SET ( id_ende_pk, pais_ende, estado_ende) VALUES (?, ?, ?);");
		
		oi.setInt(1,id);
		oi.setString(2,pais);
		oi.setString(3, estado);
//		oi.setString(3, uf);
//		oi.setString(4, cidade);
//		oi.setString(5, cep);
//		oi.setString(6, rua);
//		oi.setInt(7, numero);
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
	public static void excluirEnt(int id) {
		try {
			PreparedStatement oi = conexao.prepareStatement("DELETE from endereco WHERE id_ende_pk = ?;");
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
	
	//só não coloquei chave estrangeira.
	
}//fim do class
