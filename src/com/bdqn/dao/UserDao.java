package com.bdqn.dao;

import java.util.List;

import com.bdqn.pojo.User;

public interface UserDao {
	public User queryById(int uid);
	public boolean add(User user);
	public boolean deletById(int uid);
	public boolean updateById(int id,User user);
	public List<User> Paging(int currentPage,int pageSize);
	public int getTotleNum();
	public List<User> queryLike(String name,String truename,String email,int currentPage,int pageSize,String type);
	//改头像
	public boolean changePicById(int uid,String pictureName);
}
