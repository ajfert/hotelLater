package com.bdqn.pojo;

public class Employee {
	private int eid;//员工号
	private String ename;//员工姓名
	private String epassword;//员工密码
	private String jobname;//职务
	private int age;//年龄
	private String email;//邮箱
	private String phone;//手机
	private String remark;//备注
	
	public Employee() {
		super();
	}
	
	public Employee(int eid, String ename, String epassword, String jobname, int age, String email, String phone,
			String remark) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.epassword = epassword;
		this.jobname = jobname;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.remark = remark;
	}

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
