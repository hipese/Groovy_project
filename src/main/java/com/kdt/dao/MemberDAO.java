package com.kdt.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession db;
	
	public MemberDTO getprofile(String id) {
		return db.selectOne("Member.selectprofile",id);
	}
}
