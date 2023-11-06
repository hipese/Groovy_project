package com.kdt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.Sign_filesDAO;
import com.kdt.dto.Sign_filesDTO;

@Service
public class Sign_filesService {

	@Autowired
	private Sign_filesDAO fdao;
	
	public int insert(Sign_filesDTO dto) {
		return fdao.insert(dto);
	}
}
