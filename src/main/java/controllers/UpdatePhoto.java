package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Shared_activity;

public class UpdatePhoto {
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "UPDATE u8CQUeczC7.child_activity SET activity_photo = ? WHERE id_child = ? AND id_activity = ?";
    Shared_activity shared = new Shared_activity();
    int i;
    
    public int putPhoto(Shared_activity sh) {
    	String photo = sh.getPhoto();
    	int id_child = sh.getId_child();
    	int id = sh.getId_activity();
    	
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, photo);
			st.setInt(2, id_child);
			st.setInt(3, id);
			i = st.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return i;
    }
}
