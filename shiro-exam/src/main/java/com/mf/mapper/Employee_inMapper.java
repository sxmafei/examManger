package com.mf.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.mf.domain.Employee_in;
public interface Employee_inMapper {
	
    
	/**
	 * 根据部门id查询所属员工
	 * @param unitName 部门名称
	 * @return 员工对象集合
	 */
	public List<Employee_in> selectAllUserByDepartId(Map<String, Object> employee)throws Exception;
	
	/**
	 * 组合查询 用户信息
	 * @param employee_in对象封装条件
	 * @return 用户基本信息
	 * @throws SQLException
	 */
	public List<Employee_in> selectUserByAny(Map<String, Object> employee) throws Exception;

	/**
	 * 获取下一个用户的编号
	 * @return
	 * @throws SQLException
	 */
	public String selectNextUserId()throws SQLException;
	
	/**
	 * 添加用户基本信息
	 * @param user
	 * @throws SQLException
	 */
	public int insertUserInfo(Employee_in employee_in)throws SQLException;
	
	
	/**
	 * 修改用户基本信息(不包括密码)
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int updateUserInfo(Employee_in employee_in)throws SQLException;
	
	/**
	 * 修改用户密码
	 * @param userPassword map里面包括(userId,password)
	 * @return
	 * @throws SQLException
	 */
	public int updateUserPassword(Map<String,Object> userPassword)throws SQLException;
	
	/**
	 * 根据部门Id查询该部门下的用户
	 * @param unitId 部门编号 pageBegin 起始记录数 pageSize 需要访问的记录数
	 * @return List<Employee_in> 用户基本信息 
	 * @throws SQLException
	 */
	public List<Employee_in> selectUserByDepartId(Map<String,Object> condition)throws SQLException;
	
	
	/**
	 * 根据用户名称获取用户Id
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public String selectUserIdByName(String name) throws SQLException;
		
	/**
	 * 判断 employeeid 和 password 是否正确
	 * @param employee_in 包括 employeeid 和 password
	 * @return 1 ：用户存在  0：不正确
	 * @throws SQLException
	 */
	public int selectIsUser(Employee_in employee_in) throws SQLException;
	
	/**
	 * 根据部门编号，获取员工的总记录数
	 * @param departmentid 部门编号
	 * @return 总记录数
	 */
	public int getUserCount(String departmentid)throws SQLException;

}