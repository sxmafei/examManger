package com.mf.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mf.domain.Employee_in;
import com.mf.mapper.Employee_inMapper;
import com.mf.service.Employee_inService;

@Service("employee_inService")
public class Employee_inServiceImpl implements Employee_inService {

	@Resource
	Employee_inMapper employee_inMapper;

	@Override
	public List<Employee_in> selectUserByAny(Map<String, Object> employee) {
		List<Employee_in> role=null;
		try {
			role= employee_inMapper.selectUserByAny(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;		
	}
	
	@Override
	public String selectNextUserId() {
		String nextUserId=null;
		try {
			nextUserId=employee_inMapper.selectNextUserId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nextUserId;
	}
	
	@Override
	public boolean insertUserInfo(Employee_in employee_in) {
		int i=0;
		try {
			employee_in.setEmployeeid(employee_inMapper.selectNextUserId());
			i= employee_inMapper.insertUserInfo(employee_in);		
		} catch (Exception e) {
			e.printStackTrace();
			i=-1;
		}
		 if (i==-1) {
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public boolean updateUserInfo(Employee_in employee_in) {
		int i=0;
		try {
			i= employee_inMapper.updateUserInfo(employee_in);
			if (i>0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean updateUserPassword(Map<String, Object> userPassword) {
		try {
			 employee_inMapper.updateUserPassword(userPassword);
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Employee_in> selectAllUserByDepartId(Map<String, Object> condition) {
		List<Employee_in> employee_in=null;
		try {
			employee_in= employee_inMapper.selectUserByDepartId(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee_in;
	}
	
	@Override
	public String selectUserIdByName(String name) {
		String userid=null;
		try {
			userid=employee_inMapper.selectUserIdByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userid;
	}
	
	@Override
	public boolean selectIsUser(Employee_in employee_in) {
		int i=0;
		try {
			i=employee_inMapper.selectIsUser(employee_in);
			if (i==1) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getUserCount(String departmentid) {
		int i=0;
		try {
			return employee_inMapper.getUserCount(departmentid);
		} catch (Exception e) {
			return i;
		}
	}

}
