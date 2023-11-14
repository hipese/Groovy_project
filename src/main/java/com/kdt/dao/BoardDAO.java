package com.kdt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.BoardDTO;
import com.kdt.dto.DeptBoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession db;

	public int insertBoard(BoardDTO dto) {
		return db.insert("Boards.insert", dto);
	}
	
	public int insertDept(DeptBoardDTO dto) {
		return db.insert("Boards.insertDept", dto);
	}
	
	public BoardDTO selectBoardBySeq(int seq){ 
		return db.selectOne("Boards.selectBySeq",seq);
	}
	
	public DeptBoardDTO selectDeptBySeq(int seq){ 
		return db.selectOne("Boards.selectDeptBySeq",seq);
	}
	
	public List<BoardDTO>selectBoardRecent(){ 
		return db.selectList("Boards.selectRecent");
	}
	
	public List<DeptBoardDTO>selectDeptRecent(){ 
		return db.selectList("Boards.selectDeptRecent");
	}

	public List<BoardDTO>selectBoardAllCom(){ 
		return db.selectList("Boards.selectAllCom");
	}
	
	public List<BoardDTO>selectBoardAllComFree(){ 
		return db.selectList("Boards.selectAllComFree");
	}
	
	public List<DeptBoardDTO>selectBoardAllDept(String dept){ 
		return db.selectList("Boards.selectAllDept",dept);
	}

	public List<DeptBoardDTO>selectBoardAllDeptFree(String dept){ 
		return db.selectList("Boards.selectAllDeptFree",dept);
	}

	public int deleteBoard(Integer seq) {
		return db.delete("Boards.delete",seq);
	}
	
	public int deleteDept(Integer seq) {
		return db.delete("Boards.deleteDept",seq);
	}
	
	public int updateBoard(BoardDTO dto) {
		return db.update("Boards.update",dto);
	}
	
	public int updateDept(DeptBoardDTO dto) {
		return db.update("Boards.updateDept",dto);
	}
	
	public int updateViewCount(Integer seq, Integer view_count) {
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("seq", seq);
	    paramMap.put("view_count", view_count);
	    return db.update("Boards.updateViewCount", paramMap);
	}
	
	public int updateDeptViewCount(Integer seq, Integer view_count) {
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("seq", seq);
	    paramMap.put("view_count", view_count);
	    return db.update("Boards.updateDeptViewCount", paramMap);
	}

}
