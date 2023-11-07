package com.kdt.dao;

import java.util.Map;

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
	
	public int updateImage(String id, Map<String, Object> params) {
		System.out.println(params);
		return db.update("Member.ImageChange",params);
	}
}
