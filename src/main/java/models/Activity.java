package models;

import java.sql.Date;
import java.sql.Time;

public class Activity extends Child {
	private int id_activity;
    private String name;
    private String address;
    private String city;
    private Date schedule;
    private int day;
    private Time beginning_date;
    private Time end_date;
    private String name_institution;
    private String file;
    private int id_child;
	
    public Activity() {}
    
    public Activity(String name, String name_child) {
    	super(name_child);
    	this.name = name;
    }

	public Activity(int id_child) {
		this.id_child = id_child;
	}

	public Activity(int id_activity, String name, String file, int day) {
		this.id_activity = id_activity;
		this.name = name;
		this.file = file;
		this.day = day;
	}

	public Activity(String name, String address, Date schedule, String file) {
		this.name = name;
		this.address = address;
		this.schedule = schedule;
		this.file = file;
	}

	public Activity(int id_activity, String name, String address, String city, Date schedule, int day, Time beginning_date, Time end_date, String name_institution, int id_child) {
		this.id_activity = id_activity;
		this.name = name;
		this.address = address;
		this.city = city;
		this.schedule = schedule;
		this.day = day;
		this.beginning_date = beginning_date;
		this.end_date = end_date;
		this.name_institution = name_institution;
		this.id_child = id_child;
	}

	public int getId_activity() {
		return id_activity;
	}

	public void setId_activity(int id_activity) {
		this.id_activity = id_activity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getSchedule() {
		return schedule;
	}

	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Time getBeginning_date() {
		return beginning_date;
	}

	public void setBeginning_date(Time beginning_date) {
		this.beginning_date = beginning_date;
	}

	public Time getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Time end_date) {
		this.end_date = end_date;
	}

	public String getName_institution() {
		return name_institution;
	}

	public void setName_institution(String name_institution) {
		this.name_institution = name_institution;
	}
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getId_child() {
		return id_child;
	}

	public void setId_child(int id_child) {
		this.id_child = id_child;
	}

	@Override
	public String toString() {
		return "Activity [id_activity=" + id_activity + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", schedule=" + schedule + ", beginning_date=" + beginning_date + ", end_date=" + end_date
				+ ", name_institution=" + name_institution + ", id_child=" + id_child + "]";
	}
}
