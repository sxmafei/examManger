package com.mf.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.mf.domain.Employee_in;
import com.mf.domain.Role;

public interface RoleService {

	/**
	 * 插入角色所拥有的权限
	 * @param role
	 * @return
	 */
	public boolean addPermissionForRole(Role role) ;
		
	/**
	 * 插入角色信息以及其权限信息
	 * 将权限编号传入role中的permissionid属性 可同时插入角色的权限信息
	 * @param role
	 * @return
	 */
	public boolean addRoleWithPermission(Role role);
	
	/**
	 * 批量插入角色信息
	 * @param role :包括角色基本信息、部门编号集合 departmentids、权限id集合 permissionid
	 * 				插入角色名格式为 部门名：角色名
	 * @return 插入的记录数
	 */
	public int addMoreRole(Role role,List<String> departmentids);
	
	/**
	 * 查询本部极其所属部门的所有角色信息
	 * @param condition departmentid 部门id pageBegin：开始  pageSize：每页数量
	 * @return role 对象集合
	 */
	public List<Role> getAllRole(Map<String, Object> condition);
	
	/**
	 * 根据roleid查询角色信息包括其权限信息
	 * @return 角色信息(List<Role>)
	 * @throws SQLException
	 */
	public List<Role> getRoleWithPerByRoleId(String roleid);
	
	/**
	 * 根据部门id查询本部门的所有角色:
	 * @return 角色信息集合
	 * @throws SQLException
	 */
	public List<Role> getAllRoleByRoleId(String departmentid);
	
	/**
	 * 用于给用户分配角色
	 * 查询所有启用的角色:1判断其权限 若有厂级系统管理权限，传入'001'
	 * 					 2若没有厂级权限 则传入用户的departmentid
	 * @return 角色信息集合
	 * @throws SQLException
	 */
	public List<Role> getIsUseRoleByRoleId(String departmentid);
		
	/**
	 * 根据用户编号获取该用户角色信息
	 * @param 用户编号 employeeid
	 * @return 当前用户的角色信息
	 * @throws SQLException
	 */
	public List<Role> getRoleByUserId(String employeeid);
	
	/**
	 * 修改角色信息
	 * @param roleInfo 角色信息(role)
	 * @return 修改的记录数 (int)
	 * @throws SQLException
	 */
	public boolean updateRoleInfo(Role role);
	
	/**
	 * 删除角色信息
	 * @param roleId 角色Id(String)
	 * @return 删除的记录数(int)
	 * @throws SQLException
	 */
	public boolean deleteRoleInfo(List<String> roleid);

	/**
	 * 删除角色的所有权限
	 * @param roleid
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public boolean deleteRolePermissionByRoleid(String roleid);
	
	/**
	 * 根据roleid permissionid 删除角色的部分权限
	 * @param Map<String, List<String>> roleid:roleid permissionid:permissionid的集合
	 * @return 删除的记录数
	 */
	public boolean deleteRolePermissionByRoleidAndPermissionid(Map<String, List<String>> rolePermission);
	
	/**
	 * 根据用户编号查询该用户不扮演的角色
	 * @param employeeid 用户编号
	 * @return 角色基本信息
	 * @throws SQLException
	 */
	public List<Role> getLeftRoleByUserId(String employeeid);
	
	/**
	 * 根据角色编号查询该角色下的所有用户
	 * @param roleid:角色编号 pageBegin：开始  pageSize：每页数量
	 * @return List<Employee_in> 用户基本信息 
	 * @throws SQLException
	 */
	public List<Employee_in> getUserByRoleId(Map<String, Object> roleid);

	/**
	 * 获取本部门的角色总数(不包括所属部门)
	 * @param departmentid 部门编号
	 * @return 角色总数
	 */
	public int getRoleCount(String departmentid);
	
	/**
	 * 根据角色类型的集合获得部门编号集合
	 * @return
	 */
	public List<String> getDepartmentIdByRoleType(List<String> roleType);

}
