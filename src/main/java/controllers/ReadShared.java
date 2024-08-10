package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import models.Shared_activity;

public class ReadShared {
	
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "SELECT A.activity_name, CA.activity_comment, CA.activity_photo, C.child_name, CA.submission_date FROM u8CQUeczC7.child C, u8CQUeczC7.activity A, u8CQUeczC7.child_activity CA WHERE C.id_child = CA.id_child AND A.id_activity = CA.id_activity";
    ResultSet rs;
    List<Shared_activity> list = new ArrayList<Shared_activity>();
    
    public List<Shared_activity> sharedActivity() {
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			rs = st.executeQuery();
			//rs.next();
			
			while(rs.next()) {
				String name = rs.getString("activity_name");
				//sh.setName(name);
				
				System.out.println(name);
				
				String comment = rs.getString("activity_comment");
				//sh.setActivity_comment(comment);
				
				System.out.println(comment);
				
				String photo = rs.getString("activity_photo");		
				//sh.setPhoto(photo);
				
				System.out.println(photo);
				
				String child = rs.getString("child_name");
				//sh.setName_child(child);
				
				System.out.println(child);
				
				Date submission = rs.getDate("submission_date");
				//sh.setSubmission(submission);
				
				System.out.println(submission);
				
				list.add(new Shared_activity(name, comment, photo, child, submission));
			}
			
			/*String name = rs.getString("activity_name");
			sh.setName(name);
			
			System.out.println(name);
			
			String comment = rs.getString("activity_comment");
			sh.setActivity_comment(comment);
			
			System.out.println(comment);
			
			String photo = rs.getString("activity_photo");		
			sh.setPhoto(photo);
			
			System.out.println(photo);
			
			String child = rs.getString("child_name");
			sh.setName_child(child);
			
			System.out.println(child);
			
			Date submission = rs.getDate("submission_date");
			sh.setSubmission(submission);
			
			System.out.println(submission);*/
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return list;
    }
}
