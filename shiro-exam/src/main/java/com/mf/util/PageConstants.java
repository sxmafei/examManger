package com.mf.util;

public class PageConstants {
	private int MASSAGE_PAGE_SIZE = 8;//每页条数
	
	/* 得到总页数 */
	public int getPages(int nums) {
		return (nums - 1) / MASSAGE_PAGE_SIZE + 1;
	}
	/* 得到起始记录数 */
	public int getRecordNums(int page){
		return (page - 1) * MASSAGE_PAGE_SIZE;
	}

	public void setPageSize(int pageSize) {
		MASSAGE_PAGE_SIZE = pageSize;
	}
	
	public int getPageSize() {
		return MASSAGE_PAGE_SIZE;
	}
}