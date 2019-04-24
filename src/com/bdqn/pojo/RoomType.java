package com.bdqn.pojo;

public class RoomType {
	private int typeid;
	private String type;
	private int price;
	private int peoplenum;
	private int number;
	public RoomType(int typeid, String type, int price, int peoplenum, int number) {
		super();
		this.typeid = typeid;
		this.type = type;
		this.price = price;
		this.peoplenum = peoplenum;
		this.number = number;
	}
	public RoomType() {
		super();
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
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
	public int getPeoplenum() {
		return peoplenum;
	}
	public void setPeoplenum(int peoplenum) {
		this.peoplenum = peoplenum;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
