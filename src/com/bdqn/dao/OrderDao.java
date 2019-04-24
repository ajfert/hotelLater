package com.bdqn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.pojo.Order;

public interface OrderDao {
	public Order queryById(int oid);
	public boolean add(Order order);
	public boolean deletById(int oid);
	public boolean updateById(int id,Order order);
	public List<Order> Paging(int currentPage,int pageSize);
	public List<Order> getTotle();
	public int getAllprice();
	public int getPriceFromMorW(int mw,String type);
	public List<Order> getalldata();
	
	public List<Order> check(@Param("order")Order order,@Param("start")String starttime,
			@Param("end")String endtime,@Param("book")String booktime,
			@Param("first")int first,@Param("size")int size);
}
