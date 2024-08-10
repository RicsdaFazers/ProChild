import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.UpdateProfile4;
import models.Child;

public class Profile4Put extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.flush();
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String contact = req.getParameter("contact");
		int contactInt = Integer.valueOf(contact);
		System.out.println(contactInt);
		String id = req.getParameter("id_child");
		System.out.println(id);
		int id_child = Integer.valueOf(id);
		
		Child ch = new Child();
		ch.setContact(contactInt);
		ch.setId_child(id_child);
		
		UpdateProfile4 update = new UpdateProfile4();
		int i = update.putProfile4(ch);
		if (i > 0) {
			doGet(req, res);
			System.out.println("Success");
		}
	}

}
