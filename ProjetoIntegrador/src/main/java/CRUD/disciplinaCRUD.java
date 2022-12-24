package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class disciplinaCRUD {

	static Texte_1 tu = new Texte_1();
	static Connection conexao = tu.conectaDB();

	
	public static void main(String[] args) {
		
	}
	
	public static void criarDisc (String nomeDisc, String nomeProf, String numSala, String numAlunos, String monitor) {
		try {
			PreparedStatement oi = conexao.prepareStatement("INSERT INTO disciplina (nome_disc, nome_prof, num_sala_disc, alunos_disc, monit_disc) VALUES (?, ?, ?, ?, ?);");
			oi.setString(1,nomeDisc);
			oi.setString(2, nomeProf);
			oi.setString(3, numSala);
			oi.setString(4, numAlunos);
			oi.setString(5, monitor);
			int retorno = oi.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listarDisc() {
		ResultSet disciplina;
		try {
			disciplina = conexao.createStatement().
					executeQuery("SELECT * FROM disciplina");
			while(disciplina.next()) {
				System.out.println(disciplina.getInt("id_disc_pk") +" "+ disciplina.getString("nome_disc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void AtualizarDisc() {
		
	}
	
	public static void excluirDisc(int id) {
		try {
			PreparedStatement oi = conexao.prepareStatement("DELETE from disciplina WHERE id_disc_pk = ?;");
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
