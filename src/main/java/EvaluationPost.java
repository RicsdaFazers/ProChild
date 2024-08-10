import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.CreateEvaluation;
import models.Shared_activity;

public class EvaluationPost extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.flush();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id_ch = req.getParameter("id_child");
		int id_child = Integer.valueOf(id_ch);
		String id_ac = req.getParameter("id_activity");
		int id_activity = Integer.valueOf(id_ac);
		String eval = req.getParameter("activity_evaluation");
		int evaluation = Integer.valueOf(eval);
		String comment = req.getParameter("activity_comment");
		//String submission = req.getParameter("date");
		//Date sub = .parse(submission);
		//Date submission = null;
		
		Shared_activity sh = new Shared_activity();
		sh.setId_child(id_child);
		sh.setId_activity(id_activity);
		sh.setEvaluation(evaluation);
		sh.setActivity_comment(comment);
		//sh.setSubmission(submission);
		
		CreateEvaluation register = new CreateEvaluation();
		int i = register.postEvaluation(sh);
		if (i > 0) {
			doGet(req, res);
			System.out.println("Success");
		}
	}
}
