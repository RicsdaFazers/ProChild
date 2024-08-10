import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import controllers.ReadUsername;
import models.User;

public class UsernameGet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
		User us = new User();
		String id = req.getParameter("id");
		int id_user = Integer.valueOf(id);
		us.setId(id_user);
		
		ReadUsername username = new ReadUsername();
		User k = username.get(us);
		JSONObject json = new JSONObject();
		try {
			json.put("username", k.getUsername());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print(json); 
	}
}
