package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class ReadUsername {
	
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "SELECT * FROM u8CQUeczC7.user WHERE id_user = ?";
    ResultSet rs;
    User user = new User();
    
	public User get(User us) {
		// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, us.getId());
			rs = st.executeQuery();
			//Este metodo quando ha linhas da true, quando n ha da false
			rs.next();
			//Valor da BD
			String username = rs.getString("username");
			user.setUsername(username);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
