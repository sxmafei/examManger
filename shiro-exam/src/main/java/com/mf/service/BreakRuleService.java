package com.mf.service;

import java.util.List;
import java.util.Map;

import com.mf.domain.Breakrules;

public interface BreakRuleService {

	/**
	 * 添加违章信息
	 * @param breakrules
	 * @return 是否操作成功
	 */
	public boolean addBreakRule(Breakrules breakrules);
	
	/**
	 * 修改违章信息
	 * @param breakrules
	 * @return 是否操作成功
	 */
	public boolean updateBreakRuleById(Breakrules breakrules);
	
	/**
	 * 根据违章编号删除违章信息
	 * @param breakruleid
	 * @return 是否操作成功
	 */
	public boolean deleteBreakRuleById(String breakruleid);
	
	/**
	 * 获得所有的违章信息
	 * @param map condition:pageBegin 起始记录数, pageSize， 需要访问的记录数
	 * @return 违章信息集合
	 */
	public List<Breakrules> getAllBreakRule(Map<String, Object> condition);
	
	/**
	 * 组合查询违章信息
	 * @param Map condition： breakrule对象（employeeid 外厂员工编号,minusnum 扣除积分）
	 * 						 dataBegin 起始时间 ，dataEnd 截止时间，
	 * 						 pageBegin 起始记录数 pageSize， 需要访问的记录数
	 * @return 违章信息集合
	 */
	public List<Breakrules> getSomeBreakRule(Map<String, Object> condition);
	
	
	
}
