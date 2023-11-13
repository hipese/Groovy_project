package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.Board_FileDAO;
import com.kdt.dto.Board_FileDTO;
import com.kdt.dto.DeptBoard_FileDTO;

@Service
public class Board_FileService {

	@Autowired
	private Board_FileDAO dao;
	
	public int insert(Board_FileDTO dto) {
		return dao.insert(dto);
	}
	
	public int insertDept(DeptBoard_FileDTO dto) {
		return dao.insertDept(dto);
	}

	public List<Board_FileDTO> selectBySeq(int parent_seq) {
		return dao.selectBySeq(parent_seq);
	}
	
	public List<DeptBoard_FileDTO> selectDeptBySeq(int parent_seq) {
		return dao.selectDeptBySeq(parent_seq);
	}
}
