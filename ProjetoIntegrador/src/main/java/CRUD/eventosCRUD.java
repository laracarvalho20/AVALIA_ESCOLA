package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class eventosCRUD {

	
	static Texte_1 dole = new Texte_1();
	static Connection conexao = dole.conectaDB();
	
	public static void main(String[] args) {
		criarEve("2010-10-10", "2009-09-04", "Matemática", "sim");
		
		excluirEve(1);
	}
	
	
	public static void criarEve(String inicio, String fim, String didatico, String lazer) {
		try {
			PreparedStatement pala = conexao.prepareStatement("INSERT INTO eventos (inicio_eve, fim_eve, didatico_eve, lazer_eve) VALUES (?, ?, ?, ?);");
			pala.setString(1,inicio);
			pala.setString(2, fim);
			pala.setString(3, didatico);
			pala.setString(4, lazer);
			pala.executeUpdate();
			int retorno = pala.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void listarEve() {
		ResultSet eventos;
		try {
			eventos = conexao.createStatement().
					executeQuery("SELECT * FROM eventos");
			while(eventos.next()) {
				System.out.println(eventos.getInt("id_eve_pk") +" "+ eventos.getString("inicio_eve"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void atualizarEve() {
		//tá dando erro, depois eu faço
	}
	public static void excluirEve(int id) {
		
		try {
			PreparedStatement pala = conexao.prepareStatement("DELETE from eventos WHERE id_eve_pk = ?;");
			pala.setInt(1, id);
			pala.executeUpdate();
			int retorno = pala.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
