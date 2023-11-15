package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.DReplyWithMemberDTO;
import com.kdt.dto.DeptReplyDTO;
import com.kdt.dto.ReplyDTO;
import com.kdt.dto.ReplyWithMemberDTO;

@Repository
public class ReplyDAO {

	@Autowired
	private SqlSession db;

	public int insert(ReplyDTO dto) {
		return db.insert("Reply.insert", dto);
	}

	public int insertDept(DeptReplyDTO dto) {
		return db.insert("Reply.insertDept", dto);
	}

	public List<ReplyWithMemberDTO> selectBySeq(int parent_seq){ 
		return db.selectList("Reply.selectBySeq",parent_seq);
	}

	public List<DReplyWithMemberDTO> selectDeptBySeq(int parent_seq){ 
		return db.selectList("Reply.selectDeptBySeq",parent_seq);
	}

	public int update(ReplyDTO dto) {
		return db.update("Reply.update",dto);
	}

	public int updateDept(DeptReplyDTO dto) {
		return db.update("Reply.updateDept",dto);
	}

	public int delete(Integer seq) {
		return db.delete("Reply.delete",seq);
	}

	public int deleteDept(Integer seq) {
		return db.delete("Reply.deleteDept",seq);
	}
}
