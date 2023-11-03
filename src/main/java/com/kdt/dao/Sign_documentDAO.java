package com.kdt.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.Sign_documentDTO;

@Repository
public class Sign_documentDAO {
	@Autowired
	private SqlSession db;
	
	public int insert(Sign_documentDTO dto) {
		return db.insert("Sign_document.insert",dto);
	}
}
