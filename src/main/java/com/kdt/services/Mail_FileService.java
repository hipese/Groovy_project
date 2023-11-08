package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.Mail_FileDAO;
import com.kdt.dto.Mail_FileDTO;

@Service
public class Mail_FileService {
	@Autowired
	private Mail_FileDAO dao;

	public int insert(Mail_FileDTO dto) {
		return dao.insert(dto);
	}

	public List<Mail_FileDTO> selectBySeq(int parent_seq) {
		return dao.selectBySeq(parent_seq);
	}
	
}
