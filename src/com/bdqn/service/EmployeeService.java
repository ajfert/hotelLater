package com.bdqn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.bdqn.dao.EmployeeDao;
import com.bdqn.dao.impl.EmployeeDaoImpl;
import com.bdqn.pojo.Employee;
import com.bdqn.util.MybatisUtil;
import com.bdqn.util.Page;

public class EmployeeService {
	EmployeeDaoImpl e = new EmployeeDaoImpl();
	private static EmployeeDao mapper;
	
	static {
		SqlSession session = MybatisUtil.getSqlSession();
		mapper = session.getMapper(EmployeeDao.class);
	}
	
	public Page<Employee> check(String eid,String ename,String jobname,int currentPage,int pageSize){
		int first = (currentPage-1)*pageSize;
		
		List<Employee> list= mapper.check(eid, ename, jobname, first, pageSize);
		
		int totle = mapper.check(eid, ename, jobname, 0, 0).size();
		int totlePage = totle%pageSize==0?totle/pageSize:totle/pageSize+1;
		
		Page<Employee> page = new Page<Employee>(currentPage, totlePage, totlePage, pageSize, list);
		return page;
	}
	
	public Page<Employee> paging(int currentPage,int pageSize) {
		List<Employee> list = e.Paging(currentPage, pageSize);
		int totle = e.getTotle().size();
		int totlePage = totle%pageSize==0?totle/pageSize:totle/pageSize+1;
		Page<Employee> page = new Page<Employee>(currentPage, totlePage, totle, pageSize, list);
		return page;
	}
	public List<Employee> getTotle(){
		return e.getTotle();
	}
	public Employee queryById(int eid) {
		return e.queryById(eid);
	}
	public boolean add(Employee employee) {
		return e.add(employee);
	}
	public boolean deletById(int eid) {
		return e.deletById(eid);
	}
	public boolean updateById(int id,Employee employee) {
		return e.updateById(id, employee);
	}
	
	public static void main(String[] args) {
		EmployeeService es = new EmployeeService();
		Employee employee = es.queryById(1);
		System.out.println(employee.getEname());
	}
}
