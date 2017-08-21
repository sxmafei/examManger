package com.mf.domain;

public class Employeeexam {
    private String gradeid;

    private String examid;

    private String employeeid;

    private Float grade;

    private String exammethod;

    public String getGradeid() {
        return gradeid;
    }

    public void setGradeid(String gradeid) {
        this.gradeid = gradeid == null ? null : gradeid.trim();
    }

    public String getExamid() {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid == null ? null : examid.trim();
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getExammethod() {
        return exammethod;
    }

    public void setExammethod(String exammethod) {
        this.exammethod = exammethod == null ? null : exammethod.trim();
    }
}