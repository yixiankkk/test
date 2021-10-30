package model;

import java.io.Serializable;

public class Hobby  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String StdName;
	private String StdNo;
	private String Major;
	private String Hobby;
	
	
	public Hobby() {
		super();
	}
	public Hobby(String stdName, String stdNo, String major, String hobby) {
		super();
		StdName = stdName;
		StdNo = stdNo;
		Major = major;
		Hobby = hobby;
	}
	public String getStdName() {
		return StdName;
	}
	public void setStdName(String stdName) {
		StdName = stdName;
	}
	public String getStdNo() {
		return StdNo;
	}
	public void setStdNo(String stdNo) {
		StdNo = stdNo;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getHobby() {
		return Hobby;
	}
	public void setHobby(String hobby) {
		Hobby = hobby;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
