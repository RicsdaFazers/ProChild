package models;

import java.sql.Date;

public class Shared_activity extends Activity {
	private int id_shared_activity;
	private int id_activity;
	private int id_child;
	private String activity_comment;
	private int evaluation;
	private String photo;
	private Date submission;
	
	public Shared_activity() {}

	public Shared_activity(int id_shared_activity, int id_activity, int id_child, String activity_comment, int evaluation, String photo, Date submission) {
		this.id_shared_activity = id_shared_activity;
		this.id_activity = id_activity;
		this.id_child = id_child;
		this.activity_comment = activity_comment;
		this.evaluation = evaluation;
		this.photo = photo;
		this.submission = submission;
	}

	public Shared_activity(String name, String comment, String photo2, String child, Date submission2) {
		// TODO Auto-generated constructor stub
		super(name, child);
		this.activity_comment = comment;
		this.photo = photo2;
		this.submission = submission2;
	}

	public int getId_shared_activity() {
		return id_shared_activity;
	}

	public void setId_shared_activity(int id_shared_activity) {
		this.id_shared_activity = id_shared_activity;
	}

	public int getId_activity() {
		return id_activity;
	}

	public void setId_activity(int id_activity) {
		this.id_activity = id_activity;
	}
	
	public int getId_child() {
		return id_child;
	}

	public void setId_child(int id_child) {
		this.id_child = id_child;
	}

	public String getActivity_comment() {
		return activity_comment;
	}

	public void setActivity_comment(String activity_comment) {
		this.activity_comment = activity_comment;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getSubmission() {
		return submission;
	}

	public void setSubmission(Date submission) {
		this.submission = submission;
	}

	@Override
	public String toString() {
		return "Shared_activity [id_shared_activity=" + id_shared_activity + ", id_activity=" + id_activity
				+ ", activity_comment=" + activity_comment + ", evaluation=" + evaluation + ", photo=" + photo
				+ ", submission=" + submission + "]";
	}
}
