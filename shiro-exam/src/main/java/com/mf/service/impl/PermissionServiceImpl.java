package com.mf.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mf.domain.Permission;
import com.mf.mapper.PermissionMapper;
import com.mf.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@Resource
	private PermissionMapper permissionMapper;
	
	/**
	 * 获取所有权限信息
	 */
	@Override
	public List<Permission> getAllpermission() {
		List<Permission> permission = null;
		try {
			permission = permissionMapper.getAllPermission();
			return permission;
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * 更新权限信息：是否启用
	 */
	@Override
	public int updatePermission(Permission permission) {
		int i = 0;
		try {
			i = permissionMapper.updatePermission(permission);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 获得启用的权限信息
	 */
	@Override
	public List<Permission> getAllIsusePermission() {
		List<Permission> permission = null;
		try {
			permission = permissionMapper.getAllIsusePermission();
			return permission;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return permission;
		}
		
	}

	/**
	 * 根据功能id查询功能
	 */
	@Override
	public Permission getPermissionById(String permissionid) {
		Permission permission=null;
		try {
			permission=permissionMapper.getPermissionById(permissionid);
			return permission;
		} catch (Exception e) {
			e.printStackTrace();
			return permission;
		}
		
	}

	/**
	 * 根据功能id 查询二级功能
	 */
	@Override
	public List<Permission> getNextPermissionById(String permissionid) {
		List<Permission> permission=null;
		try {
			permission=permissionMapper.getNextPermissionById(permissionid);
			return permission;
		} catch (Exception e) {
			e.printStackTrace();
			return permission;
		}
		
	}
	
	/**
	 * 根据角色id查询其所拥有的权限集合
	 */
	@Override
	public List<Permission> getPermissionByRoleId(String roleid) {
		List<Permission> permission=null;
		try {
			permission=permissionMapper.getPermissionByRoleId(roleid);
			return permission;
		} catch (Exception e) {
			e.printStackTrace();
			return permission;
		}
		
	}

	@Override
	public List<Permission> selectDepartIsuserPermission() {
		List<Permission> permission=null;
		try {
			permission=permissionMapper.getDepartIsuserPermission();
			return permission;
		} catch (Exception e) {
			e.printStackTrace();
			return permission;
		}
		
	}
	

}
