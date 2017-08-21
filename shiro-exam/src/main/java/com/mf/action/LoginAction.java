package com.mf.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.mf.domain.Employee_in;
import com.mf.domain.Permission;
import com.mf.service.PermissionService;
import com.mf.service.UserService;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	HttpServletRequest request=ServletActionContext.getRequest();
	@Resource
	private UserService userService;
	@Resource
	private PermissionService permissionService;
	
	private Employee_in employee_in;
	private String rememberMe;
	
	public String getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}
	public Employee_in getEmployee_in() {
		return employee_in;
	}
	public void setEmployee_in(Employee_in employee_in) {
		this.employee_in = employee_in;
	}
	
	//HttpSession session=request.getSession();
	@Override
	public String execute() throws Exception {
	
		if (userService.login(employee_in.getName(), employee_in.getPassword())) {
			List<Permission> permission=permissionService.getAllpermission();
			request.setAttribute("funInfo", permission);
			return SUCCESS;	
			
		}else {
			return ERROR;
		}				
	}
	
	

	
}
