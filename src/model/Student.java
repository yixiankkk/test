package model;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stdNo;
	private String stdName;
	private int stdAge;
	private String stdMajor;
	
	public Student() {
		super();
	}

	public Student(String stdNo, String stdName, int stdAge, String stdMajor) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdAge = stdAge;
		this.stdMajor = stdMajor;
	}
	
	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getstdAge() {
		return stdAge;
	}

	public void setstdAge(int stdAge) {
		this.stdAge = stdAge;
	}

	public String getStdmajor() {
		return stdMajor;
	}

	public void setStdmajor(String stdMajor) {
		this.stdMajor = stdMajor;
	}
	public int getStdAge() {
		return stdAge;
	}

	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}

	public String getStdMajor() {
		return stdMajor;
	}

	public void setStdMajor(String stdMajor) {
		this.stdMajor = stdMajor;
	}


}
