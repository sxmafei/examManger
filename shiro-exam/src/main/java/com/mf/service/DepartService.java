package com.mf.service;

import java.util.List;

import com.mf.domain.Department;

public interface DepartService {
	
	/**
	 * 根据部门id查询部门极其管辖班组
	 * @param departmentId
	 * @return 部门实体
	 */
	public List<Department> selectAllDepartbyId(String departmentId) ;
	
	/**
	 * 根据部门id查询部门极其管辖班组
	 * @param departmentId
	 * @return 部门实体
	 */
	public Department selectDepartbyId(String departmentId) ;	

	/**
	 * 根据部门id获取部门名字
	 * @param departmentId 部门id
	 * @return departmentName 部门名字
	 */
	public String selectDepartNameByDepartId(String  departmentId);
	
	/**
	 * 根据角色的部门id集合查询部门树
	 * @param departmentid
	 * @return
	 */
	public List<Department> getDepartmentTreeByDepartIdFromRole(List<String> departmentid);
}
