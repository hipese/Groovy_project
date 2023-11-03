package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession db;

	public int insertBoard(BoardDTO dto) {
		return db.insert("Boards.insert", dto);
	}
	
	public List<BoardDTO>selectBoardAll(){ 
		return db.selectList("Boards.selectAll");
	}
	
	public BoardDTO selectBoardBySeq(int seq){ 
		return db.selectOne("Boards.selectBySeq",seq);
	}
	
	public int deleteBoard(Integer seq) {
		return db.delete("Boards.delete",seq);
	}
	
	public int updateBoard(BoardDTO dto) {
		return db.update("Board.update",dto);
	}
	
}
