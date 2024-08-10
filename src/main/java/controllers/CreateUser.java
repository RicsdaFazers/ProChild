package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.User;

public class CreateUser {
	
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "INSERT INTO u8CQUeczC7.user (email, username, password, id_type) VALUE(?, ?, ?, 1)";
    
    User user = new User();
    int i;
    
    public int postRegister(User us) {
    	
    	String e = us.getE_mail();
    	String u = us.getUsername();
    	String p = us.getPassword();
    	
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, e);
			st.setString(2, u);
			st.setString(3, p);
			i = st.executeUpdate();
			
    	} catch (ClassNotFoundException | SQLException exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
    	
    	return i;
    }
}
