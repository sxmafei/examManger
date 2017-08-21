package com.mf.domain;

import java.util.Date;

public class Traincontent {
    private Integer documentid;

    private String documentname;

    private String traintype;

    private String originalname;

    private String currentname;

    private Date uptime;

    private String size;

    private String employeeid;

    private String level;

    private String description;

    private String departmentid;

    private Integer browsetimes;

    public Integer getDocumentid() {
        return documentid;
    }

    public void setDocumentid(Integer documentid) {
        this.documentid = documentid;
    }

    public String getDocumentname() {
        return documentname;
    }

    public void setDocumentname(String documentname) {
        this.documentname = documentname == null ? null : documentname.trim();
    }

    public String getTraintype() {
        return traintype;
    }

    public void setTraintype(String traintype) {
        this.traintype = traintype == null ? null : traintype.trim();
    }

    public String getOriginalname() {
        return originalname;
    }

    public void setOriginalname(String originalname) {
        this.originalname = originalname == null ? null : originalname.trim();
    }

    public String getCurrentname() {
        return currentname;
    }

    public void setCurrentname(String currentname) {
        this.currentname = currentname == null ? null : currentname.trim();
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid == null ? null : departmentid.trim();
    }

    public Integer getBrowsetimes() {
        return browsetimes;
    }

    public void setBrowsetimes(Integer browsetimes) {
        this.browsetimes = browsetimes;
    }
}