package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.TDLBackgroundDTO;

@Repository
public class TDLBackgroundDAO {

	@Autowired
	private SqlSession ss;
	
	public int post(TDLBackgroundDTO dto) {
		return ss.insert("TDLBackground.insert", dto);
	}
	public List<TDLBackgroundDTO> selectAll(String id) {
		return ss.selectList("TDLBackground.selectAll", id);
	}
	public int update(TDLBackgroundDTO dto) {
		return ss.update("TDLBackground.update", dto);
	}
}
