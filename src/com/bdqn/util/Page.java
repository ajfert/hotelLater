package com.bdqn.util;

import java.util.List;

public class Page<T> {
	private int current;//当前页
	private int totlePage;//总页数
	private int totle;//数据总条数
	private int pageSize;//页容量
	private List<T> data;//数据
	
	
	public Page() {
		super();
	}
	public Page(int current, int totlePage, int totle, int pageSize, List<T> data) {
		super();
		this.current = current;
		this.totlePage = totlePage;
		this.totle = totle;
		this.pageSize = pageSize;
		this.data = data;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}
	public int getTotle() {
		return totle;
	}
	public void setTotle(int totle) {
		this.totle = totle;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	
}
