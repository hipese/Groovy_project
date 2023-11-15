package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.TDLTitleDTO;

@Repository
public class TDLTitleDAO {
	@Autowired
	private SqlSession ss;
	
	public int post(TDLTitleDTO dto) {
		return ss.insert("TDLTitle.insert", dto);
	}
	public List<TDLTitleDTO> selectAll (int parent_seq) {
		return ss.selectList("TDLTitle.selectAll", parent_seq);
	}
	public int delete(int seq) {
		return ss.delete("TDLTitle.delete",seq);
	}
}
