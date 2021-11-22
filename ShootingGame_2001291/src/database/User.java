package database;

public class User {

	private int id;
	private int pw;
	
	User(int id, int pw) {
		this.id = id;
		this.pw = pw;
	}
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPw() {
		return pw;
	}


	public void setPw(int pw) {
		this.pw = pw;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
