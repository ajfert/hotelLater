package com.bdqn.pojo;

import java.util.Date;

public class User {
	private int uid;
	private String uname;
	private String ugender;
	private String upassword;
	private String uidentity;
	private String uemail;
	private Date uborn;
	private String uphone;
	private String utruename;
	private String upicture;
	
	public User(int uid, String uname, String ugender, String upassword, String uidentity, String uemail, Date uborn,
			String uphone, String utruename, String upicture) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.ugender = ugender;
		this.upassword = upassword;
		this.uidentity = uidentity;
		this.uemail = uemail;
		this.uborn = uborn;
		this.uphone = uphone;
		this.utruename = utruename;
		this.upicture = upicture;
	}
	public String getUpicture() {
		return upicture;
	}
	public void setUpicture(String upicture) {
		this.upicture = upicture;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUidentity() {
		return uidentity;
	}
	public void setUidentity(String uidentity) {
		this.uidentity = uidentity;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public Date getUborn() {
		return uborn;
	}
	public void setUborn(Date uborn) {
		this.uborn = uborn;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	
	
	public String getUtruename() {
		return utruename;
	}
	public void setUtruename(String utruename) {
		this.utruename = utruename;
	}
	public User() {
		super();
	}
	
}
