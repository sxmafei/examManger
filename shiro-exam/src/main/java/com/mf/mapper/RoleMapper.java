package com.mf.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.mf.domain.Employee_in;
import com.mf.domain.Role;


public interface RoleMapper {
    
	/**
	 * 为角色分配权限
	 * @param role
	 * @return
	 */
	public int addPermissionForRole(Role role) throws SQLException ;
		
	/**
	 * 插入角色信息
	 * @param role
	 * @return
	 */
	public int addRole(Role role) throws SQLException;
	
	
	/**
	 * 查询本部极其所属部门的所有角色信息
	 * @param condition departmentid 部门id pageBegin：开始  pageSize：每页数量
	 * @return role 对象集合
	 */
	public List<Role> getAllRole(Map<String, Object> condition)  throws SQLException;
	
	/**
	 * 1.根据roleid查询角色信息包括其权限信息
	 * @return 角色信息(List<TBaseRoleInfo>)
	 * @throws SQLException
	 */
	public List<Role> getRoleByRoleId(String roleid) throws SQLException;
	
	/**
	 * 查询所有角色:1判断其权限 若有厂级系统管理权限，传入空值''或null
	 * 			    2若没有厂级权限 则传入用户的departmentid
	 * @return 角色信息集合
	 * @throws SQLException
	 */
	public List<Role> getAllRoleByRoleId(String departmentid) throws SQLException;
	
	/**
	 * 查询所有启用的角色:1判断其权限 若有厂级系统管理权限，传入空值''或null
	 * 					 2若没有厂级权限 则传入用户的departmentid
	 * @return 角色信息集合
	 * @throws SQLException
	 */
	public List<Role> getIsUseRoleByRoleId(String departmentid) throws SQLException;
		
	/**
	 * 根据用户编号获取该用户角色信息
	 * @param userId 用户编号
	 * @return 当前用户的角色信息
	 * @throws SQLException
	 */
	public List<Role> getRoleByUserId(String employeeid) throws SQLException;
	
	
	/**
	 * 修改角色信息
	 * @param role 角色信息(role)
	 * @return 修改的记录数 (int)
	 * @throws SQLException
	 */
	public int updateRoleInfo(Role role) throws SQLException;
	
	/**
	 * 删除角色信息
	 * @param roleId 角色Id(String)
	 * @return 删除的记录数(int)
	 * @throws SQLException
	 */
	public int deleteRoleInfo(List<String> roleid) throws SQLException;

	/**
	 * 删除角色的所有权限
	 * @param roleid
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteRolePermissionByRoleid(String roleid) throws SQLException;
	
	/**
	 * 根据roleid permissionid 删除角色的部分权限
	 * @param Map<String, List<String>> roleid:roleid permissionid:permissionid的集合
	 * @return 删除的记录数
	 */
	public int deleteRolePermissionByRoleidAndPermissionid(Map<String, List<String>> rolePermission) throws SQLException;
	
	/**
	 * 根据用户编号查询该用户不扮演的角色
	 * @param employeeid 用户编号
	 * @return 角色基本信息
	 * @throws SQLException
	 */
	public List<Role> getLeftRoleByUserId(String employeeid) throws SQLException;
	
	/**
	 * 根据角色编号查询该角色下的所有用户
	 * @param roleid:角色编号 pageBegin：开始  pageSize：每页数量
	 * @return List<Employee_in> 用户基本信息 
	 * @throws SQLException
	 */
	public List<Employee_in> getUserByRoleId(Map<String, Object> roleid) throws SQLException;
	
	/**
	 * 获取本部门的角色总数(不包括所属部门)
	 * @param departmentid 部门编号
	 * @return 角色总数
	 */
	public int getRoleCount(String departmentid);
}