package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.CommentDao;
import com.bdqn.pojo.Comment;

public class CommentDaoImpl extends BaseDao implements CommentDao{

	@Override
	public Comment queryById(int cid) {
		String sql = "SELECT * FROM `comment` WHERE cid=?";
		Object[] parameters = {cid};
		ResultSet rs = query(sql, parameters);
		Comment comment = null;
		try {
			while(rs.next()) {
				int uid = rs.getInt("uid");
				String content = rs.getString("content");
				Date ctime = rs.getTimestamp("ctime");
				
				comment = new Comment(cid, uid, content, ctime);
			}
			return comment;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Comment comment) {
		String sql = "INSERT INTO `comment`(uid,content,ctime) VALUES(?,?,?)";
		int uid = comment.getUid();
		String content = comment.getContent();
		Date ctime = comment.getCtime();
		
		
		Object[] parameters = {uid,content, ctime};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deletById(int cid) {
		String sql = "DELETE FROM `comment` WHERE cid=?";
		Object[] parameters = {cid};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateById(int id, Comment comment) {
		String sql = "UPDATE `comment` SET cid=?,uid=?,content=?,ctime=? WHERE cid=?";
		int cid = comment.getCid();
		int uid = comment.getUid();
		String content = comment.getContent();
		Date ctime = comment.getCtime();
		
		
		Object[] parameters = {cid,uid,content, ctime,id};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Comment> Paging(int currentPage, int pageSize,String type) {
		String sql = null;
		int index = (currentPage-1)*pageSize;
		if(type.equals("分页")) {
			sql = "SELECT * FROM `comment` LIMIT ?,?";//（页数-1）*页容量，页容量
			
		}else if(type.equals("最新")) {
			sql = "SELECT * FROM `comment` ORDER BY ctime DESC LIMIT ?,?";
		}
		Object[] parameters = {index,pageSize};
		ResultSet rs = query(sql, parameters);
		List<Comment> list = new ArrayList<Comment>();
		try {
			while(rs.next()) {
				int cid = rs.getInt("cid");
				int uid = rs.getInt("uid");
				String content = rs.getString("content");
				Date ctime = rs.getTimestamp("ctime");
				
				Comment comment = new Comment(cid, uid, content, ctime);
				list.add(comment);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getTotleNum() {
		String sql = "SELECT * FROM `comment`";
		Object[] parameters = {};
		ResultSet rs = query(sql, parameters);
		List<Comment> list = new ArrayList<Comment>();
		try {
			while(rs.next()) {
				int cid = rs.getInt("cid");
				int uid = rs.getInt("uid");
				String content = rs.getString("content");
				Date ctime = rs.getTimestamp("ctime");
				
				Comment comment = new Comment(cid, uid, content, ctime);
				list.add(comment);
			}
			return list.size();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
