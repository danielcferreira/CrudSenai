package br.edu.senai.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	public void open() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root","");		
	}
	
	public void close() throws Exception{
		con.close();
	}
}