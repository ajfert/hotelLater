package com.bdqn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.pojo.Employee;

public interface EmployeeDao {
	public Employee queryById(int eid);
	public boolean add(Employee employee);
	public boolean deletById(int eid);
	public boolean updateById(int id,Employee employee);
	public List<Employee> Paging(int currentPage,int pageSize);
	public List<Employee> getTotle();
	
	public List<Employee> check(@Param("eid")String eid,@Param("ename")String ename,
			@Param("jobname")String jobname,@Param("first")int first,
			@Param("size")int size);
}
