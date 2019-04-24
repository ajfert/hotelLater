package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.EmployeeDao;
import com.bdqn.pojo.Employee;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao{

	@Override
	public Employee queryById(int eid) {
		String sql = "SELECT eid,ename,epassword,jobname,age,email,phone,remark FROM employee INNER JOIN job ON employee.`jobid`=job.`jobid` HAVING eid=?";
		Object[] parameters = {eid};
		ResultSet rs = query(sql, parameters);
		Employee employee = null;
		try {
			while(rs.next()) {
				String ename = rs.getString("ename");
				String epassword = rs.getString("epassword");
				String jobname = rs.getString("jobname");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String remark = rs.getString("remark");
				employee = new Employee(eid, ename,epassword, jobname, age, email, phone, remark);
			}
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Employee> Paging(int currentPage, int pageSize) {
		String sql = "SELECT eid,ename,epassword,jobname,age,email,phone,remark FROM employee INNER JOIN job ON employee.`jobid`=job.`jobid` HAVING eid<>1 LIMIT ?,?";
		int index = (currentPage-1)*pageSize;
		
		Object[] parameters = {index,pageSize};
		ResultSet rs = query(sql, parameters);
		List<Employee> list = new ArrayList<>();
		
		try {
			while(rs.next()) {
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				String epassword = rs.getString("epassword");
				String jobname = rs.getString("jobname");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String remark = rs.getString("remark");
				Employee employee = new Employee(eid, ename,epassword, jobname, age, email, phone, remark);
				list.add(employee);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Employee> getTotle() {
		String sql = "SELECT eid,ename,epassword,jobname,age,email,phone,remark FROM employee INNER JOIN job ON employee.`jobid`=job.`jobid`";
		Object[] parameters = {};
		ResultSet rs = query(sql, parameters);
		List<Employee> list = new ArrayList<>();
		try {
			while(rs.next()) {
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				String epassword = rs.getString("epassword");
				String jobname = rs.getString("jobname");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String remark = rs.getString("remark");
				Employee employee = new Employee(eid, ename,epassword, jobname, age, email, phone, remark);
				list.add(employee);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean add(Employee employee) {
		String jobname = employee.getJobname();
		int jobid = getJobId(jobname);
		if(jobid>0) {
			int eid = employee.getEid();
			String ename = employee.getEname();
			String epassword = employee.getEpassword();
			
			int age = employee.getAge();
			String email = employee.getEmail();
			String phone = employee.getPhone();
			String remark = employee.getRemark();
			
			Object[] parameters = {eid,ename,epassword,jobid,age,email,phone,remark};
			String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?,?,?)";
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

	//通过工作名称得到工作id
	public int getJobId(String jobname) {
		String sql = "SELECT jobid FROM job WHERE jobname=?";
		Object[] parameters = {jobname};
		ResultSet rs = query(sql, parameters);
		int jobid =0;
		try {
			while(rs.next()) {
				jobid = rs.getInt("jobid");
			}
			return jobid;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
		
	@Override
	public boolean deletById(int eid) {
		String sql = "DELETE FROM employee WHERE eid=?";
		Object[] parameters = {eid};
		int i = Update(sql, parameters);
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateById(int id, Employee employee) {
		String jobname = employee.getJobname();
		int jobid = getJobId(jobname);
		if(jobid>0) {
			int eid = employee.getEid();
			String ename = employee.getEname();
			String epassword = employee.getEpassword();
			
			int age = employee.getAge();
			String email = employee.getEmail();
			String phone = employee.getPhone();
			String remark = employee.getRemark();
			
			Object[] parameters = {eid,ename,epassword,jobid,age,email,phone,remark,id};
			String sql = "UPDATE employee SET eid=?,ename=?,epassword=?,jobid=?,age=?,email=?,phone=?,remark=? WHERE eid=?";
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

	@Override
	public List<Employee> check(String eid, String ename, String jobname, int first, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
