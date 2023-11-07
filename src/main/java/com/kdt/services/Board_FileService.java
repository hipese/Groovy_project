package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.Board_FileDAO;
import com.kdt.dto.Board_FileDTO;

@Service
public class Board_FileService {

	@Autowired
	private Board_FileDAO dao;
	
	public int insert(Board_FileDTO dto) {
		return dao.insert(dto);
	}

	public List<Board_FileDTO> selectBySeq(int parent_seq) {
		return dao.selectBySeq(parent_seq);
	}
}
