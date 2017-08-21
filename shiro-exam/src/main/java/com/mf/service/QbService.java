package com.mf.service;
import java.util.List;

import com.mf.domain.Questionbank;

public interface QbService {

	/**
	 * 根据部门id查询所属题库
	 * @param departmentId
	 * @return 本部门及所属部门的题库信息
	 */
	public List<Questionbank> selectQbByDepartmentId(String departmentId);
	
	/**
	 * 新建题库
	 * @param questionbank
	 * @return 
	 */
	public int insertQB(Questionbank questionbank);
}
