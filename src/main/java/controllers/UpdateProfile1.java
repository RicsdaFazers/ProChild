package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Child;

public class UpdateProfile1 {
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "UPDATE u8CQUeczC7.child SET child_name = ?, address = ? WHERE id_child = ?";
    int i;
    
    public int putProfile1(Child ch) {
    	String name = ch.getName_child();
    	String address = ch.getAddress();
    	int id = ch.getId_child();
    	
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			System.out.println(name);
			
			st.setString(2, address);
			st.setInt(3, id);
			i = st.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return i;
    }
}
