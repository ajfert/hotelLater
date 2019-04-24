package com.bdqn.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bdqn.dao.impl.CommentDaoImpl;
import com.bdqn.dao.impl.UserDaoImpl;
import com.bdqn.pojo.Comment;
import com.bdqn.pojo.User;
import com.bdqn.util.NewComment;
import com.bdqn.util.Page;

public class CommentService {
	CommentDaoImpl c = new CommentDaoImpl();
	//分页
	public Page<NewComment> paging(int currentPage,int pageSize) {
		List<Comment> list = c.Paging(currentPage, pageSize,"分页");
		List<NewComment> newcList = new ArrayList<NewComment>();
		for(Comment comm :list) {
			int cid = comm.getCid();
			String content = comm.getContent();
			Date ctime = comm.getCtime();
			
			int uid = comm.getUid();
			UserDaoImpl udi = new UserDaoImpl();
			User user = udi.queryById(uid);
			String uname = user.getUname();
			String upicture = user.getUpicture();
			NewComment newcomment = new NewComment(cid, content, ctime, uname, upicture);
			newcList.add(newcomment);
		}
		
		int totle = c.getTotleNum();
		int totlePage = totle%pageSize==0?totle/pageSize:totle/pageSize+1;
		Page<NewComment> page = new Page<NewComment>(currentPage, totlePage, totle, pageSize, newcList);
		return page;
	}
	//查最新几条
	public List<NewComment> selectNew(int currentPage,int pageSize) {
		List<Comment> list = c.Paging(currentPage, pageSize,"最新");
		List<NewComment> newcList = new ArrayList<NewComment>();
		for(Comment comm :list) {
			int cid = comm.getCid();
			String content = comm.getContent();
			Date ctime = comm.getCtime();
			
			int uid = comm.getUid();
			UserDaoImpl udi = new UserDaoImpl();
			User user = udi.queryById(uid);
			String uname = user.getUname();
			String upicture = user.getUpicture();
			NewComment newcomment = new NewComment(cid, content, ctime, uname, upicture);
			newcList.add(newcomment);
		}
		
		return newcList;
	}
	public Comment queryById(int cid) {
		return c.queryById(cid);
	}
	public boolean add(Comment comment) {
		return c.add(comment);
	}
	public boolean deletById(int cid) {
		return c.deletById(cid);
	}
	public boolean updateById(int id,Comment comment) {
		return c.updateById(id, comment);
	}
	
	public static void main(String[] args) {
		CommentService cs = new CommentService();
		List<NewComment> selectNew = cs.selectNew(1, 5);
		for(NewComment n: selectNew) {
			System.out.println(n.getCid()+n.getContent()+n.getUname()+n.getUpicture()+n.getCtime());
			
		}
				
	}
}
