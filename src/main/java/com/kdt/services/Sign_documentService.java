package com.kdt.services;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.Sign_documentDAO;
import com.kdt.dto.Sign_documentDTO;

@Service
public class Sign_documentService {
	@Autowired
	private Sign_documentDAO sdao;

	public int insert(Sign_documentDTO dto) {
		Timestamp date = new Timestamp(System.currentTimeMillis());
		dto.setWrite_date(date);
		return sdao.insert(dto);
	}
}
