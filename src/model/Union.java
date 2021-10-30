package model;

import java.io.Serializable;

public class Union implements Serializable {
	private static final long serialVersionUID = 1L;
	private int age;
	private int pk_score;
	private String StdName;
	private String StdNo;
	private String math_score;
	private String chinese_score;
	private String english_score;
	private String term;
	private int stdAge;
	
	
	public Union() {
		super();
	}
	public Union(int age, int pk_score, String stdName, String stdNo, String math_score, String chinese_score,
			String english_score, String term, int stdAge) {
		super();
		this.age = age;
		this.pk_score = pk_score;
		StdName = stdName;
		StdNo = stdNo;
		this.math_score = math_score;
		this.chinese_score = chinese_score;
		this.english_score = english_score;
		this.term = term;
		this.stdAge = stdAge;
	}
	//Getter和Setter方法
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPk_score() {
		return pk_score;
	}
	public void setPk_score(int pk_score) {
		this.pk_score = pk_score;
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
	public String getMath_score() {
		return math_score;
	}
	public void setMath_score(String math_score) {
		this.math_score = math_score;
	}
	public String getChinese_score() {
		return chinese_score;
	}
	public void setChinese_score(String chinese_score) {
		this.chinese_score = chinese_score;
	}
	public String getEnglish_score() {
		return english_score;
	}
	public void setEnglish_score(String english_score) {
		this.english_score = english_score;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public int getStdAge() {
		return stdAge;
	}
	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}
	
	
	
}
