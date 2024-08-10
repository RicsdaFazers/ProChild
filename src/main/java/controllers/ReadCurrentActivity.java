package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Activity;

public class ReadCurrentActivity {

	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "SELECT id_activity, activity_name, file, DAY(schedule) as day  FROM u8CQUeczC7.activity WHERE date_format(schedule, \"%Y-%m\")=date_format(CURDATE(),\"%Y-%m\") ORDER BY day";
    ResultSet rs;
    List<Activity> list = new ArrayList<Activity>();
    
    public List<Activity> currentActivity() {
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			rs = st.executeQuery();
		
			while(rs.next()) {
				int id = rs.getInt("id_activity");
				String name = rs.getString("activity_name");
				String file = rs.getString("file");
				int day = rs.getInt("day");
				
				list.add(new Activity(id, name, file, day));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return list;
    }
}
