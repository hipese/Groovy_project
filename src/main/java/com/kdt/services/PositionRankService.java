package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kdt.dao.PositionRankDAO;
import com.kdt.dto.PositionRankDTO;

@Service
public class PositionRankService {
	
	@Autowired
	PositionRankDAO dao;
	
	public List<PositionRankDTO> selectAll(){
		return dao.selectAll();
	}
	
}
