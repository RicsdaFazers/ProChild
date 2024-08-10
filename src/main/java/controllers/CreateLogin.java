package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.User;

public class CreateLogin {

	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "SELECT U.id_user, C.id_child, U.username, U.password FROM u8CQUeczC7.user U, u8CQUeczC7.child C WHERE U.username = ? AND U.password = ? AND U.id_user = C.id_user";
    ArrayList<User> list = new ArrayList<>();
    ResultSet rs;
	
	public ArrayList<User> createLogin(User us) {
		String user = us.getUsername();
		String pass = us.getPassword();
		
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user);
			st.setString(2, pass);
			rs = st.executeQuery();
			
			if(rs.next()) {
				User u = new User();
				int id = rs.getInt("id_user");
				u.setId(id);
				String username = rs.getString("username");
				u.setUsername(username);
				String password = rs.getString("password");
				u.setPassword(password);
				int id_child = rs.getInt("id_child");
				u.setId_child(id_child);
				
				list.add(u);
				
				System.out.println("Userdata was get");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

}
