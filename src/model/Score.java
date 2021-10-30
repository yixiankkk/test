package model;

import java.io.Serializable;


public class Score implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int pk_score;
	private String StdName;
	private String StdNo;
	private String math_score;
	private String chinese_score;
	private String english_score;
	private String term;
	
	public Score()
	{
		super();
	}
	
	
	public Score(int pk_score, String stdName, String stdNo, String math_score, String chinese_score, String english_score,
			String term) {
		super();
		this.pk_score = pk_score;
		this.StdName = stdName;
		this.StdNo = stdNo;
		this.math_score = math_score;
		this.chinese_score = chinese_score;
		this.english_score = english_score;
		this.term = term;
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
	
	

}
