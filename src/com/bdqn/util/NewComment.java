package com.bdqn.util;

import java.util.Date;

public class NewComment {
	private int cid;
	private String content;
	private Date ctime;
	private String uname;
	private String upicture;
	
	
	public NewComment() {
		super();
	}
	public NewComment(int cid, String content, Date ctime, String uname, String upicture) {
		super();
		this.cid = cid;
		this.content = content;
		this.ctime = ctime;
		this.uname = uname;
		this.upicture = upicture;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpicture() {
		return upicture;
	}
	public void setUpicture(String upicture) {
		this.upicture = upicture;
	}
	
	
}
