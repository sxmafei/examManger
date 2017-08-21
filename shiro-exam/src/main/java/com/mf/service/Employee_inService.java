package com.mf.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mf.domain.Employee_in;

public interface Employee_inService {

		/**
		 * 根据部门Id查询该部门下的所有用户
		 * @param departmentId 部门编号 pageBegin 起始记录数 pageSize 需要访问的记录数
		 * @return List<Employee_in> 用户基本信息 
		 * @throws SQLException
		 */
		public List<Employee_in> selectAllUserByDepartId(Map<String,Object> condition);
		
		/**
		 * 组合查询 用户信息
		 * @param 1、employee_in对象封装条件 包括基本信息、部门编号、角色编号 
		 * 			2、传入mydepartmentid 限制其只能查看本部门的员工 若有厂级权限 则传入'001'
		 * 			3、传入pageBegin、pavgeSize完成分页
		 * @return 用户基本信息
		 * @throws SQLException
		 */
		public List<Employee_in> selectUserByAny(Map<String, Object> employee) ;
		
		/**
		 * 根据用户名称获取用户Id
		 * @param name
		 * @return
		 * @throws SQLException
		 */
		public String selectUserIdByName(String name) ;
		
		/**
		 * 获取下一个用户的编号
		 * @return
		 * @throws SQLException
		 */
		public String selectNextUserId();
		
		/**
		 * 判断 employeeid 和 password 是否正确
		 * @param employee_in 包括 employeeid 和 password
		 * @return 1 ：用户存在  0：不正确
		 * @throws SQLException
		 */
		public boolean selectIsUser(Employee_in employee_in) ;
		
		/**
		 * 添加用户基本信息
		 * @param user
		 * @throws SQLException
		 */
		public boolean insertUserInfo(Employee_in employee_in);
		
		/**
		 * 修改用户基本信息(不包括密码、关闭用户)
		 * @param user
		 * @return
		 * @throws SQLException
		 */
		public boolean updateUserInfo(Employee_in employee_in);
		
		/**
		 * 修改用户密码
		 * @param userPassword map里面包括(userId,password)
		 * @return
		 * @throws SQLException
		 */
		public boolean updateUserPassword(Map<String,Object> userPassword);

		/**
		 * 根据部门编号，获取员工的总记录数
		 * @param departmentid 部门编号
		 * @return 总记录数
		 */
		public int getUserCount(String departmentid);

}
