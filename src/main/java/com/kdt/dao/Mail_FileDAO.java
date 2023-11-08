package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.Mail_FileDTO;

@Repository
public class Mail_FileDAO {

	@Autowired
	private SqlSession db;
	
	public int insert(Mail_FileDTO dto) {
		return db.insert("Mail_file.insert", dto);
	}

	public List<Mail_FileDTO> selectBySeq(int parent_seq) {
		return db.selectList("Mail_file.selectBySeq", parent_seq);
	}
}
