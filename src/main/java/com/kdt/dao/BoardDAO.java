package com.kdt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.BoardDTO;
import com.kdt.dto.BoardWithFileDTO;
import com.kdt.dto.BoardWithMemberDTO;
import com.kdt.dto.DBoardWithDFileDTO;
import com.kdt.dto.DBoardWithMemberDTO;
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
	
	public BoardDTO selectUPdateBoardBySeq(int seq){ 
		return db.selectOne("Boards.selectUPdateBoardBySeq",seq);
	}
	
	public DeptBoardDTO selectUpdateDeptBySeq(int seq){ 
		return db.selectOne("Boards.selectUpdateDeptBySeq",seq);
	}
	
	public BoardWithFileDTO selectBoardBySeq(int seq){ 
		return db.selectOne("Boards.selectBySeq",seq);
	}
	
	public DBoardWithDFileDTO selectDeptBySeq(int seq){ 
		return db.selectOne("Boards.selectDeptBySeq",seq);
	}
	
	public List<BoardWithMemberDTO>selectBoardRecent(){ 
		return db.selectList("Boards.selectRecent");
	}
	
	public List<DBoardWithMemberDTO>selectDeptRecent(String dept){ 
		return db.selectList("Boards.selectDeptRecent",dept);
	}

	public List<BoardWithMemberDTO>selectBoardAllCom(){ 
		return db.selectList("Boards.selectAllCom");
	}
	
	public List<BoardWithMemberDTO>selectBoardAllComFree(){ 
		return db.selectList("Boards.selectAllComFree");
	}
	
	public List<DBoardWithMemberDTO>selectBoardAllDept(String dept){ 
		return db.selectList("Boards.selectAllDept",dept);
	}

	public List<DBoardWithMemberDTO>selectBoardAllDeptFree(String dept){ 
		return db.selectList("Boards.selectAllDeptFree",dept);
	}

	public int deleteBoard(Integer seq) {
		return db.delete("Boards.delete",seq);
	}
	
	public int deleteDept(Integer seq) {
		return db.delete("Boards.deleteDept",seq);
	}
	
	public int deleteAll(Integer parent_seq) {
		return db.delete("Reply.deleteAll",parent_seq);
	}
	
	public int deleteDeptAll(Integer parent_seq) {
		return db.delete("Reply.deleteDeptAll",parent_seq);
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
