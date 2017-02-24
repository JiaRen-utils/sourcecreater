package com.sourcecreater.utils;

/**
 * EasyUI 分页帮助类
 * 
 * @author 杨攀
 * 
 */
public class PageHelper implements java.io.Serializable {
	private int page;// 当前页
	private int rows;// 每页显示记录数
	private int totalPage; //总页数
	private int totalCount;//总条数
	private String sort;// 排序字段
	private String order;// asc/desc
	
	/*additional param*/
	private int pageEnd;
	
	//如果pageFor为"EXCEL"则为导出用
	private String pageFor;
	
	
	public String getPageFor() {
		return pageFor;
	}
	public void setPageFor(String pageFor) {
		this.pageFor = pageFor;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}