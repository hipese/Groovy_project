package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.TDLContentsDAO;
import com.kdt.dto.TDLContentsDTO;

@Service
public class TDLContentsService {
	@Autowired
	private TDLContentsDAO tdlcdao;
	
	public int post(TDLContentsDTO dto) {
		return this.tdlcdao.post(dto);
	}
	public List<TDLContentsDTO> selectAll(int parent_seq) {
		return this.tdlcdao.selectAll(parent_seq);
	}
	public int deleteAll(int parent_seq) {
		return this.tdlcdao.deleteAll(parent_seq);
	}
	public int delete(int seq) {
		return this.tdlcdao.delete(seq);
	}
}
