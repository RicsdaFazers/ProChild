package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Child;

public class UpdateProfile3 {
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "UPDATE u8CQUeczC7.child SET parent1_name = ?, parent2_name = ? WHERE id_child = ?";
    int i;
    
    public int putProfile3(Child ch) {
    	String parent1 = ch.getName_parent1();
    	String parent2 = ch.getName_parent2();
    	int id = ch.getId_child();
    	
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, parent1);
			System.out.println(parent1);
			
			st.setString(2, parent2);
			st.setInt(3, id);
			i = st.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return i;
    }
}
