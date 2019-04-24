package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.UserDao;
import com.bdqn.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao{
	
	@Override
	public User queryById(int uid) {
		String sql = "SELECT * FROM `user` WHERE uid=?";
		Object[] parameters = {uid};
		ResultSet rs = query(sql, parameters);
		User user = null;
		try {
			while(rs.next()) {
				String uname = rs.getString("uname");
				String ugender = rs.getString("ugender");
				String upassword = rs.getString("upassword");
				String uidentity = rs.getString("uidentity");
				String uemail = rs.getString("uemail");
				Date uborn = rs.getDate("uborn");
				String uphone = rs.getString("uphone");
				String utruename = rs.getString("utruename");
				String upicture = rs.getString("upicture");
				user = new User(uid, uname, ugender, upassword, uidentity, uemail, uborn, uphone, utruename,upicture);
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(User user) {
		String sql = "INSERT INTO `user` VALUES(?,?,?,?,?,?,?,?,?,?)";
		int uid = user.getUid();
		String uname = user.getUname();
		String ugender = user.getUgender();
		String upassword = user.getUpassword();
		String uidentity = user.getUidentity();
		String uemail = user.getUemail();
		Date uborn = user.getUborn();
		String uphone = user.getUphone();
		String utruename = user.getUtruename();
		String upicture = user.getUpicture();
		
		Object[] parameters = {uid,uname,utruename,ugender,upassword,uidentity,uemail,uborn,uphone,upicture};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deletById(int uid) {
		String sql = "DELETE FROM `user` WHERE uid=?";
		Object[] parameters = {uid};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateById(int id,User user) {
		String sql = "UPDATE `user` SET uid=?,uname=?,utruename=?,ugender=?,upassword=?,uidentity=?,uemail=?,uborn=?,uphone=?,upicture=? WHERE uid=?";
		
		int uid = user.getUid();
		String uname = user.getUname();
		String ugender = user.getUgender();
		String upassword = user.getUpassword();
		String uidentity = user.getUidentity();
		String uemail = user.getUemail();
		Date uborn = user.getUborn();
		String uphone = user.getUphone();
		String utruename = user.getUtruename();
		String upicture = user.getUpicture();
		
		
		Object[] parameters = {uid,uname,utruename,ugender,upassword,uidentity,uemail,uborn,uphone,upicture,id};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}
	//分页
	public List<User> Paging(int currentPage,int pageSize){
		String sql = "SELECT * FROM `user` LIMIT ?,?";//（页数-1）*页容量，页容量
		int index = (currentPage-1)*pageSize;
		
		Object[] parameters = {index,pageSize};
		ResultSet rs = query(sql, parameters);
		List<User> list = new ArrayList<User>();
		try {
			while(rs.next()) {
				User user = null;
				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String ugender = rs.getString("ugender");
				String upassword = rs.getString("upassword");
				String uidentity = rs.getString("uidentity");
				String uemail = rs.getString("uemail");
				Date uborn = rs.getDate("uborn");
				String uphone = rs.getString("uphone");
				String utruename = rs.getString("utruename");
				String upicture = rs.getString("upicture");
				user = new User(uid, uname, ugender, upassword, uidentity, uemail, uborn, uphone, utruename,upicture);
				list.add(user);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//数据总条数
	@Override
	public int getTotleNum() {
		String sql = "SELECT * FROM `user`";
		Object[] parameters = {};
		ResultSet rs = query(sql, parameters);
		List<User> list = new ArrayList<User>();
		try {
			while(rs.next()) {
				User user = null;
				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String ugender = rs.getString("ugender");
				String upassword = rs.getString("upassword");
				String uidentity = rs.getString("uidentity");
				String uemail = rs.getString("uemail");
				Date uborn = rs.getDate("uborn");
				String uphone = rs.getString("uphone");
				String utruename = rs.getString("utruename");
				String upicture = rs.getString("upicture");
				user = new User(uid, uname, ugender, upassword, uidentity, uemail, uborn, uphone, utruename,upicture);
				list.add(user);
			}
			int totle = list.size();
			return totle;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<User> queryLike(String name,String truename,String email,int currentPage,int pageSize,String type) {
		ResultSet rs =null;
		if(type.equals("分页")) {
			String sql = "SELECT * FROM `user` WHERE uname LIKE CONCAT('%',?,'%') AND utruename LIKE CONCAT('%',?,'%') AND uemail LIKE CONCAT('%',?,'%') LIMIT ?,?";
			
			int index = (currentPage-1)*pageSize;
			
			Object[] parameters = {name,truename,email,index,pageSize};
			rs = query(sql, parameters);
		}else if(type.equals("总量")) {
			String sql = "SELECT * FROM `user` WHERE uname LIKE CONCAT('%',?,'%') AND utruename LIKE CONCAT('%',?,'%') AND uemail LIKE CONCAT('%',?,'%')";
			Object[] parameters = {name,truename,email};
			rs = query(sql, parameters);
		}
		
		List<User> list = new ArrayList<User>();
		try {
			while(rs.next()) {
				User user = null;
				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String ugender = rs.getString("ugender");
				String upassword = rs.getString("upassword");
				String uidentity = rs.getString("uidentity");
				String uemail = rs.getString("uemail");
				Date uborn = rs.getDate("uborn");
				String uphone = rs.getString("uphone");
				String utruename = rs.getString("utruename");
				String upicture = rs.getString("upicture");
				user = new User(uid, uname, ugender, upassword, uidentity, uemail, uborn, uphone, utruename,upicture);
				list.add(user);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//改头像
	@Override
	public boolean changePicById(int uid, String pictureName) {
		String sql = "UPDATE `user` SET upicture=? WHERE uid=?";
		
		Object[] parameters = {pictureName,uid};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		UserDaoImpl u = new UserDaoImpl();
//		User user = u.queryById(1);
//		System.out.println(user.getUborn());
		//User user2 = new User(4, "找刘", "女", "4444", "4444", "4444", new Date(), "1239034903", "444","");
//		u.add(user2);
//		u.updateById(3, user2);
		//u.deletById(4);
		
		List<User> list = u.queryLike("天", "+", "+", 1, 3,"总量");
		
		for(User user:list) {
			System.out.println(user.getUname()+user.getUtruename()+user.getUemail());
		}
	}

	

	
}
