import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import controllers.ReadChild;
import models.Child;

public class ChildGet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        
		Child ch = new Child();
		String id_child = req.getParameter("id");
		int id = Integer.valueOf(id_child);
		ch.setId_child(id);
		
		ReadChild child_get = new ReadChild();
		Child child = child_get.childGet(ch);
		
		JSONObject json = new JSONObject();
		try {
			json.put("child_name", child.getName_child());
			json.put("address", child.getAddress());
			json.put("child_age", child.getAge());
			json.put("future_profession", child.getFuture_profession());
			json.put("parent1_name", child.getName_parent1());
			json.put("parent2_name", child.getName_parent2());
			json.put("contact", child.getContact());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print(json); 
	}

}
