package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class ReadUser {

	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "SELECT * FROM u8CQUeczC7.user WHERE email = ?";
    ResultSet rs;
    User us = new User();
    
    public User userId(User user) {
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user.getE_mail());
			rs = st.executeQuery();
			rs.next();
			
			int id = rs.getInt("id_user");
			user.setId(id);
			String username = rs.getString("username");
			user.setUsername(username);
			String email = rs.getString("email");
			user.setE_mail(email);
			String password = rs.getString("password");
			user.setPassword(password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return user;	
    }
}
