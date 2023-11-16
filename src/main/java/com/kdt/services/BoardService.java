package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.BoardDAO;
import com.kdt.dto.BoardDTO;
import com.kdt.dto.BoardWithFileDTO;
import com.kdt.dto.BoardWithMemberDTO;
import com.kdt.dto.DBoardWithDFileDTO;
import com.kdt.dto.DBoardWithMemberDTO;
import com.kdt.dto.DeptBoardDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;

	// 게시물 추가
	public BoardDTO insert(BoardDTO dto) {
		this.dao.insertBoard(dto);
		return dto;
	}

	public DeptBoardDTO insertDept(DeptBoardDTO dto) {
		this.dao.insertDept(dto);
		return dto;
	}

	// 특정 게시물 조회
	public BoardWithFileDTO selectBoardBySeq(Integer seq) {
		return this.dao.selectBoardBySeq(seq);
	}

	public DBoardWithDFileDTO selectDeptBySeq(Integer seq) {
		return this.dao.selectDeptBySeq(seq);
	}

	public BoardDTO selectUPdateBoardBySeq(Integer seq) {
		return this.dao.selectUPdateBoardBySeq(seq);
	}

	public DeptBoardDTO selectUpdateDeptBySeq(Integer seq) {
		return this.dao.selectUpdateDeptBySeq(seq);
	}

	// 모든 게시물 조회
	public List<BoardWithMemberDTO> selectBoardRecent() {
		return this.dao.selectBoardRecent();
	}

	public List<DBoardWithMemberDTO> selectDeptRecent(String dept) {
		return this.dao.selectDeptRecent(dept);
	}

	public List<BoardWithMemberDTO> selectBoardAllCom() {
		return this.dao.selectBoardAllCom();
	}

	public List<BoardWithMemberDTO> selectBoardAllComFree() {
		return this.dao.selectBoardAllComFree();
	}

	public List<DBoardWithMemberDTO> selectBoardAllDept(String dept) {
		return this.dao.selectBoardAllDept(dept);
	}

	public List<DBoardWithMemberDTO> selectBoardAllDeptFree(String dept) {
		return this.dao.selectBoardAllDeptFree(dept);
	}

	// 게시물 삭제
	public int deleteBoard(Integer seq) {
		return this.dao.deleteBoard(seq);
	}

	public int deleteDept(Integer seq) {
		return this.dao.deleteDept(seq);
	}

	// 게시물 삭제 시 댓글도
	public int deleteAll(Integer parent_seq) {
		return this.dao.deleteAll(parent_seq);
	}

	public int deleteDeptAll(Integer parent_seq) {
		return this.dao.deleteDeptAll(parent_seq);
	}

	// 게시물 수정
	public int updateBoard(BoardDTO dto) {
		return this.dao.updateBoard(dto);
	}

	public int updateDept(DeptBoardDTO dto) {
		return this.dao.updateDept(dto);
	}

	// ViewCount
	public int updateViewCount(Integer seq, Integer view_count) {
		return this.dao.updateViewCount(seq, view_count);
	}

	public int updateDeptViewCount(Integer seq, Integer view_count) {
		return this.dao.updateDeptViewCount(seq, view_count);
	}
}
