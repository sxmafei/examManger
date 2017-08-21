package com.mf.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.mf.domain.Employee_in;


/**
 * 用户管理接口：登录、给用户分配角色、删除用户、关闭用户
 * @author dream
 *
 */
public interface UserService {


    /**
     * 根据用户名查询用户信息极其所属部门及其部门信息及其角色信息
     * @param name
     * @return Employee_in
     */
    public Employee_in getEmployee_inByName(String name) ;
    
    /**
     * 根据用户名查询角色
     * @param name
     * @return 角色集合
     */
    public Set<String> addRoleByName(String name) ;	
    
    /**
     * 根据用户名查询权限
     * @param name
     * @return 角色集合
     */
    public Set<String> getPermissionByName(String name) ;	
     
    //public List<Permission> getObjectPermissionByName(String name);
	
	/**
	 * 根据用户Id查询用户的登录密码
	 * @param userId 用户Id
	 * @return 系统登录密码
	 * @throws SQLException
	 */
	public String getPasswordByUserId(String employeeid) ;
	
	
	/**
	 * 给用户分配角色
	 * @param userRole (employeeid,roleId)
	 * @return 是否操作成功
	 * @throws SQLException
	 */
	public boolean addRoleForUser(Employee_in employee_in);
	
	/**
	 * 批量关闭/开启用户
	 * @param employee_ins map(employeeid 员工编号,status 状态)
	 * @return 是否操作成功
	 */
	public boolean updateUserStatus(List<Map<String, Object>> condition);
	
	/**
	 * 撤销分配给用户的角色
	 * @param userRole map里面包含（用户编号 角色编号 ）(employeeId,roleId)
	 * @return 是否操作成功
	 * @throws SQLException
	 */
	public boolean deleteRoleFromUser(Map<String,Object> userRole);
		
	/**
	 * 根据用户编号删除用户
	 * @param employeeid
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteUserById(String employeeid);
	
	/**
	 * 传入用户名 username、密码 password
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public boolean login(String username,String password);
	
}
