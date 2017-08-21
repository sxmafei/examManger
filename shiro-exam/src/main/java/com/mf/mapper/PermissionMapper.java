package com.mf.mapper;

import java.sql.SQLException;
import java.util.List;
import com.mf.domain.Permission;

public interface PermissionMapper {
    
    /**
     * 查询所有的权限
     * @return 权限对象的集合
     */
    public List<Permission> getAllPermission() throws SQLException;
    
    /**
     * 查询所有已启用的的权限
     * @return 所有启用的权限对象的集合
     */
    public List<Permission> getAllIsusePermission() throws SQLException;
    
	/**
	 * 查询启用的权限（不包括 厂级的权限）：部门级角色
	 * @return 不包括厂级权限的所有权限的集合
	 */
	public List<Permission> getDepartIsuserPermission() throws SQLException;
    
    /**
     * 更新权限：是否启用,描述
     * @param permission permissionid,status(true,false)
     * @return 操作的记录数
     */
	public int updatePermission(Permission permission) throws SQLException;
	
	/**
	 * 根据permissionid查询功能信息
	 * @param 权限id
	 * @return 权限集合
	 * 
	 */
	public Permission getPermissionById(String permissionid) throws SQLException ;

	/**
	 * 根据permissionid查询下一级所有功能信息
	 * @param 功能id
	 * @return
	 *
	 */
	public List<Permission> getNextPermissionById(String permissionid)  throws SQLException;
	
	/**
	 * 根据 roleid 查询所拥有的权限
	 * @param rolename
	 * @return
	 * @throws SQLException
	 */
	public List<Permission> getPermissionByRoleId(String roleid) throws SQLException;
}