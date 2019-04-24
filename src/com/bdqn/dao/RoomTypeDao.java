package com.bdqn.dao;

import java.util.List;

import com.bdqn.pojo.RoomType;

public interface RoomTypeDao {
	public RoomType queryById(int typeid);
	public boolean add(RoomType roomType);
	public boolean deletById(int typeid);
	public boolean updateById(int id,RoomType roomType);
	public List<RoomType> Paging(int currentPage,int pageSize);
	public int getTotleNum();
}
