package com.kdt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public int swcontents(TDLContentsDTO dto) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("order", dto.getOrder());
	    params.put("seq", dto.getSeq());
	    return ss.update("TDLContents.switch", params);
	}
	public int update(TDLContentsDTO dto) {
		return ss.update("TDLContents.update",dto);
	}
}
