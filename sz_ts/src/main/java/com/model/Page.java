package com.model;

/**
 * @author lujun
 * @date 2018年6月29日
 * 分页参数实体类
 */
public class Page{
	//每页显示多少条数据
	private Integer rows=5;
	//一共多少条记录
	private Integer countAll;
	//一共分多少页
	private Integer pages;
	//当前请求的页码
	private Integer pageRow;
	//当前页码开始的条数标号
	private Integer startRow;
	//当前页面结束条数编号
	private Integer endRow;
	
	//条件
	private Condition condition;
	
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getCountAll() {
		return countAll;
	}
	public void setCountAll(Integer countAll) {
		this.countAll = countAll;
	}
	public Integer getPages() {
		//分页有两种情况
		if(getCountAll()%getRows()==0){//刚好分完
			pages=getCountAll()/getRows();
		}else{//没分完
			pages=getCountAll()/getRows()+1;
		}
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	public Integer getPageRow() {
		return pageRow;
	}
	public void setPageRow(Integer pageRow) {
		this.pageRow = pageRow;
	}
	
	public Integer getStartRow() {
		//开始条数=(当前页码-1)*本页显示多少条
		startRow=(getPageRow()-1)*getRows();
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getEndRow() {
		//结束条数=当前页码*本页显示条数 
		endRow=getPageRow()*getRows();
		return endRow;
	}
	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
    
    
}
