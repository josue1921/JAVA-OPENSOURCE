package com.prueba.bbva.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.prueba.bbva.Persons;

public class PersonsDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public PersonsDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			 try {
	                Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}
	
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
	    }
	}
	
	public boolean insertPerson(Persons person) throws SQLException {
        String sql = "INSERT INTO test.app_personas(name_person, apat_person, amat_person, phone, email, genero, RFC) VALUES (?, ?, ?, ?, ?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, person.getNombre());
        statement.setString(2, person.getApellidoP());
        statement.setString(3, person.getApellidoM());
        statement.setString(4, person.getTelefono());
        statement.setString(5, person.getCorreo());
        statement.setString(6, person.getGenero());
        statement.setString(7, person.getRfc());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Persons> listAllPersons() throws SQLException {
        List<Persons> listPersons = new ArrayList<>();
         
        String sql = "SELECT * FROM test.app_personas ORDER BY id_person DESC";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id_person");
            String nombre = resultSet.getString("name_person");
            String apellidoP = resultSet.getString("apat_person");
            String apellidoM = resultSet.getString("amat_person");
            String numTelefonico = resultSet.getString("phone");
            String correo = resultSet.getString("email");
            String gender = resultSet.getString("genero");
            String rfc = resultSet.getString("RFC");
             
            Persons persona = new Persons(id, nombre, apellidoP, apellidoM, numTelefonico, correo, gender, rfc);
            listPersons.add(persona);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listPersons;
    }
    
    public List<Persons> listBySearch() throws SQLException {
        List<Persons> listPersons = new ArrayList<>();
        String sql = "SELECT * FROM test.app_personas ";
         
        connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id_person");
            String nombre = resultSet.getString("name_person");
            String apellidoP = resultSet.getString("apat_person");
            String apellidoM = resultSet.getString("amat_person");
            String numTelefonico = resultSet.getString("phone");
            String correo = resultSet.getString("email");
            String gender = resultSet.getString("genero");
            String rfc = resultSet.getString("RFC");
             
            Persons persona = new Persons(id, nombre, apellidoP, apellidoM, numTelefonico, correo, gender, rfc);
            listPersons.add(persona);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listPersons;
    }
     
    public boolean deletePerson(Persons persona) throws SQLException {
        String sql = "DELETE FROM test.app_personas where id_person = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, persona.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updatePerson(Persons persona) throws SQLException {
        String sql = "UPDATE test.app_personas SET name_person = ?, apat_person = ?, amat_person = ?, phone = ?, email = ?, genero = ?, RFC = ? ";
        sql += " WHERE id_person = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, persona.getNombre());
        statement.setString(2, persona.getApellidoP());
        statement.setString(3, persona.getApellidoM());
        statement.setString(4, persona.getTelefono());
        statement.setString(5, persona.getCorreo());
        statement.setString(6, persona.getGenero());
        statement.setString(7, persona.getRfc());
        statement.setInt(8, persona.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Persons getPerson(int id) throws SQLException {
        Persons persona = null;
        String sql = "SELECT * FROM test.app_personas WHERE id_person = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String nombre = resultSet.getString("name_person");
            String apatPaterno = resultSet.getString("apat_person");
            String apatMaterno = resultSet.getString("apat_person");
            String phones = resultSet.getString("phone");
            String correo = resultSet.getString("email");
            String genero = resultSet.getString("genero");
            String rfc = resultSet.getString("RFC");
             
            persona = new Persons(id, nombre, apatPaterno, apatMaterno, phones, correo, genero, rfc);
        }
         
        resultSet.close();
        statement.close();
         
        return persona;
    }
}
