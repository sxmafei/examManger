package com.mf.domain;

public class Department {
    private String departmentid;

    private String departmentname;

    private String updepartmentid;

    private String employeeid;

    private String phone;

    private String description;

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid == null ? null : departmentid.trim();
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

    public String getUpdepartmentid() {
        return updepartmentid;
    }

    public void setUpdepartmentid(String updepartmentid) {
        this.updepartmentid = updepartmentid == null ? null : updepartmentid.trim();
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", departmentname=" + departmentname + ", updepartmentid="
				+ updepartmentid + ", employeeid=" + employeeid + ", phone=" + phone + ", description=" + description
				+ "]";
	}
    
}