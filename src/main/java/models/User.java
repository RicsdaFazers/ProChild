package models;

public class User {
	private int id;
	private String username;
    private String password;
    private String e_mail;
    private int id_child;

    public User() {}
    
    public User(String username, String password) {
    	this.username = username;
    	this.password = password;
    }
    
    public User(String username, String password, String e_mail) {
		super();
		this.username = username;
		this.password = password;
		this.e_mail = e_mail;
	}

	public User(int id, String username, String password, String e_mail, int id_child) {
    	this.id = id;
        this.username = username;
        this.password = password;
        this.e_mail = e_mail;
        this.id_child = id_child;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
    
	public int getId_child() {
		return id_child;
	}

	public void setId_child(int id_child) {
		this.id_child = id_child;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", e_mail=" + e_mail
				+ ", id_child=" + id_child + "]";
	}
}
