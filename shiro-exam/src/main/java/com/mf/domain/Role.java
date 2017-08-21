package com.mf.domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String roleid;

    private String rolename;

    private boolean rolestatus;

    private String description;

    private String remark;
    
    private String departmentid;
    
    private List<String> permissionid;
    
    private List<Permission> permission;
    
    private List<String> departmentids;
    
    


	public List<String> getDepartmentids() {
		return departmentids;
	}

	public void setDepartmentids(List<String> departmentids) {
		this.departmentids = departmentids;
	}

	public List<Permission> getPermission() {
		return permission;
	}

	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}


	public void setRolestatus(boolean rolestatus) {
		this.rolestatus = rolestatus;
	}

	public List<String> getPermissionid() {
		return permissionid;
	}

	public void setPermissionid(List<String> Permission) {
		this.permissionid = Permission;
	}

	public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid ;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename ;
    }

    public Boolean getRolestatus() {
        return rolestatus;
    }

    public void setRolestatus(Boolean rolestatus) {
        this.rolestatus = rolestatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description ;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark ;
    }

	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}

	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + ", rolestatus=" + rolestatus + ", description="
				+ description + ", remark=" + remark + ", departmentid=" + departmentid + ", permissionid="
				+ permissionid + ", permission=" + permission + "]";
	}



	
	

	
    
}