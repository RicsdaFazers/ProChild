import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import controllers.ReadShared;
import models.Activity;
import models.Shared_activity;

public class ShareGet extends HttpServlet {
	
	List<Shared_activity> l;
	JSONObject json = new JSONObject();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        ReadShared sh = new ReadShared();
        l = sh.sharedActivity();
        
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
        
        /*Shared_activity sha = new Shared_activity();
		ReadShared shared = new ReadShared();
		
		Shared_activity sh = shared.sharedActivity(sha);*/
		
		//System.out.println(sh.getName());
		
		
		//JSONObject json = new JSONObject();
		
		/*try {
			json.put("name", sh.getName());
			json.put("comment", sh.getActivity_comment());
			json.put("photo", sh.getPhoto());
			json.put("child", sh.getName_child());
			json.put("submission", sh.getSubmission());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print(json);*/
	}
}
