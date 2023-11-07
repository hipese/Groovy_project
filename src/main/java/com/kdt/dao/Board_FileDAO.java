package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.Board_FileDTO;

@Repository
public class Board_FileDAO {
	
	@Autowired
	private SqlSession db;
	
	public int insert(Board_FileDTO dto) {
		return db.insert("Board_file.insert", dto);
	}

	public List<Board_FileDTO> selectBySeq(int parent_seq) {
		return db.selectList("Board_file.selectBySeq", parent_seq);
	}

}
