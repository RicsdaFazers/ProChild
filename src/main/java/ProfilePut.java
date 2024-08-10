import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.UpdateProfile;
import models.Child;

public class ProfilePut extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.flush();
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String child_name = req.getParameter("child_name");
		System.out.println(child_name);
		String parent1 = req.getParameter("parent1_name");
		String parent2 = req.getParameter("parent2_name");
		String ag = req.getParameter("child_age");
		int age = Integer.valueOf(ag);
		String address = req.getParameter("address");
		String profession = req.getParameter("future_profession");
		String id = req.getParameter("id_child");
		System.out.println(id);
		int id_child = Integer.valueOf(id);
		
		Child ch = new Child();
		ch.setName_child(child_name);
		ch.setName_parent1(parent1);
		ch.setName_parent2(parent2);
		ch.setAge(age);
		ch.setAddress(address);
		ch.setFuture_profession(profession);
		ch.setId_child(id_child);
		
		UpdateProfile register = new UpdateProfile();
		int i = register.putProfile(ch);
		if (i > 0) {
			doGet(req, res);
			System.out.println("Success");
		}
	}

}
