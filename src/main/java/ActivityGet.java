import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import controllers.ReadActivity;
import models.Activity;

public class ActivityGet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        
		Activity act = new Activity();
		String id_activity = req.getParameter("id");
		int id = Integer.valueOf(id_activity);
		act.setId_activity(id);
		
		ReadActivity name_activity = new ReadActivity();
		Activity activ = name_activity.activityGet(act);
		
		JSONObject json = new JSONObject();
		try {
			json.put("name", activ.getName());
			json.put("local", activ.getAddress());
			json.put("schedule", activ.getSchedule());
			json.put("start", activ.getBeginning_date());
			json.put("end", activ.getEnd_date());
			json.put("institution", activ.getName_institution());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print(json); 
	}
}
