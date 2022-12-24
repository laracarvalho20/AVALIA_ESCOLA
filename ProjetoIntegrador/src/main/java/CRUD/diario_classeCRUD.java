package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class diario_classeCRUD {

	static Texte_1 re = new Texte_1();
	static Connection conexao = re.conectaDB();

	
	public static void main(String[] args) {
		
	}
	
	public static void criarDiario (String presenca, String dataDiario, String obsDiario) {
		try {
			PreparedStatement oi = conexao.prepareStatement("INSERT INTO diario_classe (presenca_diario, data_diario, obs_diario) VALUES (?, ?, ?);");
			oi.setString(1,presenca);
			oi.setString(2, dataDiario);
			oi.setString(3, obsDiario);
			int retorno = oi.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listarDiario() {
		ResultSet diario_classe;
		try {
			diario_classe = conexao.createStatement().
					executeQuery("SELECT * FROM diario_classe");
			while(diario_classe.next()) {
				System.out.println(diario_classe.getInt("id_diario_pk") +" "+ diario_classe.getString("presenca_diario"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void AtualizarDiario() {
		
	}
	
	public static void excluirDiario(int id) {
		try {
			PreparedStatement oi = conexao.prepareStatement("DELETE from diario_classe WHERE id_diario_pk = ?;");
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
