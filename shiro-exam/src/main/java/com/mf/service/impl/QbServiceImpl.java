package com.mf.service.impl;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.mf.domain.Questionbank;
import com.mf.mapper.QuestionbankMapper;
import com.mf.service.QbService;

@Service("qbService")
public class QbServiceImpl implements QbService {
	
	
	@Resource
	private QuestionbankMapper questionbankMapper;


	public List<Questionbank> selectQbByDepartmentId(String departmentid) {
		Subject currentUser=SecurityUtils.getSubject();
		if (currentUser.hasRole("001")||currentUser.hasRole("002") ) {
			departmentid="";
		}
		List<Questionbank> questionbank=questionbankMapper.selectQbByDepartmentId(departmentid);
		return questionbank;
	}


	@Override
	public int insertQB(Questionbank questionBank) {
		int i=questionbankMapper.insertQB(questionBank);
		return i;
	}

}
