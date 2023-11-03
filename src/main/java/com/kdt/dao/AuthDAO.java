package com.kdt.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.LoginDTO;

@Repository
public class AuthDAO {

	@Autowired
	private SqlSession db;
	
	public LoginDTO isMember(LoginDTO dto) {
		return db.selectOne("Auth.isMember", dto);
	}
}
