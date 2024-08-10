import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import controllers.CreateLogin;
import models.User;

public class LoginPost extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User us = new User();
		us.setUsername(username);
		us.setPassword(password);
		
		CreateLogin login = new CreateLogin();
		ArrayList<User> l = login.createLogin(us);
		
		for(User u: l) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				JSONArray array = new JSONArray(l);
				PrintWriter out = res.getWriter();
				out.write(array.toString());
				System.out.println("JSONarray data " +array.toString());
			}
		}
	}
}
