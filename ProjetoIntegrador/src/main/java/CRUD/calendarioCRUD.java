package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class calendarioCRUD {
	static Texte_1 dali = new Texte_1();
	static Connection conexao = dali.conectaDB();
	
	public static void main(String[] args) {
		criarCal("dia 20 de novembro", "2022-11-20", "2022-11-25");
		//listarCal();
		//atualizarCal("sim", "2000-09-27", 1);
		
	}
	
	public static void criarCal(String feriados, String inicio, String fim) {
		try {
			PreparedStatement io = conexao.prepareStatement("INSERT INTO calendario_escolar (feriados_cadEsc, inicio_cadEsc, fim_cadEsc) VALUES (?, ?, ?);");
			io.setString(1,feriados);
			io.setString(2, inicio);
			io.setString(3, fim);
			
			io.executeUpdate();
			int retorno = io.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listarCal() {
		ResultSet calendario_escolar;
		try {
			calendario_escolar = conexao.createStatement().
					executeQuery("SELECT * FROM calendario_escolar");
			while(calendario_escolar.next()) {
				System.out.println(calendario_escolar.getInt("id_cadEsc_pk") +" "+ calendario_escolar.getString("feriados_cadEsc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void atualizarCal( String feriados, String inicio, int id) {
		try {
			PreparedStatement io = conexao.prepareStatement("UPDATE from calendario_escolar (feriados_cadEsc, inicio_cadEsc) VALUES (?, ?) WHERE id_cadEsc_pk = ?;");
			io.setString(1,feriados);
			io.setString(2, inicio);
			io.setInt(3, id);
			
			io.executeUpdate();
			int retorno = io.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void excluirCal(int id) {
		try {
			PreparedStatement io = conexao.prepareStatement("DELETE from calendario_escolar (feriados_cadEsc, inicio_cadEsc) VALUES (?, ?) WHERE id_cadEsc_pk = ?;");
			io.setInt(1, id);
			
			io.executeUpdate();
			int retorno = io.executeUpdate();
            
            if(retorno > 0){
                System.out.printf("Registro inserido com sucesso.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
