package com.kdt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.kdt.dto.PositionRankDTO;

@Repository
public class PositionRankDAO {
	
	@Autowired
	private SqlSession db;
	
	public List<PositionRankDTO> selectAll(){
		return db.selectList("PositionRank.selectAll");
	}
	
	public PositionRankDTO isRanking(String position) {
		PositionRankDTO dto=db.selectOne("PositionRank.ByRank", position);
	    return dto;
	}

}
