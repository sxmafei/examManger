package com.mf.mapper;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import com.mf.domain.Employee_in;
import com.mf.domain.Permission;

public interface UserMapper {

	   /**
     * 根据用户名查询用户信息极其所属部门及其部门信息及其角色信息
     * @param name
     * @return Employee_in
     */
    public Employee_in getEmployee_inByName(String name) throws SQLException;
    
    /**
     * 根据用户名查询角色
     * @param name
     * @return 角色集合
     */
    public Set<String> getRoleByName(String name)throws SQLException;	
    
    /**
     * 根据用户名查询权限
     * @param name
     * @return 角色集合
     */
    public Set<String> getPermissionByName(String name) throws SQLException;	
	
	/**
	 * 根据用户Id查询用户的登录密码
	 * @param userId 用户Id
	 * @return 系统登录密码
	 * @throws SQLException
	 */
	public String getPasswordByUserId(String employeeid) throws SQLException;
	
	
	/**
	 * 给用户分配角色
	 * @param userRole (employeeid,roleId)
	 * @return 操作的记录数
	 * @throws SQLException
	 */
	public int addRoleForUser(Employee_in employee_in)throws SQLException;
	
	/**
	 * 关闭/开启用户
	 * @param employee_ins map(employeeid 员工编号,status 状态)
	 * @return 操作的记录数
	 */
	public int updateUserStatus(Employee_in employee_in)throws SQLException;
	
	/**
	 * 撤销分配给用户的角色
	 * @param userRole map里面包含（用户编号 角色编号 ）(employeeId,roleId)
	 * @return 操作的记录数
	 * @throws SQLException
	 */
	public int deleteRoleFromUser(Map<String,Object> userRole)throws SQLException;
		
	/**
	 * 根据用户编号删除用户
	 * @param employeeid
	 * @return
	 * @throws SQLException
	 */
	public int deleteUserById(String employeeid)throws SQLException;
	
	public Set<Permission> getObjectPermissionByName(String name); 
}
