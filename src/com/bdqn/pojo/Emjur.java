package com.bdqn.pojo;

public class Emjur {
	private int ejid;
	private int eid;
	private int jid;
	
	@Override
	public String toString() {
		return "Emjur [ejid=" + ejid + ", eid=" + eid + ", jid=" + jid + "]";
	}

	public Emjur(int ejid, int eid, int jid) {
		super();
		this.ejid = ejid;
		this.eid = eid;
		this.jid = jid;
	}
	
	public Emjur() {
		super();
	}

	public int getEjid() {
		return ejid;
	}
	public void setEjid(int ejid) {
		this.ejid = ejid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getJid() {
		return jid;
	}
	public void setJid(int jid) {
		this.jid = jid;
	}
	
	
}
