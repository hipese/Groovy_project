package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.Vacation_filesDTO;

@Repository
public class Vacation_filesDAO {

	@Autowired
	private SqlSession db;

	public int insert(Vacation_filesDTO dto) {
		return db.insert("Vacation_files.insert", dto);
	}

	public List<Vacation_filesDTO> selectBySeq(int parent_seq) {
		return db.selectList("Vacation_files.selectBySeq", parent_seq);
	}
}
