package com.mf.domain;

import java.sql.Date;


public class Archive {

	private String examlevel;
	
	private Date examdate;
	
	private float totalgrade;
	
	private float grade;
	
	private boolean via;

	public String getExamlevel() {
		return examlevel;
	}

	public void setExamlevel(String examlevel) {
		this.examlevel = examlevel;
	}

	public Date getExamdate() {
		return examdate;
	}

	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}

	public float getTotalgrade() {
		return totalgrade;
	}

	public void setTotalgrade(float totalgrade) {
		this.totalgrade = totalgrade;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public boolean isVia() {
		return via;
	}

	public void setVia(boolean via) {
		this.via = via;
	}
	
	
}
