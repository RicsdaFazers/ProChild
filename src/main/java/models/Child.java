package models;

public class Child extends User {
	private int id_child;
    private String name_child;
    private String address;
    private String name_parent1;
    private String name_parent2;
    private int age;
    private String future_profession;
    private int contact;
	
    public Child() {}
    
    public Child(String name) {
    	this.name_child = name;
    }

	public Child(int id_child, String username, String password, String e_mail) {
		super(username, password, e_mail);
		this.id_child = id_child;
		this.name_child = null;
		this.address = null;
		this.name_parent1 = null;
		this.name_parent2 = null;
		this.age = 0;
		this.future_profession = null;
	}

	public int getId_child() {
		return id_child;
	}

	public void setId_child(int id_child) {
		this.id_child = id_child;
	}

	public String getName_child() {
		return name_child;
	}

	public void setName_child(String name_child) {
		this.name_child = name_child;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName_parent1() {
		return name_parent1;
	}

	public void setName_parent1(String name_parent1) {
		this.name_parent1 = name_parent1;
	}

	public String getName_parent2() {
		return name_parent2;
	}

	public void setName_parent2(String name_parent2) {
		this.name_parent2 = name_parent2;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFuture_profession() {
		return future_profession;
	}

	public void setFuture_profession(String future_profession) {
		this.future_profession = future_profession;
	}
	
	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Child [id_child=" + id_child + ", name_child=" + name_child + ", address=" + address + ", name_parent1="
				+ name_parent1 + ", name_parent2=" + name_parent2 + ", age=" + age + ", future_profession="
				+ future_profession + ", contact=" + contact + "]";
	}

}
