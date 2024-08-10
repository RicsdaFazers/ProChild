import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import controllers.ReadActivityGraphic;
import models.Graphic;

public class ActivityGraphicGet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        
		Graphic gra = new Graphic();
		
		ReadActivityGraphic graphic = new ReadActivityGraphic();
		Graphic g = graphic.graphicGet(gra);
		
		JSONObject json = new JSONObject();
		try {
			json.put("Janeiro", g.getJanuary());
			json.put("Fevereiro", g.getFebruary());
			json.put("Março", g.getMarch());
			json.put("Abril", g.getApril());
			json.put("Maio", g.getMay());
			json.put("Junho", g.getJune());
			json.put("Julho", g.getJuly());
			json.put("Agosto", g.getAugust());
			json.put("Setembro", g.getSeptember());
			json.put("Outubro", g.getOctober());
			json.put("Novembro", g.getNovember());
			json.put("Dezembro", g.getDecember());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print(json); 
	}

}
