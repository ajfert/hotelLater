package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.RoomDao;
import com.bdqn.pojo.Room;

public class RoomDaoImpl extends BaseDao implements RoomDao{

	@Override
	public Room queryById(int rid) {
		String sql = "SELECT rid,`type`,price,peoplenum,`status`,remark FROM room INNER JOIN roomtype ON room.`typeid`=roomtype.`typeid` HAVING rid=?";
		Object[] parameters = {rid};
		ResultSet rs = query(sql, parameters);
		Room room = null;
		try {
			while(rs.next()) {
				String type = rs.getString("type");
				int price = rs.getInt("price");
				String peoplenum = rs.getString("peoplenum");
				String status = rs.getString("status");
				String remark = rs.getString("remark");
				room = new Room(rid, type, price, peoplenum, status, remark);
			}
			return room;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Room> Paging(int currentPage, int pageSize) {
		String sql = "SELECT rid,`type`,price,peoplenum,`status`,remark FROM room INNER JOIN roomtype ON room.`typeid`=roomtype.`typeid` LIMIT ?,?";//（页数-1）*页容量，页容量
		int index = (currentPage-1)*pageSize;
		
		Object[] parameters = {index,pageSize};
		ResultSet rs = query(sql, parameters);
		List<Room> list = new ArrayList<Room>();
		try {
			while(rs.next()) {
				int rid = rs.getInt("rid");
				String type = rs.getString("type");
				int price = rs.getInt("price");
				String peoplenum = rs.getString("peoplenum");
				String status = rs.getString("status");
				String remark = rs.getString("remark");
				Room room = new Room(rid, type, price, peoplenum, status, remark);
				list.add(room);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getTotleNum() {
		String sql = "SELECT rid,`type`,price,peoplenum,`status`,remark FROM room INNER JOIN roomtype ON room.`typeid`=roomtype.`typeid`";
		Object[] parameters = {};
		ResultSet rs = query(sql, parameters);
		List<Room> list = new ArrayList<Room>();
		try {
			while(rs.next()) {
				int rid = rs.getInt("rid");
				String type = rs.getString("type");
				int price = rs.getInt("price");
				String peoplenum = rs.getString("peoplenum");
				String status = rs.getString("status");
				String remark = rs.getString("remark");
				Room room = new Room(rid, type, price, peoplenum, status, remark);
				list.add(room);
			}
			return list.size();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean add(Room room) {
		
		String type = room.getType();//通过房间类型得到类型编号，因为类型是在另一个表中
		int typeId = getTypeId(type);
		if(typeId>0) {
			int rid = room.getRid();
			int typeid = typeId;
			String status = room.getStatus();
			String remark = room.getRemark();
			
			Object[] parameters = {rid,typeid,status,remark};
			String sql = "INSERT INTO room VALUES(?,?,?,?)";
			int i = Update(sql, parameters);
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	//通过房间类型得到类型编号
	public int getTypeId(String type) {
		String sql = "SELECT typeid FROM roomtype WHERE `type`=?";
		Object[] parameters = {type};
		ResultSet rs = query(sql, parameters);
		int typeid =0;
		try {
			while(rs.next()) {
				typeid = rs.getInt("typeid");
			}
			return typeid;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean deletById(int rid) {
		String sql = "DELETE FROM room WHERE rid=?";
		Object[] parameters = {rid};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateById(int id, Room room) {
		String sql = "UPDATE room SET rid=?,typeid=?,status=?,remark=? WHERE rid=?";
		String type = room.getType();
		int typeId = getTypeId(type);
		if(typeId>0) {
			int rid = room.getRid();
			int typeid = typeId;
			String status = room.getStatus();
			String remark = room.getRemark();
			
			Object[] parameters = {rid,typeid,status,remark,id};
			int i = Update(sql, parameters);
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	@Override
	public List<Room> queryLike(String id, String qtype, int min,int max,int currentPage, int pageSize,
			String todo) {
		ResultSet rs =null;
		if(todo.equals("分页")) {
			String sql = "SELECT rid,`type`,price,peoplenum,`status`,remark FROM room INNER JOIN roomtype ON room.`typeid`=roomtype.`typeid` WHERE rid LIKE CONCAT('%',?,'%') AND `type` LIKE CONCAT('%',?,'%') AND price BETWEEN ? AND ? LIMIT ?,?";
			
			int index = (currentPage-1)*pageSize;
			
			Object[] parameters = {id,qtype,min,max,index,pageSize};
			rs = query(sql, parameters);
		}else if(todo.equals("总量")) {
			String sql = "SELECT rid,`type`,price,peoplenum,`status`,remark FROM room INNER JOIN roomtype ON room.`typeid`=roomtype.`typeid` WHERE rid LIKE CONCAT('%',?,'%') AND `type` LIKE CONCAT('%',?,'%') AND price BETWEEN ? AND ? ";
			Object[] parameters = {id,qtype,min,max};
			rs = query(sql, parameters);
		}
		
		List<Room> list = new ArrayList<Room>();
		try {
			while(rs.next()) {
				int rid = rs.getInt("rid");
				String type = rs.getString("type");
				int price = rs.getInt("price");
				String peoplenum = rs.getString("peoplenum");
				String status = rs.getString("status");
				String remark = rs.getString("remark");
				Room room = new Room(rid, type, price, peoplenum, status, remark);
				list.add(room);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		RoomDaoImpl r = new RoomDaoImpl();
		//Room room = r.queryById(1);
		//System.out.println(room.getPrice());
		//Room room = new Room(7, "豪华间", 122, null, "已住", "新备注");
//		r.add(room);
		//r.deletById(7);
		//r.updateById(6, room);
		//int i = r.getTotleNum();
		//System.out.println(i);
		List<Room> list = r.queryLike("2", "", 0, 200, 1, 3, "总量");
		for(Room room:list) {
			System.out.println(room.getRid()+room.getType());
		}
	}

	

	

}
