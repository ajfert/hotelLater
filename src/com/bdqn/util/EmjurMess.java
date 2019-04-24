package com.bdqn.util;

public class EmjurMess {
	private int ejid;
	private String ename;
	private String jname;
	private String jobname;
	
	
	@Override
	public String toString() {
		return "[ejid=" + ejid + ", ename=" + ename + ", jname=" + jname + ", jobname=" + jobname + "]";
	}
	public EmjurMess() {
		super();
	}
	public EmjurMess(int ejid, String ename, String jname, String jobname) {
		super();
		this.ejid = ejid;
		this.ename = ename;
		this.jname = jname;
		this.jobname = jobname;
	}
	public int getEjid() {
		return ejid;
	}
	public void setEjid(int ejid) {
		this.ejid = ejid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	
	
}
