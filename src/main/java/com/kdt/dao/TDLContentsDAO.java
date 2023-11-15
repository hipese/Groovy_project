package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.TDLContentsDTO;

@Repository
public class TDLContentsDAO {
	@Autowired
	private SqlSession ss;
	
	public int post(TDLContentsDTO dto) {
		return ss.insert("TDLContents.insert",dto);
	}
	public List<TDLContentsDTO> selectAll(int parent_seq) {
		return ss.selectList("TDLContents.selectAll",parent_seq);
	}
	public int deleteAll(int parent_seq) {
		return ss.delete("TDLContents.deleteAll", parent_seq);
	}
	public int delete(int seq) {
		return ss.delete("TDLContents.delete",seq);
	}
}
