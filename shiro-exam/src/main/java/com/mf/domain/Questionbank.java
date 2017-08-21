package com.mf.domain;

import java.sql.Date;


public class Questionbank {
    private String questionbankid;

    private String questionbankname;

    private String departmentid;

    private String employeeid;

    private Date createtime;

    private String description;
    
    private String departmentName;
    private String name;
    
    

    public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
		
	}

	public String getQuestionbankid() {
        return questionbankid;
    }

    public void setQuestionbankid(String questionbankid) {
        this.questionbankid = questionbankid == null ? null : questionbankid.trim();
    }

    public String getQuestionbankname() {
        return questionbankname;
    }

    public void setQuestionbankname(String questionbankname) {
        this.questionbankname = questionbankname == null ? null : questionbankname.trim();
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid == null ? null : departmentid.trim();
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description ;
    }

	@Override
	public String toString() {
		return "Questionbank [questionbankid=" + questionbankid + ", questionbankname=" + questionbankname
				+ ", departmentid=" + departmentid + ", employeeid=" + employeeid + ", createtime=" + createtime
				+ ", description=" + description + ", departmentName=" + departmentName + ", name=" + name + "]";
	}
    
    
}