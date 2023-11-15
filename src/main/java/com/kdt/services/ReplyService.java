package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.ReplyDAO;
import com.kdt.dto.DReplyWithMemberDTO;
import com.kdt.dto.DeptReplyDTO;
import com.kdt.dto.ReplyDTO;
import com.kdt.dto.ReplyWithMemberDTO;

@Service
public class ReplyService {

	@Autowired
	private ReplyDAO dao;

	public ReplyDTO insert(ReplyDTO dto) {
		this.dao.insert(dto);
		return dto;
	}

	public DeptReplyDTO insertDept(DeptReplyDTO dto) {
		this.dao.insertDept(dto);
		return dto;
	}

	public List<ReplyWithMemberDTO> selectBySeq(Integer parent_seq) {
		return this.dao.selectBySeq(parent_seq);
	}

	public List<DReplyWithMemberDTO> selectDeptBySeq(Integer parent_seq) {
		return this.dao.selectDeptBySeq(parent_seq);
	}

	public int update(ReplyDTO dto) {
		return this.dao.update(dto);
	}

	public int updateDept(DeptReplyDTO dto) {
		return this.dao.updateDept(dto);
	}

	public int delete(Integer seq) {
		return this.dao.delete(seq);
	}

	public int deleteDept(Integer seq) {
		return this.dao.deleteDept(seq);
	}

}
