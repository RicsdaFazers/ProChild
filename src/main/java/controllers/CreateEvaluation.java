package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
import java.util.Date;

import models.Shared_activity;

public class CreateEvaluation {
	
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "INSERT INTO u8CQUeczC7.child_activity (id_child, id_activity, activity_evaluation, activity_comment) VALUE(?, ?, ?, ?)";
    
    Shared_activity shared = new Shared_activity(); 
    int i;
    
    public int postEvaluation (Shared_activity sh) {
        int id_child = sh.getId_child();
        int id_activity = sh.getId_activity();
        int activity_evaluation = sh.getEvaluation();
        String activity_comment = sh.getActivity_comment();
        /*DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date submission_date = new Date();
        df.format(submission_date);*/
        
        try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id_child);
			st.setInt(2, id_activity);
			st.setInt(3, activity_evaluation);
			st.setString(4, activity_comment);
			//st.setDate(5, (java.sql.Date) submission_date);
			i = st.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return i;
    }
}
