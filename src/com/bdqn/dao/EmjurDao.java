package com.bdqn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.pojo.Emjur;
import com.bdqn.util.EmjurMess;

public interface EmjurDao {
	public List<Emjur> queryById(@Param("id")int id);
	public List<EmjurMess> getMess(@Param("eid")int eid,@Param("first")int first,@Param("size")int size);
	public void delById(@Param("ejid")int ejid);
	public void add(@Param("eid")int eid,@Param("jname")String jname);
}
