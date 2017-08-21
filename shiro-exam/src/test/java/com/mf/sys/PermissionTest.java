package com.mf.sys;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mf.domain.Permission;
import com.mf.service.PermissionService;
import com.mf.service.RoleService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) 
public class PermissionTest {

	Logger logger=Logger.getLogger(RoleService.class);
	String permissionid="001";
	@Resource
	private PermissionService permissionService;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelect() {
		List<Permission> permission1=permissionService.getAllpermission();
		logger.info("查询所有的权限:"+permission1);
		
		Permission permission2=permissionService.getPermissionById(permissionid);
		logger.info("根据permissionid查询功能信息:"+permission2);
		
		List<Permission> permissions1=permissionService.getPermissionByRoleId("1d04da84-7daa-11e7-ba13-4437e6ee410f");
		logger.info("根据 roleid 查询所拥有的权限:"+permissions1);
		
		List<Permission> permissions2=permissionService.getAllIsusePermission();
		logger.info("查询启用的权限:"+permissions2);
		
		List<Permission> permissions3=permissionService.getNextPermissionById("001");
		logger.info("根据权限id查询下一级所有权限信息:"+permissions3);
	}
	
	@Test
	public void testUpdadte(){
		Permission permission=new Permission();
		permission.setPermissionid("001");
		permission.setStatus(true);
		int i=permissionService.updatePermission(permission);
		logger.info("更新权限 是否启用:"+i);
	}
	


}
