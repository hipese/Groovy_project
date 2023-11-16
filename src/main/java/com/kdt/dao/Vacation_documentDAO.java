package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.Sign_documentDTO;
import com.kdt.dto.Vacation_documentDTO;

@Repository
public class Vacation_documentDAO {
	@Autowired
	private SqlSession db;
	
	public int insert(Vacation_documentDTO dto) {
		db.insert("Vacation_document.insert", dto);
		return dto.getSeq();
	}
	
	public List<Vacation_documentDTO> selectVacationComplete(String id) {
		return db.selectList("Vacation_document.selectVacationComplete", id);
	}
	
	public List<Vacation_documentDTO> selectVacationWait(String id) {
		return db.selectList("Vacation_document.selectVacationWait", id);
	}
	
	public List<Vacation_documentDTO> selectVacationProgress(String id) {
		return db.selectList("Vacation_document.selectVacationProgress", id);
	}
	
	public Vacation_documentDTO selectBySeq(int seq) {
		return db.selectOne("Vacation_document.selectBySeq", seq);
	}

	public int accept(Vacation_documentDTO dto) {
		return db.update("Vacation_document.accept", dto);
	}

	public int reject(Vacation_documentDTO dto) {
		return db.update("Vacation_document.reject", dto);
	}
}
