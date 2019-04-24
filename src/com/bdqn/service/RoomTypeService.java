package com.bdqn.service;

import java.util.List;

import com.bdqn.dao.impl.RoomTypeDaoImpl;
import com.bdqn.pojo.RoomType;
import com.bdqn.util.Page;

public class RoomTypeService {
	RoomTypeDaoImpl r = new RoomTypeDaoImpl();
	
	public Page<RoomType> paging(int currentPage,int pageSize) {
		List<RoomType> list = r.Paging(currentPage, pageSize);
		int totle = r.getTotleNum();
		int totlePage = totle%pageSize==0?totle/pageSize:totle/pageSize+1;
		Page<RoomType> page = new Page<RoomType>(currentPage, totlePage, totle, pageSize, list);
		return page;
	}
	public RoomType queryById(int typeid) {
		return r.queryById(typeid);
	}
	public boolean add(RoomType roomtype) {
		return r.add(roomtype);
	}
	public boolean deletById(int typeid) {
		return r.deletById(typeid);
	}
	public boolean updateById(int id,RoomType roomtype) {
		return r.updateById(id, roomtype);
	}
}
