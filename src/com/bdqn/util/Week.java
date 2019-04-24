package com.bdqn.util;

public class Week {
	private int[] thisweek;
	private int[] previousweek;
	private String[] weekname;
	public Week() {
		super();
	}
		
	public Week(int[] thisweek, int[] previousweek, String[] weekname) {
		super();
		this.thisweek = thisweek;
		this.previousweek = previousweek;
		this.weekname = weekname;
	}

	public String[] getWeekname() {
		return weekname;
	}
	public void setWeekname(String[] weekname) {
		this.weekname = weekname;
	}
	public int[] getThisweek() {
		return thisweek;
	}
	public void setThisweek(int[] thisweek) {
		this.thisweek = thisweek;
	}
	public int[] getPreviousweek() {
		return previousweek;
	}
	public void setPreviousweek(int[] previousweek) {
		this.previousweek = previousweek;
	}
	
}
