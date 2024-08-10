import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.UpdateProfile2;
import models.Child;

public class Profile2Put extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.flush();
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String child_age = req.getParameter("age");
		int age = Integer.valueOf(child_age);
		System.out.println(age);
		String profession = req.getParameter("profession");
		String id = req.getParameter("id_child");
		System.out.println(id);
		int id_child = Integer.valueOf(id);
		
		Child ch = new Child();
		ch.setAge(age);
		ch.setFuture_profession(profession);
		ch.setId_child(id_child);
		
		UpdateProfile2 update = new UpdateProfile2();
		int i = update.putProfile2(ch);
		if (i > 0) {
			doGet(req, res);
			System.out.println("Success");
		}
	}
}
