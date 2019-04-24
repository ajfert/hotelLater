package com.bdqn.dao;

import java.util.List;

import com.bdqn.pojo.Comment;

public interface CommentDao {
	public Comment queryById(int cid);
	public boolean add(Comment comment);
	public boolean deletById(int cid);
	public boolean updateById(int id,Comment comment);
	public List<Comment> Paging(int currentPage,int pageSize,String type);
	public int getTotleNum();
}
