package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Child;

public class UpdateProfile4 {
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "UPDATE u8CQUeczC7.child SET contact = ? WHERE id_child = ?";
    int i;
    
    public int putProfile4(Child ch) {
    	int contact = ch.getContact();
    	int id = ch.getId_child();
    	
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, contact);
			System.out.println(contact);
		
			st.setInt(2, id);
			i = st.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return i;
    }
	
}
