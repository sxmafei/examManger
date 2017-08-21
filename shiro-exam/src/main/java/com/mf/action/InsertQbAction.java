package com.mf.action;

import javax.annotation.Resource;

import com.mf.domain.Questionbank;
import com.mf.service.QbService;
import com.opensymphony.xwork2.ActionSupport;

public class InsertQbAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 题库管理接口
	 */
	@Resource
    private QbService qbService;
	
	private Questionbank questionBank;
	public Questionbank getQuestionBank() {
		return questionBank;
	}


	public void setQuestionBank(Questionbank questionBank) {
		this.questionBank = questionBank;
	}


	@Override
	public String execute() throws Exception {
		
		System.out.println(questionBank);
		Integer i=qbService.insertQB(questionBank);
		System.out.println(i);
		return SUCCESS;
	}

}
