import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import controllers.ReadChildActivity;
import controllers.ReadShared;
import models.Activity;

public class ChildActivityGet extends HttpServlet {
	
	List<Activity> l;
	JSONObject json = new JSONObject();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        
        Activity a = new Activity();
        
        String id = req.getParameter("id_child");
		int id_child = Integer.valueOf(id);
		a.setId_child(id_child);

        ReadChildActivity ca = new ReadChildActivity();
        l = ca.childActivity(a);
        
        try {
			json.put("MSG", l);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			out.print(json.get("MSG"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
