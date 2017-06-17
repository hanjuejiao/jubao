package org.dp.service.page;

public class PageParam {
	private int page;//页号
	private int rows;//每页条数
	
	private String sort;
	private String order;
	
	
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


	private long beginPageIndex;


	public long getBeginPageIndex() {
//		if(page==1){
//			beginPageIndex = 1;
//		}else{
//			beginPageIndex = (page-1)*rows+1;
//		}
//		return beginPageIndex;
		return beginPageIndex = (page-1)*rows+1;
	}

}
