package cn.yl.entity;

import java.util.List;

public class ManagerPage {
	private List<User> list;
	private int pageAll;
	private String page;
	private int beforePage;
	private int afterPage;
	public ManagerPage() {
		super();
	}
	public ManagerPage(List<User> list, int pageAll, String page, int beforePage, int afterPage) {
		super();
		this.list = list;
		this.pageAll = pageAll;
		this.page = page;
		this.beforePage = beforePage;
		this.afterPage = afterPage;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public int getPageAll() {
		return pageAll;
	}
	public void setPageAll(int pageAll) {
		this.pageAll = pageAll;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public int getBeforePage() {
		return beforePage;
	}
	public void setBeforePage(int beforePage) {
		this.beforePage = beforePage;
	}
	public int getAfterPage() {
		return afterPage;
	}
	public void setAfterPage(int afterPage) {
		this.afterPage = afterPage;
	}
	
}
