import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.CreateSuggestion;
import models.Suggestion;


public class SuggestionPost extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.flush();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String comment = req.getParameter("comment");
		String id_child = req.getParameter("id_child");
		int id = Integer.valueOf(id_child);
		
		Suggestion us = new Suggestion();
		us.setComment(comment);
		us.setId_child(id);
		
		CreateSuggestion register = new CreateSuggestion();
		int i = register.postRegister(us);
		if (i > 0) {
			doGet(req, res);
			System.out.println("Success");
		}
	}
}
