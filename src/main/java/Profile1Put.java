import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.UpdateProfile1;
import models.Child;

public class Profile1Put extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.flush();
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String child_name = req.getParameter("child_name");
		System.out.println(child_name);
		String address = req.getParameter("address");
		String id = req.getParameter("id_child");
		System.out.println(id);
		int id_child = Integer.valueOf(id);
		
		Child ch = new Child();
		ch.setName_child(child_name);
		ch.setAddress(address);
		ch.setId_child(id_child);
		
		UpdateProfile1 update = new UpdateProfile1();
		int i = update.putProfile1(ch);
		if (i > 0) {
			doGet(req, res);
			System.out.println("Success");
		}
	}
}
