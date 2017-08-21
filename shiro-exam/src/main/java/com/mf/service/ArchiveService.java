package com.mf.service;

import java.util.List;
import java.util.Map;

import com.mf.domain.Archive;

public interface ArchiveService {
	
	/**
	 * 外场员工：根据用户ID查询培训档案信息
	 * @param Map：condition employeeOut	Id 外厂员工编号，pageBegin 起始记录数 pageSize， 需要访问的记录数
	 * @return 培训档案集合
	 */
	public List<Archive> getOutAllArchiveByUserId(Map<String, Object> condition);
	
	/**
	 * 电厂员工：根据用户ID查询培训档案信息
	 * @param Map：condition employeeInId 电厂员工编号，pageBegin 起始记录数 pageSize， 需要访问的记录数
	 * @return 培训档案集合
	 */
	public List<Archive> getInAllArchiveByUserId(Map<String, Object> condition);
	
	/**
	 * 外场员工：根据用户ID查询培训档案信息
	 * @param Map：condition archive对象（employeeOutId 外厂员工编号，examlevel（int） 考试等级，
	 * 						 dataBegin 起始时间 ，dataEnd 截止时间，isVia（boolean） 是否通过)
	 * 						 pageBegin 起始记录数 pageSize， 需要访问的记录数
	 * @return 培训档案集合
	 */
	public List<Archive> getOutSomeArchiveByCondition(Map<String, Object> condition);
	
	/**
	 * 电厂员工：根据用户ID查询培训档案信息
	 * @param Map：condition archive对象（employeeInId 外厂员工编号，examlevel（int） 考试等级，
	 * 						isVia（boolean） 是否通过） dataBegin 起始时间 ，dataEnd 截止时间，
	 * 						 pageBegin 起始记录数 pageSize， 需要访问的记录数
	 * @return 培训档案集合
	 */
	public List<Archive> getInSomeArchiveByCondition(Map<String, Object> condition);
	
	
}
