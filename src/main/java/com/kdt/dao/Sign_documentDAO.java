package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.Sign_documentDTO;

@Repository
public class Sign_documentDAO {
	@Autowired
	private SqlSession db;
	
	public int insert(Sign_documentDTO dto) {
		db.insert("Sign_document.insert",dto);
		return dto.getSeq();
	}
	
	public List<Sign_documentDTO> selectProgress(String id) {
		return db.selectList("Sign_document.selectProgress", id);
	}
	
	public List<Sign_documentDTO> selectComplete(String id) {
		return db.selectList("Sign_document.selectComplete", id);
	}
	
	public List<Sign_documentDTO> selectWait(String id) {
		return db.selectList("Sign_document.selectWait", id);
	}
	
	public Sign_documentDTO selectBySeq(int seq) {
		return db.selectOne("Sign_document.selectBySeq", seq);
	}
	
	public int accept(int seq) {
		return db.update("Sign_document.accept", seq);
	}
	
	public int reject(int seq) {
		return db.update("Sign_document.reject", seq);
	}
	
}
