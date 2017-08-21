package com.mf.action;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;
import com.mf.domain.Department;
import com.mf.domain.Employee_in;
import com.mf.domain.Questionbank;
import com.mf.service.DepartService;
import com.mf.service.QbService;

import com.opensymphony.xwork2.ActionSupport;


public class QBankManagerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Questionbank questionBank;
	public Questionbank getQuestionBank() {
		return questionBank;
	}


	public void setQuestionBank(Questionbank questionBank) {
		this.questionBank = questionBank;
	}
	
	/**
	 * 题库管理接口
	 */
	@Resource
    private QbService qbService;
	
	/**
	 * 部门管理接口
	 */
	@Resource
	private DepartService departService;

	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	
	

	@Override
	public String execute() throws Exception {
		
		String departmentId;
		try {
			Employee_in employee_in=(Employee_in) session.getAttribute("userInfo");
			departmentId = employee_in.getDepartmentid();
		} catch (Exception e) {
				return ERROR;
		}
		List<Questionbank> questionBank=qbService.selectQbByDepartmentId(departmentId);
		List<Department> department=departService.selectAllDepartbyId(departmentId);
		if (questionBank!=null) {
		request.setAttribute("QBs", questionBank);
		request.setAttribute("depart", department);	
			return SUCCESS;
		}else {
			return ERROR;
		}		
	}
	

	
	

}
