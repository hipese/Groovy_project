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
    public int addBoard(BoardDTO dto) {
        return this.dao.insertBoard(dto);
    }

    // 게시물 삭제
    public int deleteBoard(Integer seq) {
        return this.dao.deleteBoard(seq);
    }

    // 게시물 수정
    public int updateBoard(BoardDTO dto) {
        return this.dao.updateBoard(dto);
    }

    // 모든 게시물 조회
    public List<BoardDTO> selectBoardAll() {
        return this.dao.selectBoardAll();
    }

    // 특정 게시물 조회
    public BoardDTO selectBoardBySeq(Integer seq) {
    	return this.dao.selectBoardBySeq(seq);
    }
}
