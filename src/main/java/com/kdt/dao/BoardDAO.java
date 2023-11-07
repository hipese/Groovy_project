package com.kdt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public BoardDTO selectBoardBySeq(int seq){ 
		return db.selectOne("Boards.selectBySeq",seq);
	}
	
	public List<BoardDTO>selectBoardRecent(){ 
		return db.selectList("Boards.selectRecent");
	}

	public List<BoardDTO>selectBoardAllCom(){ 
		return db.selectList("Boards.selectAllCom");
	}
	
	public List<BoardDTO>selectBoardAllComFree(){ 
		return db.selectList("Boards.selectAllComFree");
	}
	
	public List<BoardDTO>selectBoardAllDept(){ 
		return db.selectList("Boards.selectAllDept");
	}

	public List<BoardDTO>selectBoardAllDeptFree(){ 
		return db.selectList("Boards.selectAllDeptFree");
	}

	public int deleteBoard(Integer seq) {
		return db.delete("Boards.delete",seq);
	}
	
	public int updateViewCount(Integer seq, Integer view_count) {
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("seq", seq);
	    paramMap.put("view_count", view_count);
	    return db.update("Boards.updateViewCount", paramMap);
	}

	public int updateBoard(BoardDTO dto) {
		return db.update("Board.update",dto);
	}

}
