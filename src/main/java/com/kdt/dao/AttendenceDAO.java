package com.kdt.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AttendenceDAO {
	
	@Autowired
	private SqlSession db;
	
	

}
