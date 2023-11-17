package com.kdt.dao;

import java.util.List;

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

	public List<Sign_filesDTO> selectBySeq(int parent_seq) {
		return db.selectList("Sign_files.selectBySeq", parent_seq);
	}
	
	public List<Sign_filesDTO> documentInto_filesBySeq(int parent_seq) {
		return db.selectList("Sign_files.selectBySeq", parent_seq);
	}
	
}
