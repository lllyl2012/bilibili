package cn.yl.entity;

import java.io.Serializable;
import java.util.Date;

public class HistoryPro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8008646110435357566L;
	private Date readtime;
	private String productname;
	public Date getReadtime() {
		return readtime;
	}
	public void setReadtime(long time) {
		this.readtime = new Date(time);
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	@Override
	public String toString() {
		return "HistoryPro [readtime=" + readtime + ", productname=" + productname + "]";
	}
	
}
