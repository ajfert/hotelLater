package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.RoomTypeDao;
import com.bdqn.pojo.RoomType;

public class RoomTypeDaoImpl extends BaseDao implements RoomTypeDao{

	@Override
	public RoomType queryById(int typeid) {
		String sql = "SELECT * FROM `roomtype` WHERE typeid=?";
		Object[] parameters = {typeid};
		ResultSet rs = query(sql, parameters);
		RoomType roomtype = null;
		try {
			while(rs.next()) {
				String type = rs.getString("type");
				int price = rs.getInt("price");
				int peoplenum = rs.getInt("peoplenum");
				int number = rs.getInt("number");
				roomtype = new RoomType(typeid, type, price, peoplenum, number);
			}
			return roomtype;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(RoomType roomType) {
		String sql = "INSERT INTO `roomtype` VALUES(?,?,?,?,?)";
		int typeid = roomType.getTypeid();
		String type = roomType.getType();
		int price = roomType.getPrice();
		int peoplenum = roomType.getPeoplenum();
		int number = roomType.getNumber();
		
		Object[] parameters = {typeid, type, price, peoplenum, number};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deletById(int typeid) {
		String sql = "DELETE FROM `roomtype` WHERE typeid=?";
		Object[] parameters = {typeid};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateById(int id, RoomType roomType) {
		String sql = "UPDATE `user` SET typeid=?, type=?, price=?, peoplenum=?, number=? WHERE typeid=?";
		int typeid = roomType.getTypeid();
		String type = roomType.getType();
		int price = roomType.getPrice();
		int peoplenum = roomType.getPeoplenum();
		int number = roomType.getNumber();
		
		Object[] parameters = {typeid, type, price, peoplenum, number,id};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<RoomType> Paging(int currentPage, int pageSize) {
		String sql = "SELECT * FROM `roomtype` LIMIT ?,?";//（页数-1）*页容量，页容量
		int index = (currentPage-1)*pageSize;
		
		Object[] parameters = {index,pageSize};
		ResultSet rs = query(sql, parameters);
		List<RoomType> list = new ArrayList<RoomType>();
		try {
			while(rs.next()) {
				int typeid = rs.getInt("typeid");
				String type = rs.getString("type");
				int price = rs.getInt("price");
				int peoplenum = rs.getInt("peoplenum");
				int number = rs.getInt("number");
				RoomType roomtype = new RoomType(typeid, type, price, peoplenum, number);
				list.add(roomtype);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getTotleNum() {
		String sql = "SELECT * FROM `roomtype`";
		Object[] parameters = {};
		ResultSet rs = query(sql, parameters);
		List<RoomType> list = new ArrayList<RoomType>();
		try {
			while(rs.next()) {
				int typeid = rs.getInt("typeid");
				String type = rs.getString("type");
				int price = rs.getInt("price");
				int peoplenum = rs.getInt("peoplenum");
				int number = rs.getInt("number");
				RoomType roomtype = new RoomType(typeid, type, price, peoplenum, number);
				list.add(roomtype);
			}
			int totle = list.size();
			return totle;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		RoomTypeDaoImpl r = new RoomTypeDaoImpl();
//		RoomType room = new RoomType(4, "情侣间", 350, 2, 1);
//		r.add(room);
		r.queryById(4);
	}

}
