package com.bdqn.service;

import java.util.List;

import com.bdqn.dao.impl.UserDaoImpl;
import com.bdqn.pojo.User;
import com.bdqn.util.Page;

public class UserService {
	UserDaoImpl u = new UserDaoImpl();
	//改头像
	public boolean changePicById(int uid, String pictureName) {
		boolean b = u.changePicById(uid, pictureName);
		return b;
	}
	//分页
	public Page<User> paging(int currentPage,int pageSize) {
		List<User> list = u.Paging(currentPage, pageSize);
		int totle = u.getTotleNum();
		int totlePage = totle%pageSize==0?totle/pageSize:totle/pageSize+1;
		Page<User> page = new Page<User>(currentPage, totlePage, totle, pageSize, list);
		return page;
	}
	
	public Page<User> queryLike(String name,String truename,String email,int currentPage,int pageSize) {
		List<User> list = u.queryLike(name, truename, email, currentPage, pageSize,"分页");
		int totle = u.queryLike(name, truename, email, currentPage, pageSize, "总量").size();
		int totlePage = totle%pageSize==0?totle/pageSize:totle/pageSize+1;
		Page<User> page = new Page<User>(currentPage, totlePage, totle, pageSize, list);
		return page;
	}
	public User queryById(int uid) {
		return u.queryById(uid);
	}
	public boolean add(User user) {
		return u.add(user);
	}
	public boolean deletById(int uid) {
		return u.deletById(uid);
	}
	public boolean updateById(int id,User user) {
		return u.updateById(id, user);
	}
	public static void main(String[] args) {
		UserService u = new UserService();
		Page<User> page = u.paging(1, 1);
		System.out.println(page.getTotlePage());
	}
}
