package com.mf.service.impl;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.domain.Employee_in;
import com.mf.mapper.Employee_inMapper;
import com.mf.mapper.UserMapper;
import com.mf.service.UserService;
import com.mf.util.ValidateCheck;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private Employee_inMapper employee_inMapper;

	@Resource
	private UserMapper userMapper;

	
	@Override
	public Employee_in getEmployee_inByName(String name) {
		if (ValidateCheck.isNull(name)) {
			return null;
		}
		Employee_in employee_in=null;
		try {
			employee_in= userMapper.getEmployee_inByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee_in;
	}

	
	@Override
	public Set<String> addRoleByName(String name) {
		if (ValidateCheck.isNull(name)) {
			return null;
		}
		Set<String> role=null;
		try {
			role= userMapper.getRoleByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}
	

	@Override
	public Set<String> getPermissionByName(String name) {
		if (ValidateCheck.isNull(name)) {
			return null;
		}
		Set<String> function =null;
		try {
			function= userMapper.getPermissionByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return function;
	}


	@Override
	public boolean deleteUserById(String employeeid) {
		int i=0;
		try {
			i= userMapper.deleteUserById(employeeid);
		} catch (Exception e) {
			e.printStackTrace();
			i= -1;
		}
		if (i==(-1)) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean addRoleForUser(Employee_in employee_in) {
		int i=0;
		try {
			i= userMapper.addRoleForUser(employee_in);
		} catch (Exception e) {
			e.printStackTrace();
			i=-1;
		}
		if (i==(-1)) {
			return false;
		}else {
			return true;
		}
	}


	@Override
	public boolean deleteRoleFromUser(Map<String, Object> userRole) {
		int i=0;
		try {
			i= userMapper.deleteRoleFromUser(userRole);
		} catch (Exception e) {
			e.printStackTrace();
			i=-1;
		}
		if (i==(-1)) {
			return false;
		}else {
			return true;
		}
	}


	@Override
	public String getPasswordByUserId(String employeeid) {
		String password=null;
		try {
			password=userMapper.getPasswordByUserId(employeeid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}


	@Transactional
	@Override
	public boolean updateUserStatus(List<Map<String, Object>> condition) {
		Employee_in employee_in=new Employee_in();
		int i=0;
		try{
		for (Map<String, Object> map : condition) {
			employee_in.setEmployeeid(map.get("employeeid").toString());
			employee_in.setStatus(Boolean.parseBoolean(map.get("status").toString()));
			i=userMapper.updateUserStatus(employee_in);
			}
		}catch(SQLException e){
			e.printStackTrace();
			i=-1;
		}
		if (i==(-1)) {
			return false;
		}else {
			return true;
		}
	}


	@Override
	public boolean login(String username, String password) {
		HttpServletRequest request=ServletActionContext.getRequest();
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		Subject currentUser=SecurityUtils.getSubject();
		Employee_in employee_in=null;		
		try {
			currentUser.login(token);
			employee_in=(Employee_in) currentUser.getPrincipal();
			Session session=currentUser.getSession();
			session.setAttribute("userInfo", employee_in);
			return true;
		} catch (Exception e) {
			try {
				String exceptionClassName=(String) request.getAttribute("shiroLoginFailure");
				if (exceptionClassName!=null) {
					if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
						request.setAttribute("errorInfo", "’ ∫≈≤ª¥Ê‘⁄");
					}else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
						request.setAttribute("errorInfo", "√‹¬Î¥ÌŒÛ");
					}else if ("randomCodeError".equals(exceptionClassName) ) {
						request.setAttribute("errorInfo", "—È÷§¬Î¥ÌŒÛ");
					}
				}
			} catch (Exception e1) {
				return false;
			}
			 return false;
		}
	}

}
