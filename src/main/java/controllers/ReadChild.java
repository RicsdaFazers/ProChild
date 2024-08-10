package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Child;

public class ReadChild {
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "SELECT child_name, address, child_age, future_profession, parent1_name, parent2_name, contact FROM u8CQUeczC7.child WHERE id_child = ?";
    ResultSet rs;
    
    public Child childGet(Child ch) {
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, ch.getId_child());
			rs = st.executeQuery();
			rs.next();
			
			String name = rs.getString("child_name");
			ch.setName_child(name);
			String address = rs.getString("address");
			ch.setAddress(address);
			int age = rs.getInt("child_age");
			ch.setAge(age);
			String profession = rs.getString("future_profession");
			ch.setFuture_profession(profession);
			String parent1 = rs.getString("parent1_name");
			ch.setName_parent1(parent1);
			String parent2 = rs.getString("parent2_name");
			ch.setName_parent2(parent2);
			int contact = rs.getInt("contact");
			ch.setContact(contact);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return ch;
    }
}
