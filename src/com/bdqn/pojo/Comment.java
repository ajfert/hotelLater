package com.bdqn.pojo;

import java.util.Date;

public class Comment {
	private int cid;
	private int uid;
	private String content;
	private Date ctime;
	
	
	public Comment() {
		super();
	}
	public Comment(int cid, int uid, String content, Date ctime) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.content = content;
		this.ctime = ctime;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	
	
}
