package com.bdqn.pojo;

public class Room {
	private int rid;
	private String type;
	private int price;
	private String peoplenum;
	private String status;
	private String remark;
	
	public Room() {
		super();
	}
	public Room(int rid, String type, int price, String peoplenum, String status, String remark) {
		super();
		this.rid = rid;
		this.type = type;
		this.price = price;
		this.peoplenum = peoplenum;
		this.status = status;
		this.remark = remark;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPeoplenum() {
		return peoplenum;
	}
	public void setPeoplenum(String peoplenum) {
		this.peoplenum = peoplenum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
