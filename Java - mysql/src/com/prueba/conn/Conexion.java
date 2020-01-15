package com.prueba.conn;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.prueba.conn.MyDataAcces;

public class Conexion {
	
	public static void main(String[] args) {
		
		MyDataAcces conexion = new MyDataAcces();
		ResultSet resultado;
		String name, apat, amat, email, cel;
		String name_complet;
		
		resultado = conexion.getQuery("SELECT * FROM test.app_personas;");
		
		try {
			while(resultado.next()) {
				name = resultado.getString("name_person");
				apat = resultado.getString("apat_person");
				amat = resultado.getString("amat_person");
				cel = resultado.getString("phone");
				email = resultado.getString("email");
				
				System.out.println("Nombre: " + name + "\n Email: " + email + "\n Telefono: " + cel);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

