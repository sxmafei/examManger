package com.mf.domain;

public class Unit {
    private String unitid;

    private String upunitid;

    private String name;

    private String address;

    private String contect;

    private String phone;

    private Integer grade;

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid == null ? null : unitid.trim();
    }

    public String getUpunitid() {
        return upunitid;
    }

    public void setUpunitid(String upunitid) {
        this.upunitid = upunitid == null ? null : upunitid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContect() {
        return contect;
    }

    public void setContect(String contect) {
        this.contect = contect == null ? null : contect.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}