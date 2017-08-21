package com.mf.domain;

import java.util.Date;

public class Breakrules {
    private Integer breakid;

    private String employeeid;

    private String breakcontent;

    private Date breaktime;

    private Integer minusnum;

    public Integer getBreakid() {
        return breakid;
    }

    public void setBreakid(Integer breakid) {
        this.breakid = breakid;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }

    public String getBreakcontent() {
        return breakcontent;
    }

    public void setBreakcontent(String breakcontent) {
        this.breakcontent = breakcontent == null ? null : breakcontent.trim();
    }

    public Date getBreaktime() {
        return breaktime;
    }

    public void setBreaktime(Date breaktime) {
        this.breaktime = breaktime;
    }

    public Integer getMinusnum() {
        return minusnum;
    }

    public void setMinusnum(Integer minusnum) {
        this.minusnum = minusnum;
    }
}