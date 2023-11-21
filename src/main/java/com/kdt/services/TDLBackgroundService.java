package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.TDLBackgroundDAO;
import com.kdt.dto.TDLBackgroundDTO;

@Service
public class TDLBackgroundService {
	@Autowired
	private TDLBackgroundDAO tdlbdao;
	
	public int post(TDLBackgroundDTO dto) {
		return this.tdlbdao.post(dto);
	}
	public List<TDLBackgroundDTO> selectAll(String id) {
		return this.tdlbdao.selectAll(id);
	}
	public int update(TDLBackgroundDTO dto) {
		return this.tdlbdao.update(dto);
	}
}
