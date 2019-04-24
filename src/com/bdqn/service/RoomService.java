package com.bdqn.service;

import java.util.List;

import com.bdqn.dao.impl.RoomDaoImpl;
import com.bdqn.pojo.Room;
import com.bdqn.util.Page;

public class RoomService {
	RoomDaoImpl r = new RoomDaoImpl();
	
	public Page<Room> paging(int currentPage,int pageSize) {
		List<Room> list = r.Paging(currentPage, pageSize);
		int totle = r.getTotleNum();
		int totlePage = totle%pageSize==0?totle/pageSize:totle/pageSize+1;
		Page<Room> page = new Page<Room>(currentPage, totlePage, totle, pageSize, list);
		return page;
	}
	
	public Page<Room> queryLike(String id,String qtype,int min,int max,int currentPage,int pageSize) {
		List<Room> list = r.queryLike(id, qtype, min, max, currentPage, pageSize, "分页");
		int totle = r.queryLike(id, qtype, min, max, currentPage, pageSize, "总量").size();
		int totlePage = totle%pageSize==0?totle/pageSize:totle/pageSize+1;
		Page<Room> page = new Page<Room>(currentPage, totlePage, totle, pageSize, list);
		return page;
	}
	public Room queryById(int rid) {
		return r.queryById(rid);
	}
	public boolean add(Room room) {
		return r.add(room);
	}
	public boolean deletById(int rid) {
		return r.deletById(rid);
	}
	public boolean updateById(int id,Room room) {
		return r.updateById(id, room);
	}
	
	public static void main(String[] args) {
		RoomService rs = new RoomService();
		System.out.println(rs.queryLike("1", "", 0, 200, 1, 5).getTotlePage());
		
	}
}
