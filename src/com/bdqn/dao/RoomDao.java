package com.bdqn.dao;

import java.util.List;

import com.bdqn.pojo.Room;

public interface RoomDao {
	public Room queryById(int rid);
	public boolean add(Room room);
	public boolean deletById(int rid);
	public boolean updateById(int id,Room room);
	public List<Room> Paging(int currentPage,int pageSize);
	public int getTotleNum();
	public List<Room> queryLike(String id,String qtype,int min,int max,int currentPage,int pageSize,String todo);
}
