import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.oreilly.servlet.MultipartRequest;

import controllers.UpdatePhoto;
import models.Shared_activity;

public class PhotoPut extends HttpServlet {
	String activity_photo;
	int s = 1;
	String ext;
	//UploadMSG msg = new UploadMSG();
	public void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id_child = req.getParameter("id_child");
		int id_ch = Integer.parseInt(id_child);
		String id_activity = req.getParameter("id_activity");
		int id = Integer.parseInt(id_activity);
		
		res.setContentType("application/xhtml+xml");
		PrintWriter out = res.getWriter();
		
		try {
			MultipartRequest r = new MultipartRequest(req, "C:/Users/ricar/eclipse-workspace/DAI_sv/DAI-end/Images/", 1000000*512);
			activity_photo = r.getFilesystemName("upload");
			int lastIndex = activity_photo.lastIndexOf('.');
			ext = activity_photo.substring(lastIndex, activity_photo.length());
			
		} catch (Exception exc){
			System.out.println("exc");
			s = 0;
		}
		
		boolean b = ext.equals(".jpg") || ext.equals(".JPG") || ext.equals(".png") || ext.equals(".PNG") || ext.equals(".JPEG") || ext.equals(".jpeg");
		
		System.out.println(b + " ext");
		
		if(s == 1) {
			System.out.println("OLA1");
			if(ext.equals(".jpg") || ext.equals(".JPG") || ext.equals(".png") || ext.equals(".PNG") || ext.equals(".JPEG") || ext.equals(".jpeg")) {
				Shared_activity sh = new Shared_activity();
				sh.setId_child(id_ch);
				sh.setId_activity(id);
				sh.setPhoto(activity_photo);
				UpdatePhoto update = new UpdatePhoto();
				
				int i = update.putPhoto(sh);
				
				if(i > 0) {
					System.out.println("UPDATED WITH SUCESS");
					JSONObject json = new JSONObject();
					try {
						json.put("STATUS", true);
						json.put("MSG", true);
						
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					out.print(json);
					out.flush();
					
				} else {
					try {
						JSONObject json = new JSONObject();
						json.put("STATUS", false);
						json.put("MSG", false);
						File file = new File("C:/Users/ricar/eclipse-workspace/DAI_sv/DAI-end/Images/" + activity_photo);
						out.print(json);
						out.flush();
						 if(file.delete())
					        {
					            System.out.println("File deleted successfully");
					        }
					        else
					        {
					            System.out.println("Failed to delete the file");
					        }
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}
}
