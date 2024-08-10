package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Suggestion;

public class CreateSuggestion {
	
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "INSERT INTO u8CQUeczC7.suggestion (comment, id_child) VALUE(?, ?)";
    Suggestion sug = new Suggestion();
    int i;
    
    public int postRegister(Suggestion sug) {
    	String comment = sug.getComment();
    	int id_child = sug.getId_child();
    	
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, comment);
			st.setInt(2, id_child);
			i = st.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
    }

}
