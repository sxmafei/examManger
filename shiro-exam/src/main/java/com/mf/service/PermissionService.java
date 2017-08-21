package com.mf.service;

import java.sql.SQLException;
import java.util.List;
import com.mf.domain.Permission;

public interface PermissionService {

	
    /**
     * 查询所有的权限
     * @return 权限集合
     */
    public 	List<Permission> getAllpermission();
    
	 /**
     * 查询所有启用的权限：厂级角色
     * @return 所有启用的权限集合
     */
	public List<Permission> getAllIsusePermission();
	
	/**
	 * 查询启用的权限（不包括 厂级的权限）：部门级角色
	 * @return 不包括厂级权限的所有权限的集合
	 */
	public List<Permission> selectDepartIsuserPermission();

    /**
     * 更新权限 是否启用
     * @param permission
     * @return
     */
	public int updatePermission(Permission permission);
	
	/**
	 * 根据permissionid查询权限信息
	 * @param 权限id
	 * @return
	 * 
	 */
	public Permission getPermissionById(String permissionid) ;

	/**
	 * 根据权限id查询下一级所有权限信息
	 * @param 权限id
	 * @return
	 *
	 */
	public List<Permission> getNextPermissionById(String permissionid);

	/**
	 * 根据 roleid 查询所拥有的权限
	 * @param rolename
	 * @return
	 * @throws SQLException
	 */
	public List<Permission> getPermissionByRoleId(String roleid);

}
