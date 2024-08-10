import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.UpdateProfile3;
import models.Child;

public class Profile3Put extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.flush();
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String parent1 = req.getParameter("parent1_name");
		System.out.println(parent1);
		String parent2 = req.getParameter("parent2_name");
		String id = req.getParameter("id_child");
		System.out.println(id);
		int id_child = Integer.valueOf(id);
		
		Child ch = new Child();
		ch.setName_parent1(parent1);
		ch.setName_parent2(parent2);
		ch.setId_child(id_child);
		
		UpdateProfile3 update = new UpdateProfile3();
		int i = update.putProfile3(ch);
		if (i > 0) {
			doGet(req, res);
			System.out.println("Success");
		}
	}
}
