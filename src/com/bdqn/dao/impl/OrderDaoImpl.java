package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.OrderDao;
import com.bdqn.pojo.Order;
import com.bdqn.util.Week;

public class OrderDaoImpl extends BaseDao implements OrderDao{

	@Override
	public Order queryById(int oid) {
		String sql = "SELECT * FROM `order` WHERE oid=?";
		Object[] parameters = {oid};
		ResultSet rs = query(sql, parameters);
		Order order = null;
		try {
			while(rs.next()) {
				int rid = rs.getInt("rid");
				int uid = rs.getInt("uid");
				int eid = rs.getInt("eid");
				Date starttime = rs.getTimestamp("starttime");
				Date endtime = rs.getTimestamp("endtime");
				int eprice = rs.getInt("eprice");
				String status = rs.getString("status");
				Date booktime = rs.getTimestamp("booktime");
				String remark = rs.getString("remark");
				order = new Order(oid, rid, uid, eid, starttime, endtime,eprice, status, booktime, remark);
			}
			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Order> Paging(int currentPage, int pageSize) {
		String sql = "SELECT * FROM `order` ORDER BY oid DESC LIMIT ?,?";//（页数-1）*页容量，页容量
		int index = (currentPage-1)*pageSize;
		
		Object[] parameters = {index,pageSize};
		ResultSet rs = query(sql, parameters);
		List<Order> list = new ArrayList<Order>();
		try {
			while(rs.next()) {
				int oid = rs.getInt("oid");
				int rid = rs.getInt("rid");
				int uid = rs.getInt("uid");
				int eid = rs.getInt("eid");
				Date starttime = rs.getTimestamp("starttime");
				Date endtime = rs.getTimestamp("endtime");
				int eprice = rs.getInt("eprice");
				String status = rs.getString("status");
				Date booktime = rs.getTimestamp("booktime");
				String remark = rs.getString("remark");
				Order order = new Order(oid, rid, uid, eid, starttime, endtime,eprice, status,booktime, remark);
				list.add(order);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> getTotle() {
		String sql = "SELECT * FROM `order`";
		Object[] parameters = {};
		ResultSet rs = query(sql, parameters);
		List<Order> list = new ArrayList<Order>();
		try {
			while(rs.next()) {
				int oid = rs.getInt("oid");
				int rid = rs.getInt("rid");
				int uid = rs.getInt("uid");
				int eid = rs.getInt("eid");
				Date starttime = rs.getTimestamp("starttime");
				Date endtime = rs.getTimestamp("endtime");
				int eprice = rs.getInt("eprice");
				String status = rs.getString("status");
				Date booktime = rs.getTimestamp("booktime");
				String remark = rs.getString("remark");
				Order order = new Order(oid, rid, uid, eid, starttime, endtime, eprice, status,booktime, remark);
				list.add(order);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Order order) {
		String sql = "INSERT INTO `order` VALUES(?,?,?,?,?,?,?,?,?)";
		int oid = order.getOid();
		int rid = order.getRid();
		int uid = order.getUid();
		int eid = order.getEid();
		Date starttime = order.getStarttime();
		Date endtime = order.getEndtime();
		int eprice = order.getEprice();
		String status = order.getStatus();
		Date booktime = order.getBooktime();
		String remark = order.getRemark();
		
		
		Object[] parameters = {oid, rid, uid, eid, starttime, endtime,eprice, status,booktime, remark};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deletById(int oid) {
		String sql = "DELETE FROM `order` WHERE oid=?";
		Object[] parameters = {oid};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateById(int id, Order order) {
		String sql = "UPDATE `order` SET oid=?,rid=?,uid=?,eid=?,starttime=?,endtime=?,eprice=?,status=?,booktime=?,remark=? WHERE oid=?";
		int oid = order.getOid();
		int rid = order.getRid();
		int uid = order.getUid();
		int eid = order.getEid();
		Date starttime = order.getStarttime();
		Date endtime = order.getEndtime();
		int eprice = order.getEprice();
		String status = order.getStatus();
		Date booktime = order.getBooktime();
		String remark = order.getRemark();
		
		
		Object[] parameters = {oid, rid, uid, eid, starttime, endtime,eprice, status, booktime, remark,id};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int getAllprice() {
		String sql = "SELECT eprice FROM `order` WHERE `status`='完成'";
		Object[] parameters = {};
		ResultSet rs = query(sql, parameters);
		int allprice = 0;
		try {
			while(rs.next()) {
				
				int eprice = rs.getInt("eprice");
				allprice = allprice+eprice;
			}
			return allprice;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int getPriceFromMorW(int mw,String type) {
		String sql = "SELECT oid,starttime,endtime,eprice,status,booktime FROM `order` WHERE `status`='完成'";
		Object[] parameters = {};
		ResultSet rs = query(sql, parameters);
		List<Order> list = new ArrayList<Order>();
		int price = 0;
		try {
			while(rs.next()) {
				int oid = rs.getInt("oid");
				Date starttime = rs.getTimestamp("starttime");
				Date endtime = rs.getTimestamp("endtime");
				int eprice = rs.getInt("eprice");
				String status = rs.getString("status");
				Date booktime = rs.getTimestamp("booktime");
				Order order = new Order(oid, starttime, endtime, eprice, status,booktime);
				list.add(order);
			}
			if(type.equals("月")) {
				for (Order order:list) {
					Date end = order.getEndtime();
					Calendar cal = Calendar.getInstance();
					cal.setTime(end);
					int m = cal.get(Calendar.MONTH)+1;
					if(m==mw) {
						price = price + order.getEprice();
					}
				}
			}else if(type.equals("星期")) {
				for (Order order:list) {
					Date end = order.getEndtime();
					Calendar cal = Calendar.getInstance();
					cal.setTime(end);
					int m = cal.get(Calendar.DAY_OF_WEEK);
					if(m==mw) {
						price = price + order.getEprice();
					}
				}
			}
			return price;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	@Override
	public List<Order> getalldata() {
		String sql = "SELECT * FROM `order`";
		Object[] parameters = {};
		ResultSet rs = query(sql, parameters);
		List<Order> list = new ArrayList<Order>();
		try {
			while(rs.next()) {
				int oid = rs.getInt("oid");
				int rid = rs.getInt("rid");
				int uid = rs.getInt("uid");
				int eid = rs.getInt("eid");
				Date starttime = rs.getTimestamp("starttime");
				Date endtime = rs.getTimestamp("endtime");
				int eprice = rs.getInt("eprice");
				String status = rs.getString("status");
				Date booktime = rs.getTimestamp("booktime");
				String remark = rs.getString("remark");
				Order order = new Order(oid, rid, uid, eid, starttime, endtime, eprice, status,booktime, remark);
				list.add(order);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		OrderDaoImpl o = new OrderDaoImpl();
		//Order order = new Order(3, 1, 1, 1, new Date(), new Date(), "已预定", "jfsf");
//		o.add(order);
//		Order order = o.queryById(3);
//		System.out.println(order.getStarttime());
//		if(o.deletById(3)) {
//			System.out.println(111);
//		}
		//int i = o.getAllprice();
		int i = o.getPriceFromMorW(7,"星期");
		System.out.println(i);
		
		
	}

	@Override
	public List<Order> check(Order order, String starttime, String endtime, String booktime, int first, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	


	
}
