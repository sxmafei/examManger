package com.mf.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mf.domain.Employee_in;
import com.mf.domain.Role;
import com.mf.service.RoleService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) 
public class RoleServiceTest {

	@Resource
	private RoleService roleService;
	Logger logger=Logger.getLogger(RoleService.class);
	String employeeid="S100001";
	String roleid="001";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelect() {
		List<Role> role1=roleService.getLeftRoleByUserId(employeeid);
		logger.info("根据用户编号查询该用户不扮演的角色:"+role1);
		
		List<Role> role2=roleService.getRoleWithPerByRoleId(roleid);
		logger.info("1.根据roleid查询角色信息包括其权限信息:"+role2);
		
		List<Role> role3=roleService.getRoleWithPerByRoleId("");
		logger.info("1.根据roleid查询角色信息包括其权限信息 :"+role3);
		
		List<Role> role4=roleService.getRoleByUserId(employeeid);
		logger.info("根据用户编号获取该用户角色信息:"+role4);
		
		Map<String, Object> map1=new HashMap<>();
		map1.put("roleid", roleid);
		List<Employee_in> employee_in1=roleService.getUserByRoleId(map1);
		logger.info("根据角色编号查询该角色下的所有用户:"+employee_in1);
		
		List<Role> role5=roleService.getIsUseRoleByRoleId("001");
		logger.info("查询所有启用的角色:"+role5);
		
		
	}
	
	@Test
	public void testUpdadte(){
		Role role=new Role();
		role.setRoleid("002");
		role.setRolename("super用户");
		role.setRolestatus(false);
		boolean i=roleService.updateRoleInfo(role);
		logger.info("修改角色信息:"+i);
	}
	
	@Test
	public void testInsert(){
		Role role=new Role();	
		role.setRolename("系统管理员");
		role.setDescription("管理各部门的权限分配");
//		int i1=roleService.insertRole(role);
//		logger.info("插入角色信息:"+i1);
		
		List<String> departmentids=new ArrayList<>();
		List<String> permissionid=new ArrayList<>();
		departmentids.add("001001");
		departmentids.add("001002");
		departmentids.add("001001001");
		permissionid.add("001");
		permissionid.add("002");
		role.setDepartmentids(departmentids);
		role.setPermissionid(permissionid);		
		int i3=roleService.addMoreRole(role, departmentids);
		logger.info("批量插入角色信息:"+i3);
		
//		List<String> fun=new ArrayList<>();
//		fun.add("bankmanager:bank");
//		fun.add("grademanager:menu");
//		role.setRoleid("eac51c4a-790c-11e7-a31d-4437e6ee410f");
//		role.setPermissionid(fun);
//		int i2=roleService.insertRolePermission(role);
//		logger.info("插入角色所拥有的权限"+i2);		
	}
	
	@Test
	public void testDelete(){
		List<String> roleid=new ArrayList<>();
		roleid.add("084eb262-790d-11e7-a31d-4437e6ee410f");
		roleid.add("eac51c4a-790c-11e7-a31d-4437e6ee410f");
		boolean i=roleService.deleteRoleInfo(roleid);
		logger.info("删除角色信息:"+i);
		
		boolean i1 =roleService.deleteRolePermissionByRoleid("003");
		logger.info("删除角色的权限(收回分配给角色的权限)"+i1);
	}

}
