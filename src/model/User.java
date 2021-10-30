package model;

public class User {

	private String Uname;
	private String Upwd;
	
	
	public User() {
		super();
	}
	public User(String uname, String upwd) {
		super();
		Uname = uname;
		Upwd = upwd;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUpwd() {
		return Upwd;
	}
	public void setUpwd(String upwd) {
		Upwd = upwd;
	}
	
}
