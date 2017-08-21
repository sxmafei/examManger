package com.mf.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Employee_in implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String employeeid;

    private String employeenumber;

    private String name;

    private String idcode;

    private String sex;

    private Date birthday;

    private String phone;

    private String photo;

    private String email;

    private String address;

    private String duty;

    private String departmentid;

    private String password;

    private String finger;
    
    private boolean status;

    public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	private Integer trainstatus;
    
    private Department department;
    
    private String departmentname;
    
    private List<Role> role;
    
    private List<String> roleid;
    
    private String oneroleid;
    
    
    
    
    
    

	public String getOneroleid() {
		return oneroleid;
	}

	public void setOneroleid(String oneroleid) {
		this.oneroleid = oneroleid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public List<String> getRoleid() {
		return roleid;
	}

	public void setRoleid(List<String> roleid) {
		this.roleid = roleid;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }

    public String getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(String employeenumber) {
        this.employeenumber = employeenumber == null ? null : employeenumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode == null ? null : idcode.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid == null ? null : departmentid.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getFinger() {
        return finger;
    }

    public void setFinger(String finger) {
        this.finger = finger == null ? null : finger.trim();
    }

    public Integer getTrainstatus() {
        return trainstatus;
    }

    public void setTrainstatus(Integer trainstatus) {
        this.trainstatus = trainstatus;
    }

	@Override
	public String toString() {
		return "Employee_in [employeeid=" + employeeid + ", employeenumber=" + employeenumber + ", name=" + name
				+ ", idcode=" + idcode + ", sex=" + sex + ", birthday=" + birthday + ", phone=" + phone + ", photo="
				+ photo + ", email=" + email + ", address=" + address + ", duty=" + duty + ", departmentid="
				+ departmentid + ", password=" + password + ", finger=" + finger + ", trainstatus=" + trainstatus
				+ ", department=" + department + ", role=" + role + ", roleid=" + roleid + "]";
	}


    
    
}