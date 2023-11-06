package com.kdt.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.Sign_filesDTO;

@Repository
public class Sign_filesDAO {
	
	@Autowired
	private SqlSession db;
	
	public int insert(Sign_filesDTO dto) {
		return db.insert("Sign_files.insert", dto);
	}

}
