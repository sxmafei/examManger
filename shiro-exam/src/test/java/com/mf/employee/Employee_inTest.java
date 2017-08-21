package com.mf.employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mf.domain.Employee_in;
import com.mf.service.Employee_inService;
import com.mf.service.RoleService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) 
public class Employee_inTest {

	Logger logger=Logger.getLogger(RoleService.class);
	@Resource
	private Employee_inService employee_inService;
	
	String employeeid="S100001";
	String name="曹操";
	String departmentid="001";
	
	@Test
	public void testSelect() {
		
		String employee=employee_inService.selectUserIdByName(name);
		logger.info("根据用户名称获取用户Id:"+employee);
		
		String nextuserid = employee_inService.selectNextUserId();
		logger.info("获取下一个用户的编号:"+nextuserid);
		
		Map<String, Object> map1=new HashMap<>();
		map1.put("departmentid", departmentid);
		List<Employee_in> employee_ins1=employee_inService.selectAllUserByDepartId(map1);
		logger.info("根据部门Id查询该部门下的用户:"+employee_ins1);
		
		Employee_in employee_in2=new Employee_in();
		employee_in2.setEmployeeid(employeeid);
		employee_in2.setDepartmentid("001");
		employee_in2.setAddress("");
		Map<String, Object> map2=new HashMap<>();
		map2.put("employee", employee_in2);
		map2.put("departmentid", "001");
		List<Employee_in> employee_in1=employee_inService.selectUserByAny(map2);
		logger.info("组合查询 用户信息:"+employee_in1);	
		
		Employee_in employee_in3=new Employee_in();
		employee_in3.setEmployeeid("S100001");
		employee_in3.setPassword("123");
		boolean i=employee_inService.selectIsUser(employee_in3);
		logger.info(i);
	}
	
	@Test
	public void testInsert(){
		Employee_in employee_in2=new Employee_in();
		String userid=employee_inService.selectNextUserId();
		employee_in2.setEmployeeid(userid);
		employee_in2.setDepartmentid("001");
		employee_in2.setName("许褚");
		boolean result=employee_inService.insertUserInfo(employee_in2);
		logger.info("添加用户基本信息:"+result);
		
	}
	
	@Test
	public void testUpdate(){
		Employee_in employee_in2=new Employee_in();
		employee_in2.setEmployeeid("S100010");
		employee_in2.setDepartmentid("002");
		employee_in2.setAddress("山西省皇家科大");
		boolean i1=employee_inService.updateUserInfo(employee_in2);
		logger.info("修改用户基本信息(不包括密码):"+i1);
		
		Map<String, Object> userPassword=new HashMap<>();
		userPassword.put("employeeid", "S100010");
		userPassword.put("password", "123");
		boolean i2=employee_inService.updateUserPassword(userPassword);
		logger.info("修改用户密码:"+i2);
	}
	
}
