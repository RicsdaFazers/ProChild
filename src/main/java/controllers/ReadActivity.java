package controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import models.Activity;

public class ReadActivity {
	
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "SELECT A.activity_name, A.activity_local, A.schedule, A.start_date, A.end_date, I.institution_name FROM u8CQUeczC7.activity A, u8CQUeczC7.institution I WHERE A.id_institution = I.id_institution AND A.id_activity = ?";
    ResultSet rs;
    Activity act = new Activity();
    
    public Activity activityGet(Activity act) {
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, act.getId_activity());
			rs = st.executeQuery();
			rs.next();
			
			String activity_name = rs.getString("activity_name");
			act.setName(activity_name);
			String activity_local = rs.getString("activity_local");
			act.setAddress(activity_local);
			Date schedule = rs.getDate("schedule");
			act.setSchedule(schedule);
			Time start_date = rs.getTime("start_date");
			act.setBeginning_date(start_date);
			Time end_date = rs.getTime("end_date");
			act.setEnd_date(end_date);
			String institution_name = rs.getString("institution_name");
			act.setName_institution(institution_name);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return act;
    }
}
