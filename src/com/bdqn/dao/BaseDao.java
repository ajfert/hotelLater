package com.bdqn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//获得链接
	public void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "1234");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//查
	public ResultSet query(String sql,Object[] parameters) {
		getConnection();
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < parameters.length; i++) {
				ps.setObject(i+1, parameters[i]);
			}
			rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//增删改
	public int Update(String sql,Object[] parameters) {
		getConnection();
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < parameters.length; i++) {
				ps.setObject(i+1, parameters[i]);
				
			}
			int i = ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
