package org.dp.service.page;

import java.util.List;

public class PageBean<T> {
	private long total;
	private List<T> data;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
