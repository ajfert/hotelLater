package com.bdqn.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bdqn.dao.EmjurDao;
import com.bdqn.pojo.Emjur;
import com.bdqn.util.EmjurMess;
import com.bdqn.util.MybatisUtil;
import com.bdqn.util.Page;

public class EmjurService {
	private EmjurDao mapper;
	
	public void getMapper() {
		SqlSession session = MybatisUtil.getSqlSession();
		mapper = session.getMapper(EmjurDao.class);
	}
	
	public List<Emjur> queryById(int id){
		getMapper();
		return mapper.queryById(id);
	}
	
	public Page<EmjurMess> getMess(int eid,int currentPage,int pageSize){
		getMapper();
		int first = (currentPage-1)*pageSize;
		List<EmjurMess> list = mapper.getMess(eid,first,pageSize);
		int totle = mapper.getMess(eid,0,0).size();
		int totlePage = totle%pageSize==0?totle/pageSize:totle/pageSize+1;
		Page<EmjurMess> page = new Page<EmjurMess>(currentPage, totlePage, totle, pageSize, list);
		return page;
	}
	
	public boolean delById(int ejid) {
		getMapper();
		mapper.delById(ejid);
		return true;
	}
	
	public boolean add(int eid,String jname) {
		getMapper();
		mapper.add(eid, jname);
		return true;
	}
	public static void main(String[] args) {
		EmjurService es = new EmjurService();
//		List<Emjur> list = es.queryById(1001);
//		System.out.println(list);
		
		Page<EmjurMess> page = es.getMess(1001,1,10);
		//System.out.println(page);
		
		es.delById(27);
		Page<EmjurMess> page1 = es.getMess(1001,1,10);
		//es.add(1004, "房间管理");
	}
}
