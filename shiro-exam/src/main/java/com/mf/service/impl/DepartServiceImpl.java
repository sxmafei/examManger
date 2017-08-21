package com.mf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.mf.domain.Department;
import com.mf.mapper.DepartmentMapper;
import com.mf.service.DepartService;

@Service("departService")
public class DepartServiceImpl implements DepartService {

	@Resource
	private DepartmentMapper departmentMapper;

	@Override
	public List<Department> selectAllDepartbyId(String departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department selectDepartbyId(String departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectDepartNameByDepartId(String departmentId) {
		String departmentName=null;
		try {
			departmentMapper.selectDepartNameByDepartId(departmentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departmentName;
	}
	  
	

}
