package com.prueba.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDataAcces {
	
	 /* Usuario y pass de la Base de Datos. */
	 private String user = "root";
	 private String pass = "Newend_19";
	 
	 /* Nombre de la Base de Datos */
	 private static String baseDatos = "test";
	 
	 /* URL de la Base de Datos */
	 static String url = "jdbc:mysql://localhost/"+baseDatos;
	 
	 /* Conexion a la Base de Datos */
	 private Connection conn = null;

	public MyDataAcces() {
		  
		  try {
		   Class.forName("com.mysql.jdbc.Connection");
		   conn = (Connection)DriverManager.getConnection(url, user, pass);
		   
		   if (conn != null) {
		    System.out.println("Conexion a base de datos "+url+" . . . Ok");
		   }
		   
		  } catch(SQLException ex) {
		   System.out.println("Hubo un problema al intentar conecarse a la base de datos"+url);
		   
		  } catch(ClassNotFoundException ex) {
		   System.out.println("Error... "+ex);
		  }  
	}
	
	 /**
	  * Consultas a la Base de Datos.
	  * @param _query
	  * @return
	  */
	public ResultSet getQuery(String _query) {
		
		Statement state = null;
		ResultSet resultado = null;
	  
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(_query);
		} catch(SQLException e) {
			e.printStackTrace();  
		}
	  
	  return resultado;
	}
	
	/**
	  * Modificacion a la Base de Datos.
	  * @param _query
	  */
	public void setQuery(String _query) {
		Statement state = null;
		
		try {
			state=(Statement) conn.createStatement();
			state.execute(_query);
        } catch (SQLException e) {
            e.printStackTrace();
       }
	}
}
