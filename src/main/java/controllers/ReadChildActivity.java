package controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import models.Activity;

public class ReadChildActivity {
	
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "SELECT A.activity_name, A.activity_local, A.schedule, A.file FROM u8CQUeczC7.child_activity CA, u8CQUeczC7.activity A WHERE CA.id_activity = A.id_activity AND CA.id_child = ?";
    ResultSet rs;
    //Activity act = new Activity();
    List<Activity> list = new ArrayList<Activity>();
    
    public List<Activity> childActivity (Activity act) {
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, act.getId_child());
			rs = st.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("activity_name");
				String local = rs.getString("activity_local");
				Date date = rs.getDate("schedule");
				String file = rs.getString("file");
				
				list.add(new Activity(name, local, date, file));
			}
			
			/*String name = rs.getString("activity_name");
			act.setName(name);
			String local = rs.getString("activity_local");
			act.setAddress(local);
			Time start = rs.getTime("start_date");
			act.setBeginning_date(start);*/
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return list;
    }
}
