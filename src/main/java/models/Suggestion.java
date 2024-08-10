package models;

public class Suggestion {
	private int id_suggestion;
    private String comment;
    private int id_child;
	
    public Suggestion() {}

	public Suggestion(int id_suggestion, String comment, int id_child) {
		this.id_suggestion = id_suggestion;
		this.comment = comment;
		this.id_child = id_child;
	}

	public int getId_suggestion() {
		return id_suggestion;
	}

	public void setId_suggestion(int id_suggestion) {
		this.id_suggestion = id_suggestion;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId_child() {
		return id_child;
	}

	public void setId_child(int id_child) {
		this.id_child = id_child;
	}

	@Override
	public String toString() {
		return "Suggestion [id_suggestion=" + id_suggestion + ", comment=" + comment + ", id_child=" + id_child + "]";
	}
}
