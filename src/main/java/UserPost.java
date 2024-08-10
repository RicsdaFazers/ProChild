import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import controllers.CreateChild;
import controllers.CreateUser;
import controllers.ReadUser;
import models.User;

public class UserPost extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.flush();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String e = req.getParameter("email");
		String u = req.getParameter("username");
		String p = req.getParameter("password");
		
		User us = new User();
		us.setE_mail(e);
		us.setUsername(u);
		us.setPassword(p);
		
		CreateUser register = new CreateUser();
		int i = register.postRegister(us);
		if (i > 0) {
			
			System.out.println("Success");
			JSONObject json = new JSONObject();
			try {
				json.put("REGISTER", "SUCCESS");
				PrintWriter out = res.getWriter();
				out.write(json.toString());
				out.print(json.toString());
				
				System.out.println("Register successful" + json.toString());
				
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
		//BUSCAR ID USER (VOU RECEBER UM OBJETO)
		ReadUser get = new ReadUser();
		User k = get.userId(us);
		
		//FAZER POST ID USER NA TABELA CHILD (VOU-LHE PASSAR O OBJETO EM CIMA QUE TEM O ID USER)
		CreateChild post = new CreateChild();
		post.registerChild(k);
				
	}
}
