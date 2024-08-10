package controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import models.Graphic;

public class ReadActivityGraphic {
	
	String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://remotemysql.com:3306";
    String USER = "u8CQUeczC7";
    String PASSWORD = "suHzHmWpMS";
    String sql = "SELECT COUNT(*) AS Janeiro, (SELECT COUNT(*) FROM u8CQUeczC7.activity WHERE DATE_FORMAT(schedule, \"%Y-%m\")=DATE_FORMAT(CURDATE(),\"%Y-02\")) AS Fevereiro, (SELECT COUNT(*) FROM u8CQUeczC7.activity WHERE DATE_FORMAT(schedule, \"%Y-%m\")=DATE_FORMAT(CURDATE(),\"%Y-03\")) AS Março, (SELECT COUNT(*) FROM u8CQUeczC7.activity WHERE DATE_FORMAT(schedule, \"%Y-%m\")=DATE_FORMAT(CURDATE(),\"%Y-04\")) AS Abril, (SELECT COUNT(*) FROM u8CQUeczC7.activity WHERE DATE_FORMAT(schedule, \"%Y-%m\")=DATE_FORMAT(CURDATE(),\"%Y-05\")) AS Maio, (SELECT COUNT(*) FROM u8CQUeczC7.activity WHERE DATE_FORMAT(schedule, \"%Y-%m\")=DATE_FORMAT(CURDATE(),\"%Y-06\")) AS Junho, (SELECT COUNT(*) FROM u8CQUeczC7.activity WHERE DATE_FORMAT(schedule, \"%Y-%m\")=DATE_FORMAT(CURDATE(),\"%Y-07\")) AS Julho, (SELECT COUNT(*) FROM u8CQUeczC7.activity WHERE DATE_FORMAT(schedule, \"%Y-%m\")=DATE_FORMAT(CURDATE(),\"%Y-08\")) AS Agosto, (SELECT COUNT(*) FROM u8CQUeczC7.activity WHERE DATE_FORMAT(schedule, \"%Y-%m\")=DATE_FORMAT(CURDATE(),\"%Y-09\")) AS Setembro, (SELECT COUNT(*) FROM u8CQUeczC7.activity WHERE DATE_FORMAT(schedule, \"%Y-%m\")=DATE_FORMAT(CURDATE(),\"%Y-010\")) AS Outubro, (SELECT COUNT(*) FROM u8CQUeczC7.activity WHERE DATE_FORMAT(schedule, \"%Y-%m\")=DATE_FORMAT(CURDATE(),\"%Y-11\")) AS Novembro, (SELECT COUNT(*) FROM u8CQUeczC7.activity WHERE DATE_FORMAT(schedule, \"%Y-%m\")=DATE_FORMAT(CURDATE(),\"%Y-12\")) AS Dezembro FROM u8CQUeczC7.activity WHERE DATE_FORMAT(schedule, \"%Y-%m\")=DATE_FORMAT(CURDATE(),\"%Y-01\")";
    ResultSet rs;
    Graphic gr = new Graphic();
    
    public Graphic graphicGet(Graphic g) {
    	try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			
			int jan = rs.getInt("Janeiro");
			g.setJanuary(jan);
			int feb = rs.getInt("Fevereiro");
			g.setFebruary(feb);
			int mar = rs.getInt("Março");
			g.setMarch(mar);
			int apr = rs.getInt("Abril");
			g.setApril(apr);
			int may = rs.getInt("Maio");
			g.setMay(may);
			int jun = rs.getInt("Junho");
			g.setJune(jun);
			int jul = rs.getInt("Julho");
			g.setJuly(jul);
			int aug = rs.getInt("Agosto");
			g.setAugust(aug);
			int sep = rs.getInt("Setembro");
			g.setSeptember(sep);
			int oct = rs.getInt("Outubro");
			g.setOctober(oct);
			int nov = rs.getInt("Novembro");
			g.setNovember(nov);
			int dec = rs.getInt("Dezembro");
			g.setDecember(dec);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return g;
    }
    

}
