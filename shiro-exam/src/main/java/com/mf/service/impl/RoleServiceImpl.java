package com.mf.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.domain.Employee_in;
import com.mf.domain.Role;
import com.mf.mapper.DepartmentMapper;
import com.mf.mapper.RoleMapper;
import com.mf.realm.MyRealm;
import com.mf.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;
	@Resource
	private DepartmentMapper departmentMapper;

	

	@Override
	public boolean addPermissionForRole(Role role) {
		boolean result=false;
		try {
			 roleMapper.addPermissionForRole(role);
			 result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Transactional
	@Override
	public boolean addRoleWithPermission(Role role) {
		boolean result=false;
		try {
			roleMapper.addRole(role);
			if (role.getPermissionid()!=null) {
				roleMapper.addPermissionForRole(role);
			}
		result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public List<Role> getRoleWithPerByRoleId(String roleid){
		List<Role> role=null;
		try {
			role= roleMapper.getRoleByRoleId(roleid);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return role;
	}

	@Override
	public List<Role> getRoleByUserId(String employeeid){
		List<Role> role=null;
		try {
			role=roleMapper.getRoleByUserId(employeeid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public boolean updateRoleInfo(Role role){
		boolean result=false;
		try {
			 roleMapper.updateRoleInfo(role);
			 result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteRoleInfo(List<String> roleid){
		boolean result=false;
		try {
			 roleMapper.deleteRoleInfo(roleid);
			 result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteRolePermissionByRoleid(String roleid){
		boolean result=false;
		MyRealm myRealm=new MyRealm();
		myRealm.clearCache();
		try {
			 roleMapper.deleteRolePermissionByRoleid(roleid);
			 result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Role> getLeftRoleByUserId(String employeeid){
		List<Role> role=null;
		try {
			role=roleMapper.getLeftRoleByUserId(employeeid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public List<Employee_in> getUserByRoleId(Map<String, Object> roleid){
		List<Employee_in> employee_in=null;
		try {
			employee_in=roleMapper.getUserByRoleId(roleid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee_in;
	}

	@Override
	public List<Role> getIsUseRoleByRoleId(String departmentid) {
		List<Role> role=null;
		try {
			role=roleMapper.getIsUseRoleByRoleId(departmentid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}


	@Override
	public List<Role> getAllRole(Map<String, Object> condition) {
		List<Role> roles=null;
		try {
			roles=roleMapper.getAllRole(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}

	@Override
	public List<Role> getAllRoleByRoleId(String departmentid) {
		List<Role> roles=null;
		try {
			roles=roleMapper.getAllRoleByRoleId(departmentid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}


	@Override
	public boolean deleteRolePermissionByRoleidAndPermissionid(Map<String, List<String>> rolePermission) {
		MyRealm myRealm=new MyRealm();
		myRealm.clearCache();
		boolean result=false;
		try {
			roleMapper.deleteRolePermissionByRoleidAndPermissionid(rolePermission);
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Transactional
	@Override
	public int addMoreRole(Role role,List<String> departmentids) {
		String temp=role.getRolename();
		try {
			for (String departmentid : departmentids) {				
				role.setDepartmentid(departmentid);
				role.setRolename(departmentMapper.selectDepartNameByDepartId(departmentid)+":"+role.getRolename());
				roleMapper.addRole(role);
				roleMapper.addPermissionForRole(role);
				role.setRolename(temp);
			}
			return departmentids.size();
		} catch (Exception e) {
			return 0;
		}
	
	}
	@Override
	public int getRoleCount(String departmentid) {
		try {
			return roleMapper.getRoleCount(departmentid);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<String> getDepartmentIdByRoleType(List<String> roleType) {
		// TODO Auto-generated method stub
		return null;
	}



}
