package com.kdt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.Sign_documentDTO;

@Repository
public class Sign_documentDAO {
	@Autowired
	private SqlSession db;

	public int insert(Sign_documentDTO dto) {
		db.insert("Sign_document.insert", dto);
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
	
	public List<Sign_documentDTO> selectReview(String id) {
		return db.selectList("Sign_document.selectReview", id);
	}
	
	
	public List<Sign_documentDTO> selectVacationComplete(String id) {
		return db.selectList("Sign_document.selectVacationComplete", id);
	}
	
	public List<Sign_documentDTO> selectVacationWait(String id) {
		return db.selectList("Sign_document.selectVacationWait", id);
	}

	public Sign_documentDTO selectBySeq(int seq) {
		return db.selectOne("Sign_document.selectBySeq", seq);
	}
	
	public Sign_documentDTO documentIntoBySeq(int seq) {
		return db.selectOne("Sign_document.selectBySeq", seq);
	}
	
	public int accept(Sign_documentDTO dto) {
		return db.update("Sign_document.accept", dto);
	}

	public int reject(Sign_documentDTO dto) {
		return db.update("Sign_document.reject", dto);
	}

}
