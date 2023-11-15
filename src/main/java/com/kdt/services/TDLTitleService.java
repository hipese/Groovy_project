package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.TDLTitleDAO;
import com.kdt.dto.TDLTitleDTO;

@Service
public class TDLTitleService {

	@Autowired
	private TDLTitleDAO tdltdao;
	
	public int post(TDLTitleDTO dto) {
		return this.tdltdao.post(dto);
	}
	public List<TDLTitleDTO> selectAll(int parent_seq) {
		return this.tdltdao.selectAll(parent_seq);
	}
	public int delete(int seq) {
		return this.tdltdao.delete(seq);
	}
}
