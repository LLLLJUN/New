package com.ws.model;

/**
 * @author lujun
 * @date 2018年6月29日
 * 分页参数实体类
 */
public class Page{
	//每页显示多少条数据
	private int rows=5;
	//一共多少条记录
	private int countAll;
	//一共分多少页
	private int pages;
	//当前请求的页码
	private int pageRow;
	//当前页码开始的条数标号
	private int startRow;
	//当前页面结束条数编号
	private int endRow;
	
	//条件
	private Condition condition;
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCountAll() {
		return countAll;
	}
	public void setCountAll(int countAll) {
		this.countAll = countAll;
	}
	public int getPages() {
		//分页有两种情况
		if(getCountAll()%getRows()==0){//刚好分完
			pages=getCountAll()/getRows();
		}else{//没分完
			pages=getCountAll()/getRows()+1;
		}
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public int getPageRow() {
		return pageRow;
	}
	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}
	
	public int getStartRow() {
		//开始条数=(当前页码-1)*本页显示多少条
		startRow=(getPageRow()-1)*getRows();
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		//结束条数=当前页码*本页显示条数 
		endRow=getPageRow()*getRows();
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	@Override
	public String toString() {
		return "Page [rows=" + rows + ", countAll=" + countAll + ", pages=" + pages + ", pageRow=" + pageRow
				+ ", startRow=" + startRow + ", endRow=" + endRow + ", condition=" + condition + "]";
	}
    
    
}
