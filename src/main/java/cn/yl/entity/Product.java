package cn.yl.entity;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2883627920029045233L;
	private int product_id;
	private String arrange;
	private String user;
	private String path;
	private int money;
	private int shot;
	private int collnum;
	private Date createtime;
	private String productname;
	private String describecontent;
	private int indexnum;
	private int week;
	
	public Product() {
		super();
	}


	public Product(int product_id, String arrange, String user, String path, int money, int shot, int collnum,
			Date createtime, String productname, String describecontent, int indexnum) {
		this.product_id = product_id;
		this.arrange = arrange;
		this.user = user;
		this.path = path;
		this.money = money;
		this.shot = shot;
		this.collnum = collnum;
		this.createtime = createtime;
		this.productname = productname;
		this.describecontent = describecontent;
		this.indexnum = indexnum;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public int getShot() {
		return shot;
	}


	public void setShot(int shot) {
		this.shot = shot;
	}


	public int getCollnum() {
		return collnum;
	}


	public void setCollnum(int collnum) {
		this.collnum = collnum;
	}


	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(long createtime) {
		this.createtime = new Date(createtime);
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public String getDescribecontent() {
		return describecontent;
	}


	public void setDescribecontent(String describecontent) {
		this.describecontent = describecontent;
	}


	public int getIndexnum() {
		return indexnum;
	}


	public void setIndexnum(int indexnum) {
		this.indexnum = indexnum;
	}


	public String getArrange() {
		return arrange;
	}


	public void setArrange(String arrange) {
		this.arrange = arrange;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public int getWeek() {
		return week;
	}


	public void setWeek(int week) {
		this.week = week;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + product_id;
		result = prime * result + ((productname == null) ? 0 : productname.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (product_id != other.product_id)
			return false;
		if (productname == null) {
			if (other.productname != null)
				return false;
		} else if (!productname.equals(other.productname))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", arrange=" + arrange + ", user=" + user + ", path=" + path
				+ ", money=" + money + ", shot=" + shot + ", collnum=" + collnum + ", createtime=" + createtime
				+ ", productname=" + productname + ", describecontent=" + describecontent + ", indexnum=" + indexnum
				+ ", week=" + week + "]";
	}


	


	

	
	
}
