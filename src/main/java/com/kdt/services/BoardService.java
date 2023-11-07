package com.kdt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.kdt.dto.BoardDTO;
import com.kdt.dao.BoardDAO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;

	// 게시물 추가
	public BoardDTO addBoard(BoardDTO dto) {
		this.dao.insertBoard(dto);
		return dto;
	}

	// 게시물 삭제
	public int deleteBoard(Integer seq) {
		return this.dao.deleteBoard(seq);
	}
	
	// ViewCount
	public int updateViewCount(Integer seq, Integer view_count) {
	    return this.dao.updateViewCount(seq, view_count);
	}

	// 게시물 수정
	public int updateBoard(BoardDTO dto) {
		return this.dao.updateBoard(dto);
	}

	// 모든 게시물 조회
	public List<BoardDTO> selectBoardRecent() {
		return this.dao.selectBoardRecent();
	}

	public List<BoardDTO> selectBoardAllCom() {
		return this.dao.selectBoardAllCom();
	}
	
	public List<BoardDTO> selectBoardAllComFree() {
		return this.dao.selectBoardAllComFree();
	}
	
	public List<BoardDTO> selectBoardAllDept() {
		return this.dao.selectBoardAllDept();
	}

	public List<BoardDTO> selectBoardAllDeptFree() {
		return this.dao.selectBoardAllDeptFree();
	}

	// 특정 게시물 조회
	public BoardDTO selectBoardBySeq(Integer seq) {
		return this.dao.selectBoardBySeq(seq);
	}
}
