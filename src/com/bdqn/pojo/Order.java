package com.bdqn.pojo;

import java.util.Date;

public class Order {
	private int oid;//订单号
	private int rid;//房间号
	private int uid;//用户id
	private int eid;//员工号
	private Date starttime;//入住日期
	private Date endtime;//离开日期
	private int eprice;//价格
	private String status;//状态
	private Date booktime;
	private String remark;//备注
	
	
	
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", rid=" + rid + ", uid=" + uid + ", eid=" + eid + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", eprice=" + eprice + ", status=" + status + ", booktime=" + booktime
				+ ", remark=" + remark + "]";
	}

	public Order() {
		super();
	}
	
	public Order(int oid, Date starttime, Date endtime, int eprice, String status, Date booktime) {
		super();
		this.oid = oid;
		this.starttime = starttime;
		this.endtime = endtime;
		this.eprice = eprice;
		this.status = status;
		this.booktime = booktime;
	}

	public Order(int oid, int rid, int uid, int eid, Date starttime, Date endtime, int eprice, String status,
			Date booktime, String remark) {
		super();
		this.oid = oid;
		this.rid = rid;
		this.uid = uid;
		this.eid = eid;
		this.starttime = starttime;
		this.endtime = endtime;
		this.eprice = eprice;
		this.status = status;
		this.booktime = booktime;
		this.remark = remark;
	}
	public Date getBooktime() {
		return booktime;
	}
	public void setBooktime(Date booktime) {
		this.booktime = booktime;
	}

	public int getEprice() {
		return eprice;
	}

	public void setEprice(int eprice) {
		this.eprice = eprice;
	}

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
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
