package com.kdt.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kdt.dao.PositionRankDAO;
import com.kdt.dto.PositionRankDTO;

@Service
public class PositionRankService {
	
	@Autowired
	PositionRankDAO dao;
	
	public List<PositionRankDTO> selectAll(){
		return dao.selectAll();
	}
	
	@Transactional(readOnly = true) 
	public boolean isRanking(String position ,String myposition){
		PositionRankDTO mypositionRank=dao.isRanking(myposition);
		PositionRankDTO selectPositionRank=dao.isRanking(position);
		return mypositionRank.getRanks()>=selectPositionRank.getRanks()? true:false;
	}

}
