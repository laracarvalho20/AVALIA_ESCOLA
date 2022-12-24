package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sala_aulaCRUD {

	static Texte_1 pi = new Texte_1();
	static Connection conexao = pi.conectaDB();
	
	public static void main(String[] args) {
		
	}
	
	public static void criarSala(String numero, String quantSala, String acessoAula) {
		try {
			PreparedStatement oi = conexao.prepareStatement("INSERT INTO sala_aula (num_sala, quant_sala, acess_sala) VALUES (?, ?, ?);");
			oi.setString(1,numero);
			oi.setString(2, quantSala);
			oi.setString(3, acessoAula);
			int retorno = oi.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listarSala() {
		ResultSet sala_aula;
		try {
			sala_aula = conexao.createStatement().
					executeQuery("SELECT * FROM sala_aula");
			while(sala_aula.next()) {
				System.out.println(sala_aula.getInt("id_sala_pk") +" "+ sala_aula.getString("num_sala"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void AtualizarSala() {
		
	}
	
	public static void excluirSala(int id) {
		try {
			PreparedStatement oi = conexao.prepareStatement("DELETE from sala_aula WHERE id_sala_pk = ?;");
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
