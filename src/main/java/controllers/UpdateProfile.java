package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Child;

public class UpdateProfile {
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "UPDATE u8CQUeczC7.child SET child_name = ?, parent1_name = ?, parent2_name = ?, address = ?, child_age = ?, future_profession = ? WHERE id_child = ?";
    Child ch = new Child();
    int i;
    
    public int putProfile(Child chi) {
    	String child_name = chi.getName_child();
    	String parent1_name = chi.getName_parent1();
    	String parent2_name = chi.getName_parent2();
    	String address = chi.getAddress();
    	int age = chi.getAge();
    	String profession = chi.getFuture_profession();
    	int id = chi.getId_child();
    	
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, child_name);
			System.out.println(child_name);
			
			st.setString(2, parent1_name);
			st.setString(3, parent2_name);
			st.setString(4, address);
			st.setInt(5, age);
			st.setString(6, profession);
			st.setInt(7, id);
			i = st.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return i;
    }

}
