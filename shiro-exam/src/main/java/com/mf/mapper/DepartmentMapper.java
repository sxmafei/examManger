package com.mf.mapper;

import java.sql.SQLException;
import java.util.List;

import com.mf.domain.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
	/**
	 * 根据部门id查询部门极其管辖班组
	 * @param departmentId
	 * @return 部门实体
	 */
	public List<Department> selectAllDepartbyId(String departmentId) throws Exception;
	
	/**
	 * 根据部门id查询部门极其管辖班组
	 * @param departmentId
	 * @return 部门实体
	 */
	public Department selectDepartbyId(String departmentId) throws Exception;
	
	/**
	 * 根据部门id获取部门名字
	 * @param departmentId 部门id
	 * @return departmentName 部门名字
	 */
	public String selectDepartNameByDepartId(String  departmentId) throws SQLException;
	
}