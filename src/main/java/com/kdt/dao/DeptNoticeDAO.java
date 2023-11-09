package com.kdt.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptNoticeDAO {
	
	@Autowired
	private SqlSession db;
	
	public boolean selectIsExcutives(String id) {
		return db.selectOne("Department.selectIsExcutives",id);
	}

}
