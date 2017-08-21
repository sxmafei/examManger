package com.mf.domain;

import java.util.Date;

public class Onlineexaminfor {
    private String onlineexamid;

    private String examid;

    private String employeeid;

    private Date logintime;

    private Date starttime;

    private Date endtime;

    private String ipaddress;

    public String getOnlineexamid() {
        return onlineexamid;
    }

    public void setOnlineexamid(String onlineexamid) {
        this.onlineexamid = onlineexamid == null ? null : onlineexamid.trim();
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

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }
}